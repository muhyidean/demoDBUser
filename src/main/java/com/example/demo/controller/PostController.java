package com.example.demo.controller;


import com.example.demo.domain.Post;
import com.example.demo.dto.PostDto;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Muhyieddin Altarawneh
 *
 */
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<PostDto> getAll(){
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable long id){
        return postService.getById(id);
    }

    @PostMapping
    public void addPost(@RequestBody PostDto post){
        postService.addPost(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody PostDto post){
        postService.updatePost(id, post);
    }














}
