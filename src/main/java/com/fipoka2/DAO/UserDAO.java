package com.fipoka2.DAO;

import com.fipoka2.Entity.User;

import java.util.Collection;

/**
 * Created by Dmitry on 23.04.2017.
 */
public interface UserDAO
{
    Collection<User> getAllUsers();
    Collection<User> getUsersByTeam(long idTeam);
    User getUserById(long id);
    User getUserByName(String name);
    void removeUserById(long id);
    void removeUserByName(String name);
    void updateUser(User user);
    void insertUserToDb(User user);

}
