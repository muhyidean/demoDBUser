package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.PostDto;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDto> getAll() {
        return
                userRepository.findAll().stream()
                        .map(user -> modelMapper.map(user, UserDto.class))
                        .collect(Collectors.toList());
    }

    @Override
    public UserDto getById(long id) {
        return modelMapper.map(userRepository.findById(id).orElse(null),UserDto.class);
    }

    @Override
    public void addUser(UserDto user) {
        userRepository.save(modelMapper.map(user,User.class));
    }

    @Override
    public List<PostDto> getPostsById(long id){
        return
                userRepository.getPostsById(id).stream()
                        .map(post -> modelMapper.map(post,PostDto.class) )
                        .collect(Collectors.toList());
    }

    @Override
    public List<User> getUsersMoreThan(@RequestParam("num") int num){
        return userRepository.getUserPostMoreThan(num) ;
    }

    @Override
    public List<User> getUserByName(@RequestParam("name") String name){
        return userRepository.findByName(name) ;
    }


}

