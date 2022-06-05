/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.pencode.algorithmproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author RAJAB IMAM
 * 
 * Base abstract class for graph
 * <V> type of vertex
 * <E> type of edge
 */

public abstract class Graph<V extends Comparable<V>, E>{
    protected int n;
    protected int m;
    protected List<List<E>> edges;

    //Constructor
    public Graph() {
        edges = new ArrayList<List<E>>();
    }
    
    
    /* Parameterised Constructor with nbVertices as number of vertices
        and nbEdges as number of Edge
    */
    public Graph(int nbVertices, int nbEdges) {
        n = nbVertices;
        m = nbEdges;
        edges = new ArrayList<List<E>>();
    }
    
    /**
     * Get graph type
     * @return a string represent graph type
     */
    public abstract String getGraphType();

    /**
     * Add new Edge to graph
     */
    public abstract void addEdge(E edge);

    public void printGraph(){
        System.out.println("Number of Vertices "+this.n);
        System.out.println("Number of Edges "+this.m);
        for(int i=0; i< this.n; ++i){
            System.out.print("Vertex "+i+": ");
            for(E e: edges.get(i)){
                System.out.print(e.toString()+"; ");
            }
            System.out.println();
        }

    }

    public abstract List<V> dfs(V source, HashSet<V> setVisited);
   
}
