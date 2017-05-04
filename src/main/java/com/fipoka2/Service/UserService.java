package com.fipoka2.Service;

import com.fipoka2.DAO.UserDaoImpl;
import com.fipoka2.Entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class UserService
{
    @Autowired
    private UserDaoImpl userDao;

    public Collection<User> getAllUsers()
    {
        return userDao.getAllUsers();
    }
    public User getUserByID(long id){
        return this.userDao.getUserById(id);
    }

    public void removeUserById(long id)
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
