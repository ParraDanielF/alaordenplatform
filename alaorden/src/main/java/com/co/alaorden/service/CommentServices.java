package com.co.alaorden.service;

import com.co.alaorden.model.CommentEntity;
import com.co.alaorden.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentServices {
    @Autowired
    CommentRepository commentRepository;

    public CommentEntity create(CommentEntity comment){
        return commentRepository.save(comment);
    }

    public CommentEntity read(Integer id){
        return commentRepository.findById(id).get();
    }

    public CommentEntity update(CommentEntity comment, Integer id){
        CommentEntity tmpComment = commentRepository.findById(id).get();
        tmpComment.setComment(comment.getComment());
        tmpComment.setContractId(comment.getContractId());
        tmpComment.setCreatedAt(comment.getCreatedAt());
        tmpComment.setUserId(comment.getUserId());
        return commentRepository.save(tmpComment);
    }

    public String delete(Integer id){
        commentRepository.deleteById(id);
        return commentRepository.findById(id).get() == null ?
                "Eliminado el comentario "+ id.toString() :
                "No se elimino el comentario " + id.toString() ;
    }
}
