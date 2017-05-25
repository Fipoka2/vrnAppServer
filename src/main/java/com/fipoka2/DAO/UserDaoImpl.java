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

    @Autowired
    TeamDAO teamDAO;

    private static class UserRowMapper implements RowMapper<User>
    {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException
        {
            User user = new User();
            user.setUserId(resultSet.getLong("id_user"));
            user.setNickname(resultSet.getString("nickname"));
            user.setPassword(resultSet.getString("password"));
            user.setIdPrivileges(resultSet.getLong("id_privileges"));
            user.setIdTeam(resultSet.getLong("id_team"));
            user.setFio(resultSet.getString("fio"));
            user.setCaptain(resultSet.getBoolean("is_captain"));

            return user;
        }
    }

    final String allColumns = "SELECT id_user,nickname,password,id_privileges,id_team,fio,is_captain FROM user ";

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
        //final String selectSQL = "SELECT id_team,is_captain from user where id_user = ?";
        final String sql = "DELETE FROM user WHERE id_user = ?";
        //final String rnmUser = "select id_user from user where id_team = ?";

        User user = getUserById(id);

        jdbcTemplate.update(sql,id);

        if (user.isCaptain())
        {
            if(teamDAO.getUsersAmountByTeam(user.getIdTeam()) > 0)
            {
                //TODO: переписать без костылей
                Collection<User> allTeamUsers  = getUsersByTeam(user.getIdTeam());
                User newCaptain = allTeamUsers.iterator().next();
                newCaptain.setCaptain(true);
                updateUser(newCaptain);
            }
            else {

                teamDAO.removeTeamById(user.getIdTeam());
            }
        }
        //jdbcTemplate.update(sql,id);
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
        final String sql = "INSERT INTO user (nickname,password,id_privileges,id_team,fio,is_captain) VALUES (?,?,?,?,?,?)";
        final String name = user.getNickname();
        final String password = user.getPassword();
        final long id_privileges = (user.getIdPrivileges()==0)?1:user.getIdPrivileges();
        final long id_team = user.getIdTeam();
        final String fio = user.getFio();
        final boolean is_captain = user.isCaptain();
        jdbcTemplate.update(sql,new Object[] {name,password,id_privileges,id_team,fio,is_captain});
    }

    public void setCaptainById(long id)
    {
        User futureUser = getUserById(id);
        for  (User user : getUsersByTeam(futureUser.getIdTeam()))
        {
            if (user.isCaptain())
            {
                user.setCaptain(false);
                updateUser(user);
            }
            futureUser.setCaptain(true);
            updateUser(futureUser);
        }

    }


}
