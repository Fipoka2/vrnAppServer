package com.fipoka2.Service;

import com.fipoka2.DAO.UserDaoImpl;
import com.fipoka2.Entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Дима on 28.04.2017.
 */
@Service
public class UserService
{
    @Autowired
    UserDaoImpl userDao;

    public Collection<User> getAllUsers()
    {
        return userDao.getAllUsers();
    }
    public User getUserByID(int id){
        return this.userDao.getUserById(id);
    }

    public void removeUserById(int id)
    {
        this.userDao.removeUserById(id);
    }
    public void updateUser(User user){
        this.userDao.updateUser(user);

    }

    public void insertUser(User user)
    {
        userDao.insertUserToDb(user);
    }


}
