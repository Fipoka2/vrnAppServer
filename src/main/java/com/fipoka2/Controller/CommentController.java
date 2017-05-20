package com.fipoka2.Controller;

import com.fipoka2.Entity.Comment;
import com.fipoka2.Service.CommentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RequestMapping("/comments")
@RestController
public class CommentController
{
    
    private Logger logger = LoggerFactory.getLogger(CommentController.class);
    
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Comment> getAllComments(){

        logger.info("collection of comments was successfully sent.");
        return commentService.getAllComments();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Comment getCommentById(@PathVariable("id") long id){
        logger.info("comment with id = " + id + " was successfully sent.");
        return commentService.getCommentById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)

    public void deleteCommentById(@PathVariable("id") int id){

        commentService.removeCommentById(id);
        logger.info("Comment with id = " + id + " was removed.");
    }

    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateComment(@RequestBody Comment comment){
        commentService.updateComment(comment);
        logger.info("Comment with id = was updated");
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertComment(@RequestBody Comment comment){

        try{
            commentService.insertComment(comment);}
        catch (DataAccessException ex)
        {
            logger.error("SQL Exception4",ex.toString());
            return new ResponseEntity<String>("empty field", HttpStatus.BAD_REQUEST);
        }
        logger.info("comment [" + comment.toString()+"] was created");
        return new ResponseEntity<String>("it is ok", HttpStatus.OK);
    }
}
