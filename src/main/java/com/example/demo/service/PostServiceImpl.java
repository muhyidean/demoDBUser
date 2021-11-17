package com.example.demo.service;


import com.example.demo.domain.Post;

import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAll(){

        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getById(long id){
        return postRepository.findById(id);
    }

    @Override
    public void addPost(Post post){
        postRepository.save(post);
    }

    @Override
    public void deletePost(long id){
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> findByAuthor(String author){
        return postRepository.findByAuthor(author);
    }

    @Override
    public void updatePost(long id, Post p){
        Optional<Post> existingPost = postRepository.findById(id);
        if(existingPost != null) {
            p.setId(id);
            postRepository.save(p);
        }
    }


}
