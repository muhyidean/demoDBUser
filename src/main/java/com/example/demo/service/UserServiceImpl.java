package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll() ;
    }

    @Override
    public Optional<User> getById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<Post> getPostsById(long id){
        return userRepository.getPostsById(id);
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

