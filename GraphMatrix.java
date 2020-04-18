package com.company;


import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Nick Zolondek
 */
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


    /**
     *
     * @param sourceIndex starting index.
     */
    public void Dijkstra(int sourceIndex)
    {
        // Using these for easier to read statements.
        final String _ARROW = " -> ";
        final String _COMMA = ", ";

        // Vertex source = vertices[sourceIndex]
        Vertex source = vertices[sourceIndex];

        // create PriorityQueue<Vertex> predecessor.
        PriorityQueue<Vertex> Q = new PriorityQueue<>();

        // create a hashmap<vertex, vertex> predecessor.
        HashMap<Vertex, Vertex> predecessor = new HashMap<>();

        // for each vertex v in graph:
        for (Vertex v : vertices)
        {
            // dist[v] <- infinity
            v.setDistance(Integer.MAX_VALUE);

            // if v is source.
            if (v == source)
            {
                //set dist[source] = 0;
                source.setDistance(0);
            }
            // add v to Q.
            Q.add(v);
        }

        // While Q is not empty do
        while (!Q.isEmpty())
        {
            // Get the min distance and remove it from Q.
            Vertex u = Q.remove();

            //Find u index in vertices;
            int uIndex = -1;

            // uIndex <-- index of u in vertices.
            for (int i = 0; i < vertices.length; i++)
            {

                if (vertices[i]==u)
                {
                    uIndex = i;
                }
            }


            // For each neighbor V of u do
            for (int v = 0; v < vertices.length; v++)
            {
                // if v still in Q and edge from u to v.
                if (this.edgeWeights[uIndex][v]>0 && Q.contains(vertices[v]))
                {
                    // alt <-- dist[u] + length(u, v)
                    int alt = u.getDistance() + edgeWeights[uIndex][v];

                    // if alt < dist[v]:
                    if (alt < vertices[v].getDistance())
                    {
                        // remove v from Q.
                        Q.remove(vertices[v]);

                        // dist[v] <-- alt
                        vertices[v].setDistance(alt);

                        // add v to Q.
                        Q.add(vertices[v]);

                        // set u to be predecessor to v.
                        predecessor.put(vertices[v], u);

                    }

                }
            }

        } // end while loop.

        // printing algorithm 2 title.
        System.out.println("\nDistances from Vertex " + vertices[sourceIndex].getName() + ":");

        //Print out distance to each vertex from the source
        int j = vertices.length - 1;

        // Keep track of path.
        String p = "";

        //Current vertex.
        Vertex cur = vertices[j];

        // cur is not vertex from source index.
        if (cur != vertices[sourceIndex])
        {
            //Set the path.
            p = "\n" + cur;

            // while predecssor contains key(current)
            while (predecessor.containsKey(cur))
            {
                // Note to self. This affects only the starting index.
                if (predecessor.get(cur) == source)
                {
                    p = predecessor.get(cur).getName() + p;
                } else {
                    p = "\n" + predecessor.get(cur) + p;
                }

                //update current.
                cur = predecessor.get(cur);

            }
        }
        System.out.println(p);
        // End of printing the first printing statement of this algorithm.

        //Title for printing algorithm 3
        System.out.println("\nShortest paths from Vertex " + vertices[sourceIndex].getName() + ":");

        //Print out path from source to each vertex.
        //for each vertex current in vertices.
        //Note: For loop digs deep the higher the i is.
        for (int i = 0; i < vertices.length; i++)
        {
            // String path = "";
            String path = "";

            // store as the current.
            Vertex current = vertices[i];

            // predecessor contains key (current)
            if (current != vertices[sourceIndex])
            {
                // The ending index starts here.
                path = _ARROW + current;

                // while predecssor contains key(current)
                while (predecessor.containsKey(current))
                {
                    // Note to self: Only the starting index gets ran here.
                    if (predecessor.get(current) == source)
                    {
                        // path = predecessor get current + path.
                        path = predecessor.get(current).getName() + path;
                    }
                    else {
                        // All other indexes get started here.
                        path = _ARROW + predecessor.get(current) + path;
                    }
                    // current = predecessor get current.
                    current = predecessor.get(current);
                }
            }
            // print path.
            System.out.println(path);
;        }




    }

    /**
     * toString method.
     * @return string of the statement.
     */
    @Override
    public String toString()
    {
        // For convinence and easy to read.
        final String _ARROW = " -> ";
        final String _COMMA = ", ";
        final String _TITLE = "Adjacency matrix for graph:\n";

        //Use string builder for quicker appends.
        StringBuilder statement = new StringBuilder(_TITLE);


        // Loop vertexs.
        for (int vertex = 0; vertex < edgeWeights.length; vertex++)
        {
            // Add the starter vertex.
            statement.append(vertices[vertex].getName());


            // Loop around the other edges.
            for (int neighbors = 0; neighbors < edgeWeights[vertex].length; neighbors++)
            {

                // Avoid similiar repeating vertex index.
                if (vertex != neighbors)
                {
                    //Append the line.
                    statement.append(_ARROW);
                    statement.append(vertices[neighbors].getName());
                    statement.append(_COMMA);
                    statement.append(edgeWeights[vertex][neighbors]);
                }
            }
            // Add new line for each
            statement.append("\n");
        }

        // Return statement.
        return statement.toString();
    }
}
