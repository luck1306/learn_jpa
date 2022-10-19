package com.example.learn_jpa.entity.post.repository;

import com.example.learn_jpa.entity.post.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
