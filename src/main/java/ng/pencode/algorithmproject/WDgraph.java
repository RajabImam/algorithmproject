/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.pencode.algorithmproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author RAJAB IMAM
 * 
 *         A class called WDgraph to represent weighted-digraphs
 */
public class WDgraph extends Graph<Integer, DirectedEdge> {
    /**
     * Constructor, create weighted-digraphs from text file
     * 
     * @param path file path
     */
    public WDgraph(String path) throws IOException {
        super();
        List<DirectedEdge> edgeList = new ArrayList<DirectedEdge>();
        // The file in that location is opened
        FileReader f = new FileReader(path);
        BufferedReader b = new BufferedReader(f);
        // Read the file
        String line = null;
        while ((line = b.readLine()) != null) {
            String[] values = line.trim().split(" ");
            DirectedEdge e = new DirectedEdge(Integer.parseInt(values[0]), Integer.parseInt(values[1]),
                    Double.parseDouble(values[2]));
            edgeList.add(e);
        }
        // Calculate number of vertices and edges
        for (DirectedEdge e : edgeList) {
            this.n = Math.max(this.n, e.getV());
            this.n = Math.max(this.n, e.getW());
        }
        // number of vertices
        this.n = this.n + 1;
        // number of edges
        this.m = edgeList.size();
        // Add edges to graph
        for (int i = 0; i <= n; ++i)
            edges.add(new ArrayList<DirectedEdge>());
        for (DirectedEdge e : edgeList) {
            addEdge(e);
        }
    }

    /**
     * Constructor
     * 
     * @param nbVertices number of Vertices
     * @param nbEdges    number of Edges
     */
    public WDgraph(int nbVertices, int nbEdges) {
        super(nbVertices, nbEdges);
    }

    /**
     * Get graph type
     * 
     * @return a string represent graph type
     */
    @Override
    public String getGraphType() {
        return "WDgraph - weighted-digraphs";
    }

    /**
     * Add new edge to weighted-digraphs
     * 
     * @param edge new directed edge
     */
    @Override
    public void addEdge(DirectedEdge edge) {
        // The entry corresponding to vertex v
        // will contain the list of all the outgoing arcs and the associated weights
        this.edges.get(edge.getV()).add(edge);
    }

    @Override
    public List<Integer> dfs(Integer source, HashSet<Integer> setVisited) {
        setVisited.add(source);
        List<Integer> result = new ArrayList<>();
        result.add(source);

        for (DirectedEdge e : edges.get(source)) {
            int nextVertex = e.getW();
            // if the next vertex has not been visted
            if (!setVisited.contains(nextVertex)) {
                // visit nextVertex
                List<Integer> nextVisited = dfs(nextVertex, setVisited);
                // Add list visited vertex
                result.addAll(nextVisited);
            }
        }
        return result;
    }

}
