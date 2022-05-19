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
 * A default implementation for edges
 * @param <V> vertex type
 */
public class Edge<V> {
     private  final  V source, destination;
    public  Edge(V s, V d){
        this.source = s;
        this.destination = d;
    }
    public V from() {return  source;}
    public V to() { return  destination;}


    /**
     * Returns a string representation of the directed edge.
     * @return a string representation of the directed edge
     */
    public String toString() {
        return source + "-" + destination;
    }
}
