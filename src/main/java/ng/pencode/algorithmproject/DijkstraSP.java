/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.pencode.algorithmproject;

import java.util.List;

/**
 *
 * @author RAJAB IMAM
 */
public class DijkstraSP {
    
    boolean[] marked;
    int[] previous;
    int[] distance;

    /*  takes as input a weighted directed graph 
        and verifies that all weights in the graph 
        are non negative.
    */
    public static boolean verifyNonNegative(WDgraph G){
        for(List<DirectedEdge> list : G.edges) {
            for(DirectedEdge edge : list) {
                if (edge.getWeight() < 0) {return false;}
            }
        }
        return true;
    }

    public static void DijkstraSP(WDgraph G, int s) {

    }
    
    /**/
    public static boolean hasPathTo(int v){
        //temporary return value
        return false;
    }
    
    public static void printSP(int v){
        if (!hasPathTo(v)) {System.out.println("No path");}
    }
    
}
