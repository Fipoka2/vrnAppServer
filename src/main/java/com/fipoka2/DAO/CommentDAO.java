package com.fipoka2.DAO;

import com.fipoka2.Entity.Comment;

import java.util.Collection;

/**
 * Created by Дима on 04.05.2017.
 */
public interface CommentDAO
{
    Collection<Comment> getAllComments();
    Comment getCommentById(long id);
    void removeCommentById(long id);
    void updateComment(Comment comment);
    void insertCommentToDb(Comment comment);
}
