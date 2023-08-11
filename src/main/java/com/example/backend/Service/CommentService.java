package com.example.backend.Service;

import com.example.backend.Entity.Comment;
import com.example.backend.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {this.commentRepository = commentRepository;}

    public Comment saveComment(Comment comment) {return commentRepository.save(comment);}
}
