package com.fipoka2.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Дима on 17.05.2017.
 */
@RestController
@RequestMapping("/login")
public class LoginController
{
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<String> CheckCredentials()
    {
        User activeUser = (User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        logger.info("User [" + activeUser.getUsername()+ "] has been authenticated.");
        return  new ResponseEntity<String>("You are successfully authtorized!",HttpStatus.OK);
    }

}
