package com.fipoka2.DAO;

import com.fipoka2.Entity.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;


public class TeamImpl implements TeamDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class TeamRowMapper implements RowMapper<Team>
    {
        @Override
        public Team mapRow(ResultSet resultSet, int i) throws SQLException
        {
            Team team = new Team();
            team.setIdTeam((resultSet.getLong("idTeam"));
            team.setName(resultSet.getString("name"));
            team.setScore(resultSet.getLong("score"));
            //TODO: getBytes vs getBlob vs getBinaryStream
            team.setTeamLogoPath(resultSet.getString("teamLogo"));
            team.setDescription(resultSet.getString("description"));
            return team;
        }
    }

    final String allColumns = "SELECT idTeam,name,score,teamLogo,description FROM team ";

    @Override
    public Collection<Team> getAllTeams()
    {
        final String sql = allColumns;
        List<Team> teams = jdbcTemplate.query(sql, new TeamImpl.TeamRowMapper());
        return teams;
    }

    @Override
    public Team getTeamById(long id)
    {
        final String sql = allColumns + "WHERE id = ?";
        Team Team = jdbcTemplate.queryForObject(sql, new TeamImpl.TeamRowMapper(),id);
        return Team;
    }

    @Override
    public Team getTeamByName(String name)
    {
        //name should be unique
        final String sql = allColumns + "WHERE name = ?";
        Team team = jdbcTemplate.queryForObject(sql, new TeamImpl.TeamRowMapper(),name);
        return team;
    }

    @Override
    public void removeTeamById(long id)
    {
        final String sql = "DELETE FROM team WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void removeTeamByName(String name)
    {
        final String sql = "DELETE FROM team WHERE name = ?";
        jdbcTemplate.update(sql,name);
    }

    @Override
    public void updateTeam(Team team)
    {
        final String sql = "INSERT INTO team (name,score,teamLogo,description) VALUES (?,?,?,?)";
        final String name = team.getName();
        final long score = team.getScore();
        final String teamLogo = team.getTeamLogoPath();
        final String description = team.getDescription();
        jdbcTemplate.update(sql,new Object[] {name,score,teamLogo,description});
    }

    @Override
    public void insertTeamToDb(Team team)
    {
        final String sql = "UPDATE team SET name = ?, score = ?, teamLogo = ?" +
                ", description = ? WHERE id = ?";
        final long id = team.getIdTeam();
        final String name = team.getName();
        final long score = team.getScore();
        final String teamLogo = team.getTeamLogoPath();
        final String description = team.getDescription();
        jdbcTemplate.update(sql,new Object[] {name,score,teamLogo,description,id});
    }
}
