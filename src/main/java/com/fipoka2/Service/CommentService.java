package com.fipoka2.Service;

import com.fipoka2.DAO.CommentDAO;
import com.fipoka2.Entity.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Дима on 19.05.2017.
 */
@Service
public class CommentService
{
    @Autowired
    CommentDAO commentDAO;

    public Collection<Comment> getAllComments()
    {
        return commentDAO.getAllComments();
    }
    public Comment getCommentById(long id){
        return this.commentDAO.getCommentById(id);
    }

    public void removeCommentById(long id)
    {
        this.commentDAO.removeCommentById(id);
    }
    public void updateComment(Comment comment){
        this.commentDAO.updateComment(comment);

    }

    public void insertComment(Comment comment)
    {
        commentDAO.insertCommentToDb(comment);
    }
    
    
}
