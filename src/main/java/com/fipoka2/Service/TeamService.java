package com.fipoka2.Service;

import com.fipoka2.DAO.TeamDAO;
import com.fipoka2.Entity.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TeamService
{
    @Autowired
    private TeamDAO teamDAO;

    public Collection<Team> getAllTeams(){
        return teamDAO.getAllTeams();
    }

    public Team getTeamById(int id){
        return this.teamDAO.getTeamById(id);
    }

    public Team getTeamByName(String name){
        return this.teamDAO.getTeamByName(name);
    }

    public void removeTeamById(int id)
    {
        this.teamDAO.removeTeamById(id);
    }

    public void removeTeamByName(String name)
    {
        this.teamDAO.removeTeamByName(name);
    }

    public void updateTeam(Team team)
    {
        this.teamDAO.updateTeam(team);
    }

    public void insertTeam(Team team)
    {
        teamDAO.insertTeamToDb(team);
    }

}
