package com.example.demo.service;


import com.example.demo.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    public List<Post> getAll();

    public Optional<Post> getById(long id);

    public void addPost(Post post);

    public void deletePost(long id);

    public List<Post> findByAuthor(String author);

    public void updatePost(long id, Post p);
}

