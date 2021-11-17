package com.example.demo.service;

import com.example.demo.domain.Post;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class Test {


    @PersistenceContext
    EntityManager entityManager;

    public void detachAndMerge(long id) {
        Post p = entityManager.find(Post.class, id);
        entityManager.detach(p); // try to remove here
        p.setAuthor("CHANGED");
        entityManager.merge(p);
        System.out.println("Detached " +p.getId() + " " + p.getAuthor());
    }

    public Post getSession(long id){
        Post p = entityManager.find(Post.class, id);
        System.out.print(p.getTitle());
        return p;
    }

    public void detachFromContext(long id) {
        Post p = entityManager.find(Post.class, id);
        entityManager.detach(p);
        p.setAuthor("CHANGED");
        System.out.println("Detached " +p.getId() + " " + p.getAuthor());
    }

    public void removeFromContext(long id) {
        Post p = entityManager.find(Post.class, id);
        entityManager.remove(p);
        System.out.println("Removed " +p.getId() + " " + p.getAuthor());
    }

    public void insertToContext(Post post) {
        entityManager.persist(post);
        System.out.println( "Persisted " + post.getId() + " " + post.getAuthor() );

    }

    public void changeToTran(long id) {
        Post p = entityManager.find(Post.class, id);
        p.setAuthor("Tran");
        System.out.println("Changed " +p.getId() + " " + p.getAuthor());
    }

//    Post p = entityManager.getReference(Post.class, id);
//    Post p = entityManager.find(Post.class, id);







}
