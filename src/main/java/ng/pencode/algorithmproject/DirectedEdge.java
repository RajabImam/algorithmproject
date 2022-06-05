/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.pencode.algorithmproject;

/**
 *
 * @author RAJAB IMAM
 * 
 * Implementation for edge in weighted digraphs.
 * where v represents the source vertex, w the destination vertex and weight the edge-weight
 */
public class DirectedEdge {
    private final int v;
    private  final int w;
    private  final  double weight;

    /**
     * Initializes a directed edge from vertex {v} to vertex {w}
     * @param s source vertex
     * @param d destination vertex
     * @param weight edge-weight
     */
    public  DirectedEdge(int s, int d, double weight){
        this.v = s;
        this.w = d;
        this.weight = weight;
    }

    /**
     * The getter functions for the source vertex
     * @return source vertex
     */
    public int getV() {
        return v;
    }

    /**
     * The getter functions for the destination vertex
     * @return the destination vertex
     */
    public int getW() {
        return w;
    }

    /**
     * The getter functions for the the edge-weight
     * @return the edge-weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns a string representation of the directed edge.
     * @return a string representation of the directed edge
     */
    public String toString() {
        return v + " → " + w + " " + String.format("%5.2f", weight);
    }
}
