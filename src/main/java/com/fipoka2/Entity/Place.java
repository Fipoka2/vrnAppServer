package com.fipoka2.Entity;

import java.awt.Point;

/**
 * Created by Dmitry on 23.04.2017.
 */
public class Place
{
    private long idPlace;
    private String name;
    private Point location;

    public Place(long idPlace, String name, Point location)
    {
        this.idPlace = idPlace;
        this.name = name;
        this.location = location;
    }

    public long getIdPlace()
    {
        return idPlace;
    }

    public void setIdPlace(long idPlace)
    {
        this.idPlace = idPlace;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Point getLocation()
    {
        return location;
    }

    public void setLocation(Point location)
    {
        this.location = location;
    }
}
