package com.example.demo.service;


import com.example.demo.domain.Post;

import com.example.demo.dto.PostDto;
import com.example.demo.helper.ListMapper;
import com.example.demo.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post,PostDto> listMapperPostToDto;

//    @Override
//    public List<PostDto> getAll(){
//        return
//        postRepository.findAll().stream()
//                .map(post -> modelMapper.map(post,PostDto.class) )
//                .collect(Collectors.toList());
//    }

    @Override
    public List<PostDto> getAll(){
        return (List<PostDto>) listMapperPostToDto.mapList(postRepository.findAll(),new PostDto());
    }

    @Override
    public PostDto getById(long id){
        return modelMapper.map(postRepository.findById(id).orElse(null), PostDto.class);

// This is left here for comparison
//        var data =  postRepository.findById(id);
//        PostDto dto = new PostDto(
//                data.get().getId(),
//                data.get().getTitle(),
//                data.get().getContent(),
//                data.get().getAuthor()
//        );
//        return dto;
    }

    @Override
    public void addPost(PostDto postDto){
        postRepository.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void deletePost(long id){
        postRepository.deleteById(id);
    }

    @Override
    public void updatePost( long id, PostDto p){
        p.setId(id);
        postRepository.save(modelMapper.map(p,Post.class));
    }
}
