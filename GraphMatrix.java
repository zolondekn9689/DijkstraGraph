package com.company;


import java.util.HashMap;
import java.util.PriorityQueue;

public class GraphMatrix
{
    private Vertex[] vertices;
    private int[][] edgeWeights;

    /**
     * GraphMatrix(Vertex[] vertices, int[][] edgeWeights)
     * @param vertices vertices.
     * @param edgeWeights the list of edge weights.
     */
    public GraphMatrix(Vertex[] vertices, int[][] edgeWeights)
    {
        this.vertices = vertices;
        this.edgeWeights = edgeWeights;
    }


    public void Dijkstra(int sourceIndex)
    {
        Vertex source = vertices[sourceIndex];
        PriorityQueue<Vertex> Q = new PriorityQueue<>();
        HashMap<Vertex, Vertex> predecessor = new HashMap<>();


        for (Vertex v : vertices)
        {
            int distance = Integer.MAX_VALUE;
            if (v == vertices[sourceIndex])
            {
                vertices[sourceIndex].setDistance(0);
            }
            Q.add(v);
        }

        while (!Q.isEmpty())
        {
            // Get the min distance and remove it from Q.
            Vertex u = Q.remove();

            //Find u index in vertices;
            int uIndex = -1;
            for (int i = 0; i < vertices.length; i++)
                if (vertices[i]==u) {
                    uIndex = i;
                }

            // For each neighbor V of u do
            for (int v = 0; v < vertices.length; v++)
            {
                // if v still in Q and edge from u to v.
                if (this.edgeWeights[uIndex][v]>0 && Q.contains(vertices[v]))
                {
                    //alt
                    int alt = u.getDistance() + edgeWeights[uIndex][v];

                    // if alt < dist[v]
                    if (alt < vertices[v].getDistance())
                    {

                        Q.remove(v);
                        vertices[v].setDistance(alt);
                        Q.add(vertices[v]);
                        predecessor.put(u, vertices[v]);

                    }

                }
            }

        }




        for (int i = 0; i < vertices.length; i++)
        {
            java.lang.String path = "";
            Vertex current = vertices[i];
            if (current != vertices[sourceIndex])
            {
                path = " - > " + current;

                while (predecessor.containsKey(current))
                {
                    if (predecessor.get(current) == source) {
                        path = predecessor.get(current) + path;
                    } else {
                        path = " -> " + predecessor.get(current) + path;
                    }
                    current = predecessor.get(current);
                }
            }
            System.out.println(path);

;        }




    }

    /**
     * toString method.
     * @return
     */
    @Override
    public String toString()
    {
        String arrow = " -> ";
        String comma = ", ";
        StringBuilder builder = new StringBuilder("Adjacency matrix for graph:\n");


        // Loop around the edge weights.
        for (int i = 0; i < edgeWeights.length; i++)
        {
            // Add the starter vertex.
            builder.append(vertices[i].getName());


            // Loop around the other edges.
            for (int j = 0; j < edgeWeights[i].length; j++)
            {

                // Only add a string if it is not the same vertex.
                if (i != j)
                {
                    builder.append(arrow);
                    builder.append(vertices[j].getName() + comma + edgeWeights[i][j]);
                }
            }
            builder.append("\n");
        }

        //Return the string that had been built.
        return builder.toString();
    }
}
