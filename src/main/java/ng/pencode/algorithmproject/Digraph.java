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
 * Digraph to represent unweighted-digraphs
 */
public class Digraph extends Graph<Integer,Edge<Integer>>{

    public Digraph(String path) throws IOException{
        super();
        List<Edge<Integer>> edgeList = new ArrayList<Edge<Integer>>();
        // The file in that location is opened
        FileReader f = new FileReader(path);
        BufferedReader b = new BufferedReader(f);
        // Read the file
        String line=null;
        while ((line = b.readLine())!=null){
            String[] values = line.trim().split(" ");
            Edge<Integer> e = new Edge(Integer.parseInt(values[0]),Integer.parseInt(values[1]));
            edgeList.add(e);
        }
        // Calculate number of vertices and edges
        for (Edge<Integer> e: edgeList) {
            this.n = Math.max(this.n, e.from());
            this.n = Math.max(this.n, e.to());
        }
        // number of vertices
        this.n = this.n+1;
        // number of edges
        this.m = edgeList.size();
        // Add edges to graph
        for(int i=0; i<=n; ++i)
            edges.add(new ArrayList<Edge<Integer>>());
        for (Edge<Integer> e: edgeList) {
            addEdge(e);
        }
    }
    
        /**
     * Constructor
     * @param nbVertices number of Vertices
     * @param nbEdges number of Edges
     */
    public Digraph(int nbVertices, int nbEdges) {
        super(nbVertices, nbEdges);
    }
    

    @Override
    public String getGraphType() {
        return  "Digraph - unweighted-digraphs";
    }

    @Override
    public void addEdge(Edge<Integer> edge) {
         // Add edge corresponding to vertex source
        this.edges.get(edge.from()).add(edge);
        // Add edge corresponding to vertex destination
        Edge<Integer> edge2 = new Edge(edge.to(),edge.from());
        this.edges.get(edge2.from()).add(edge2);
    }

    @Override
    public List<Integer> dfs(Integer source, HashSet<Integer> setVisited) {
         setVisited.add(source);
        List<Integer> result = new ArrayList<>();
        result.add(source);

        for(Edge<Integer> e: edges.get(source)){
            int nextVertex = e.to();
            // if the next vertex has not been visited
            if (!setVisited.contains(nextVertex)) {
                // visit nextVertex
                List<Integer>  nextVisited = dfs(nextVertex, setVisited);
                // Add list visited vertex
                result.addAll(nextVisited);
            }
        }
        return result;
    }
    
}
