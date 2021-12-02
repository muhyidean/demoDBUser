package com.example.demo.service;


import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.PostDto;
import com.example.demo.dto.UserDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<UserDto> getAll();

    public UserDto getById(long id);

    public void addUser(UserDto user);

    public List<PostDto> getPostsById(long id);

    public List<User> getUsersMoreThan( int num);

    public List<User> getUserByName(String name);

    public void deleteById(long id);

}
