package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
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

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable long id){ return userService.getById(id); }

    @PostMapping
    public void addPost(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getPostsUser(@PathVariable long id) { return userService.getPostsById(id);
    }

    @Autowired
    PostService postService;
    /**
     *
     * This method has a flaw.
     *
     */
    @GetMapping("/{id}/posts/{pid}")
    public Optional<Post> getOnePostsUser(@PathVariable("pid") long id) { return postService.getById(id);
    }



    // FIXME *************** Just for testing ***************


    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @GetMapping("/dataload")
    public void cascadeTest(){
        User user = entityManager.find(User.class, 111l); // This will get the first user
        entityManager.detach(user);

        user.setName("CHANGED");
        user.getPosts().get(0).setAuthor("CHANGED");

        System.out.println(user.getName());
        System.out.println(user.getPosts().get(0).getAuthor());

        /**
         * Cascade Type:
         * Realize, since the user has been detached and the cascade type was
         * PERSIST only, it did not detach the posts corresponding to it
         * To prove this, go change the cascading type in the User class to
         * DETACH or ALL and realize how both (User and Post) will be detached.
         *
         * Fetching Type:
         * As for the fetch type, if you make it LAZY, it will throw an LazyInitializationException
         * due to the loading method is LAZY.
         * Now the reason was we detached the user before we made any calls to the Posts
         * it has, and the fetch type was LAZY. Therefore, the data was not fetched.
         * To make it work, try removing the detach command on line:56 and it will work
         * like charm.
         *
         *
         */
    }
        @GetMapping("/findUsersMoreThan")
        public List<User> getUsers(@RequestParam("num") int num){
            return userService.getUsersMoreThan(num);
        }

        @GetMapping("/findUserByName")
        public List<User> getUserByName(@RequestParam("name") String name){
            return userService.getUserByName(name) ;
        }

}
