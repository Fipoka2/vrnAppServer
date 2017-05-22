package com.fipoka2.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Dmitry on 22.04.2017.
 */

public class User
{
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long userId;

    private String nickname;


    @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long idPrivileges;

    private long idTeam;

    private String fio;

    private boolean isCaptain;

    public User(){}

    public User(long userId, String nickname, String password, long idPrivileges, long idTeam, String fio)
    {
        this.userId = userId;
        this.nickname = nickname;
        this.password = password;
        this.idPrivileges = idPrivileges;
        this.idTeam = idTeam;
        this.fio = fio;
    }
    public User( String nickname, String password,long priv,long idTeam, String fio){
        this.nickname = nickname;
        this.password = password;
        this.idTeam = idTeam;
        this.fio = fio;
        this.idPrivileges = priv;
    }


    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public long getIdPrivileges()
    {
        return idPrivileges;
    }

    public void setIdPrivileges(long idPrivileges)
    {

        this.idPrivileges = idPrivileges;
    }

    public long getIdTeam()
    {
        return idTeam;
    }

    public void setIdTeam(long idTeam)
    {
        this.idTeam = idTeam;
    }

    public String getFio()
    {
        return fio;
    }

    public void setFio(String fio)
    {
        this.fio = fio;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", idPrivileges='" + idPrivileges + '\'' +
                ", idTeam=" + idTeam +
                ", fio='" + fio + '\'' +
                '}';
    }
}
