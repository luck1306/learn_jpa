package com.example.learn_jpa.entity.post.repository;

import com.example.learn_jpa.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
