package com.cg.javahdb.spring.entities.bing;

/**
 *
 * @author GBANGALO
 */

public class Point
{
    private String[] coordinates;

    public String[] getCoordinates ()
    {
        return coordinates;
    }

    public void setCoordinates (String[] coordinates)
    {
        this.coordinates = coordinates;
    }

    @Override
    public String toString()
    {
    	return String.join(" , ",coordinates);
    }
}
