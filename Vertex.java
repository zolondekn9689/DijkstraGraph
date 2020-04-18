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
     * @param name name of the vertex.
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

    /**
     * Get the color.
     * @return color.
     */
    public int getColor()
    {
        return this.color;
    }

    /**
     * Set the color
     * @param color color of the vertex.
     */
    public void setColor(int color)
    {
        this.color = color;
    }

    /**
     * Return if visited or not.
     * @return true or false.
     */
    public boolean isVisited()
    {
        return this.visited;
    }

    /**
     * getDistance(): int
     * @return get the distance.
     */
    public int getDistance()
    {
        return this.distance;
    }

    /**
     * setDistance(distance: int)
     * @param distance set the distance.
     */
    public void setDistance(int distance)
    {
        this.distance = distance;
    }


    /**
     * The toString method to print out the vertex.
     * @return the name and distance of the vertex.
     */
    @Override
    public String toString() {
        return name + ", " + getDistance();
    }

    /**
     * Compares between two objects.
     * Required to have o and Object. This is important for the
     * Comparable interface.
     * @param o comparing vertex.
     * @return 1 if this vertex is greater than o's
     * return -1 if this vertex is less than o.
     */
    @Override
    public int compareTo(Object o)
    {
        // Cast into a vertex.
        Vertex v = (Vertex) o;

        // Set the value 0.
        int value = 0;

        //if v is greater than distance return -1.
        if (distance < v.getDistance())
        {
            value = -1;
        } else if (distance > v.getDistance())
        {
            // If this vertex is greater than the other return 1.
            value = 1;
        }
        //Return the value.
        return value;

    }
}
