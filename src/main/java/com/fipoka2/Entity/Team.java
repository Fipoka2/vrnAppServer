package com.fipoka2.Entity;

/**
 * Created by Dmitry on 22.04.2017.
 */

public class Team
{
    private long idTeam;
    private String name;
    private long score;
    private byte[] teamLogo;
    //TODO: teamLogo is a picture from a database
    private String description;

    public Team(long idTeam, String name, long score, byte[] teamLogo, String description)
    {
        this.idTeam = idTeam;
        this.name = name;
        this.score = score;
        this.teamLogo = teamLogo;
        this.description = description;
    }

    public Team(){}

    public long getIdTeam()
    {
        return idTeam;
    }

    public void setIdTeam(long idTeam)
    {
        this.idTeam = idTeam;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getScore()
    {
        return score;
    }

    public void setScore(long score)
    {
        this.score = score;
    }

    public byte[] getTeamLogo()
    {
        return teamLogo;
    }

    public void setTeamLogo(byte[] teamLogo)
    {
        this.teamLogo = teamLogo;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
