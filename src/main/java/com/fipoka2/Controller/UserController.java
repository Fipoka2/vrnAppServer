package com.fipoka2.Controller;

import com.fipoka2.Entity.User;
import com.fipoka2.Service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Дима on 28.04.2017.
 */
@RestController
@RequestMapping("/users")
public class UserController
{
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    Collection<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") long id){
        return userService.getUserByID(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable("id") long id){
        userService.removeUserById(id);
        return "deleted";
    }

    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateUser(@RequestBody User user){
        userService.updateUser(user);
        return "updated";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> insertUser(@RequestBody User user)
    {
        logger.info("start inserting");
        logger.info(user.toString());
        try{
        userService.insertUser(user);} catch (DataAccessException ex)
        {
            logger.error("SqlException: ",ex);
            return new ResponseEntity<String>("Error! Check your fields!", HttpStatus.OK);
        }
        logger.info("inserted",user);
        return new ResponseEntity<String>("Success!", HttpStatus.OK);

    }
    
}
