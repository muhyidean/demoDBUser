package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.PostDto;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @GetMapping
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable long id){ return userService.getById(id); }

    @PostMapping
    public void addPost(@RequestBody UserDto user){
        userService.addUser(user);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getPostsUser(@PathVariable long id) { return userService.getPostsById(id);
    }

    @GetMapping("/{id}/posts/{pid}")
    public PostDto getOnePostsUser(@PathVariable("pid") long id) { return postService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id){
        userService.deleteById(id);
    }

    @GetMapping("/admin")
    public String inValidTest2(){
        return "OK";
    }

}
