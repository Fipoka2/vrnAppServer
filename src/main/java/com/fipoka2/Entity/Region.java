package com.fipoka2.Entity;

/**
 * Created by Dmitry on 23.04.2017.
 */
public class Region
{
    private String region;
    private long idTeam;

    //TODO: Is region an ENUM value?

    public Region(String region, long idTeam)
    {
        this.region = region;
        this.idTeam = idTeam;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
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
