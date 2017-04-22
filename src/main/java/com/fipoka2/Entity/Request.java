package com.fipoka2.Entity;

import java.util.Date;

/**
 * Created by Dmitry on 23.04.2017.
 */
public class Request
{
    private long idRequest;
    private long idUser;
    private long idTeam;
    private String message;
    private Date datetime;

    public Request(long idRequest, long idUser, long idTeam, String message, Date datetime)
    {
        this.idRequest = idRequest;
        this.idUser = idUser;
        this.idTeam = idTeam;
        this.message = message;
        this.datetime = datetime;
    }

    public long getIdRequest()
    {
        return idRequest;
    }

    public void setIdRequest(long idRequest)
    {
        this.idRequest = idRequest;
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

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Date getDatetime()
    {
        return datetime;
    }

    public void setDatetime(Date datetime)
    {
        this.datetime = datetime;
    }
}
