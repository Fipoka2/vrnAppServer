package com.fipoka2.Controller;

import com.fipoka2.Entity.User;
import com.fipoka2.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserService userService;

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

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> insertUser(@RequestBody User user)
    {
        System.out.println("start inserting");
        System.out.println(user.toString());
        try{
        userService.insertUser(user);}catch(Exception ex)
        {
            System.out.println("SqlException");
            return new ResponseEntity<String>("Da ti ohuel chtoli", HttpStatus.OK);
        }
        System.out.println("inserted");
        return new ResponseEntity<String>("Vse zaebis proshlo", HttpStatus.OK);

    }
    
}
