package com.fipoka2.Entity;

/**
 * Created by Dmitry on 22.04.2017.
 */

public class Team
{
    //поле только для отправления на клиент (запрет на прием поля отправленного клиентом)
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long idTeam;

    private String name;

    private long score;

    private String teamLogoPath;

    private String description;

    public Team(long idTeam, String name, long score, String teamLogo, String description)
    {
        this.idTeam = idTeam;
        this.name = name;
        this.score = score;
        this.teamLogoPath = teamLogo;
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

    public String getTeamLogoPath()
    {
        return teamLogoPath;
    }

    public void setTeamLogoPath(String teamLogo)
    {
        this.teamLogoPath = teamLogo;
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
