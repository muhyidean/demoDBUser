package com.example.demo.service;


import com.example.demo.domain.Post;
import com.example.demo.dto.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostService {

    public List<PostDto> getAll();

    public PostDto getById(long id);

    public void addPost(PostDto postDto);

    public void deletePost(long id);

    public List<PostDto> findByAuthor(String author);

    public void updatePost(long id, Post p);
}

