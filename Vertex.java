package com.company;

import java.util.Comparator;

/**
 * Implement with comparable so I can adjust how I want to compare.
 */
public class Vertex implements Comparable
{

    private String name;
    private int color;
    private boolean visited;
    private int distance;

    //WHITE: int 1
    public static final int WHITE = 1;

    //GREEN: int 2
    public static final int GREEN = 2;

    // BLACK: int 3
    public static final int BLACK = 3;

    /**
     *
     * @param name
     */
    public Vertex(String name)
    {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName()
    {
        return this.name;
    }

    public int getColor()
    {
        return this.color;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    public boolean isVisited()
    {
        return this.visited;
    }

    /**
     * getDistance(): int
     * @return
     */
    public int getDistance()
    {
        return this.distance;
    }

    /**
     * setDistance(distance: int)
     * @param distance
     */
    public void setDistance(int distance)
    {
        this.distance = distance;
    }








    @Override
    public String toString() {
        return name + ", " + getDistance();
    }

    /**
     * Compares.
     * @param o comparing vertex.
     * @return 1 if this vertex is greater than o's
     * return -1 if this vertex is less than o.
     */
    @Override
    public int compareTo(Object o) {
        Vertex v = (Vertex) o;

        int value = 0;
        if (distance < v.getDistance())
        {
            value = -1;
        } else if (distance > v.getDistance())
        {
            value = 1;
        }
        return value;

    }
}
