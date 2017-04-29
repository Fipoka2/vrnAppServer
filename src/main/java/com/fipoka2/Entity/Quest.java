package com.fipoka2.Entity;

import java.util.Date;

/**
 * Created by Dmitry on 23.04.2017.
 */
public class Quest
{
    private long idQuest;

    private String name;

    private String description;

    private long idPlace;

    private long idAdministrator;

    private Date launchDate;

    private long reward;

    private boolean isAble;

    public Quest(long idQuest, String name, String description, long idPlace, long idAdministrator, Date launchDate, long reward, boolean isAble)
    {
        this.idQuest = idQuest;
        this.name = name;
        this.description = description;
        this.idPlace = idPlace;
        this.idAdministrator = idAdministrator;
        this.launchDate = launchDate;
        this.reward = reward;
        this.isAble = isAble;
    }

    public long getIdQuest()
    {
        return idQuest;
    }

    public void setIdQuest(long idQuest)
    {
        this.idQuest = idQuest;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public long getIdPlace()
    {
        return idPlace;
    }

    public void setIdPlace(long idPlace)
    {
        this.idPlace = idPlace;
    }

    public long getIdAdministrator()
    {
        return idAdministrator;
    }

    public void setIdAdministrator(long idAdministrator)
    {
        this.idAdministrator = idAdministrator;
    }

    public Date getLaunchDate()
    {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate)
    {
        this.launchDate = launchDate;
    }

    public long getReward()
    {
        return reward;
    }

    public void setReward(long reward)
    {
        this.reward = reward;
    }

    public boolean isAble()
    {
        return isAble;
    }

    public void setAble(boolean able)
    {
        isAble = able;
    }
}
