package com.example.demo.service;


import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAll();

    public Optional<User> getById(long id);

    public void addUser(User user);

    public List<Post> getPostsById(long id);


    public List<User> getUsersMoreThan( int num);

    public List<User> getUserByName(String name);

}
