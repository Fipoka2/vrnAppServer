package com.fipoka2.DAO;

import com.fipoka2.Entity.Team;

import java.util.Collection;

public interface TeamDAO
{
    Collection<Team> getAllTeams();
    Team getTeamById(long id);
    Team getTeamByName(String name);
    void removeTeamById(long id);
    void removeTeamByName(String name);
    void updateTeam(Team team);
    void insertTeamToDb(Team team);
}
