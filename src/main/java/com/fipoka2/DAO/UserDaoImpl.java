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
            User.setUserId(resultSet.getLong("id_user"));
            User.setNickname(resultSet.getString("nickname"));
            User.setPassword(resultSet.getString("password"));
            User.setIdPrivileges(resultSet.getLong("id_privileges"));
            User.setIdTeam(resultSet.getLong("id_team"));
            User.setFio(resultSet.getString("fio"));
            return User;
        }
    }

    final String allColumns = "SELECT id_user,nickname,password,id_privileges,id_team,fio FROM user ";

    @Override
    public Collection<User> getAllUsers()
    {
        final String sql = allColumns;
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
        return users;
    }

    @Override
    public Collection<User> getUsersByTeam(long id_team)
    {
        final String sql = allColumns + "WHERE id_team = ?";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(),id_team);
        return users;
    }

    @Override
    public User getUserById(long id)
    {
        final String sql = allColumns + " WHERE id_user = ?";
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
        final String sql = "DELETE FROM user WHERE id_user = ?";
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
        final String sql = "UPDATE user SET nickname = ?, password = ?, id_privileges = ?, id_team = ?, fio = ? WHERE id_user = ?";
        final String name = user.getNickname();
        final String password = user.getPassword();
        final long id_privileges = user.getIdPrivileges();
        final long id_team = user.getIdTeam();
        final String fio = user.getFio();
        final long id = user.getUserId();
        jdbcTemplate.update(sql,new Object[] {name,password,id_privileges,id_team,fio,id});
    }

    @Override
    public void insertUserToDb(User user)
    {
        final String sql = "INSERT INTO user (nickname,password,id_privileges,id_team,fio) VALUES (?,?,?,?,?)";
        final String name = user.getNickname();
        final String password = user.getPassword();
        final long id_privileges = user.getIdPrivileges();
        final long id_team = user.getIdTeam();
        final String fio = user.getFio();
        jdbcTemplate.update(sql,new Object[] {name,password,id_privileges,id_team,fio});
    }


}
