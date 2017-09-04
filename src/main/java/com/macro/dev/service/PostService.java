package com.macro.dev.service;

import com.macro.dev.models.LutUser;
import com.macro.dev.models.Post;
import com.macro.dev.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void insert(Post post) {
        postRepository.save(post);
    }

    public List<Post> findByUser(LutUser user){
        return postRepository.findByCreatorId(user.getId());
    }

    public boolean deletePost(Long postId){
        Post thePost = postRepository.findOne(postId);
        if(thePost == null)
            return false;
        postRepository.delete(postId);
        return true;
    }

    public Post getPost(Long id) {
        return postRepository.findOne(id);
    }

    public Post find(Long postId) {
        return postRepository.findOne(postId);
    }
}