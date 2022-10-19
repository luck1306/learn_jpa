package com.example.learn_jpa.entity.comment.repository;

import com.example.learn_jpa.entity.comment.Comment;
import com.example.learn_jpa.entity.comment.CommentId;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, CommentId> {
}
