package com.fipoka2.Entity;

/**
 * Created by Dmitry on 23.04.2017.
 */
public class TeamCaptain
{
    private long idTeamCaptain;
    private long idUser;
    private long idTeam;

    public TeamCaptain(long idTeamCaptain, long idUser, long idTeam)
    {
        this.idTeamCaptain = idTeamCaptain;
        this.idUser = idUser;
        this.idTeam = idTeam;
    }

    public long getIdTeamCaptain()
    {
        return idTeamCaptain;
    }

    public void setIdTeamCaptain(long idTeamCaptain)
    {
        this.idTeamCaptain = idTeamCaptain;
    }

    public long getIdUser()
    {
        return idUser;
    }

    public void setIdUser(long idUser)
    {
        this.idUser = idUser;
    }

    public long getIdTeam()
    {
        return idTeam;
    }

    public void setIdTeam(long idTeam)
    {
        this.idTeam = idTeam;
    }
}
