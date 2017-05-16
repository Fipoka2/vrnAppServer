package com.fipoka2.DAO;

import com.fipoka2.Entity.Comment;

import java.util.Collection;

/**
 * Created by Дима on 04.05.2017.
 */
public interface CommentDAO
{
    Collection<Comment> getAllComments();
    Collection<Comment> getCommentsByUser(long idUser);
    Comment getCommentById(long id);
    Comment getCommentByName(String name);
    void removeCommentById(long id);
    void removeCommentByName(String name);
    void updateComment(Comment user);
    void insertCommentToDb(Comment user);
}
