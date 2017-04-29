package com.fipoka2.DAO;

import com.fipoka2.Entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class UserRowMapper implements RowMapper<User>
    {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException
        {
            User User = new User();
            User.setUserId(resultSet.getLong("idUser"));
            User.setNickname(resultSet.getString("name"));
            User.setPassword(resultSet.getString("password"));
            User.setPrivileges(resultSet.getString("privileges"));
            User.setIdTeam(resultSet.getLong("idTeam"));
            User.setFio(resultSet.getString("FIO"));
            return User;
        }
    }

    final String allColumns = "SELECT idUser,nickname,password,privileges,idTeam,FIO FROM user ";

    @Override
    public Collection<User> getAllUsers()
    {
        final String sql = allColumns;
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
        return users;
    }

    @Override
    public Collection<User> getUsersByTeam(long idTeam)
    {
        final String sql = allColumns + "WHERE idTeam = ?";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(),idTeam);
        return users;
    }

    @Override
    public User getUserById(long id)
    {
        final String sql = allColumns + "WHERE id = ?";
        User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(),id);
        return user;
    }

    @Override
    public User getUserByName(String name)
    {
        //name should be unique
        final String sql = allColumns + "WHERE nickname = ?";
        User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(),name);
        return user;
    }

    @Override
    public void removeUserById(long id)
    {
        final String sql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void removeUserByName(String name)
    {
        final String sql = "DELETE FROM user WHERE nickname = ?";
        jdbcTemplate.update(sql,name);
    }

    @Override
    public void updateUser(User user)
    {
        final String sql = "INSERT INTO student (nickname,password,privileges,idTeam,FIO) VALUES (?,?,?,?,?)";
        final String name = user.getNickname();
        final String password = user.getPassword();
        final String privileges = user.getPrivileges();
        final long idTeam = user.getIdTeam();
        final String FIO = user.getFio();
        jdbcTemplate.update(sql,new Object[] {name,password,privileges,idTeam,FIO});
    }

    @Override
    public void insertUserToDb(User user)
    {
        final String sql = "UPDATE User SET nickname = ?, password = ?, privileges = ?" +
                ", idTeam = ?, FIO = ? WHERE id = ?";
        final long id = user.getUserId();
        final String name = user.getNickname();
        final String password = user.getPassword();
        final String privileges = user.getPrivileges();
        final long idTeam = user.getIdTeam();
        final String FIO = user.getFio();
        jdbcTemplate.update(sql,new Object[] {name,password,privileges,idTeam,FIO,id});

    }
}
