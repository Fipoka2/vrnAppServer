package com.fipoka2.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Dmitry on 22.04.2017.
 */

public class User
{
    private long userId;

    private String nickname;


    @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String privileges;
    //TODO: long or string? Privileges table doesn't exist but idPrivileges

    private long idTeam;

    private String fio;

    public User(){}

    public User(long userId, String nickname, String password, String privileges, long idTeam, String fio)
    {
        this.userId = userId;
        this.nickname = nickname;
        this.password = password;
        this.privileges = privileges;
        this.idTeam = idTeam;
        this.fio = fio;
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

    public String getPrivileges()
    {
        return privileges;
    }

    public void setPrivileges(String privileges)
    {

        this.privileges = privileges;
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
}
