package com.example.demo.controller;


import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.service.PostService;
import com.example.demo.service.Test;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * @Author Muhyieddin Altarawneh
 *
 * This is an implementation for educational purposes to illustrate the transactions
 * of the entity manager
 */
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getAll(){
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> getById(@PathVariable long id){
        return postService.getById(id);
    }

    @PostMapping
    public void addPost(@RequestBody Post post){
        postService.addPost(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Post post){
        postService.updatePost(id, post);
    }


   // After this line jsut for education.
    /*
     */
   @Autowired
   Test test;

    @GetMapping("/author")
    public List<Post> findByAuthor(@RequestBody String author){
        System.out.println(author);
        return postService.findByAuthor(author);
    }

    @PostMapping("/persist")
    public void insertToContext(@RequestBody  Post post){
        test.insertToContext(post);
    }

    @GetMapping("/remove/{id}")
    public void removeFromContext(@PathVariable long id){
        test.removeFromContext(id);
    }

    @PostMapping("/detach/{id}")
    public void detachFromContext(@PathVariable long id){
        test.detachFromContext(id);
    }

    @PostMapping("/check/{id}")
    public Post check(@PathVariable long id){
        return test.getSession( id);
    }

    @GetMapping("/change/{id}")
    public void changePersisted(@PathVariable long id){
        test.changeToTran( id);
    }


    @GetMapping("/detachAndMerge/{id}")
    public void detachAndMerge(@PathVariable long id){
         test.detachAndMerge(id);
    }












}
