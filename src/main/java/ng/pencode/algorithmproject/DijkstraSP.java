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
    float[] distance;

    /*
     * takes as input a weighted directed graph
     * and verifies that all weights in the graph
     * are non-negative.
     */
    public static boolean verifyNonNegative(WDgraph G) {
        for (List<DirectedEdge> list : G.edges) {
            for (DirectedEdge edge : list) {
                if (edge.getWeight() < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public DijkstraSP(WDgraph G, int s) {
        // If there is at least one negative edge, we prefer to not execute the
        // Dijkstra algorithm because we know we wouldn't find the correct shortest path
        if (!verifyNonNegative(G)) {
            System.out.println("The graph has negative value, so it is not possible to find the real shortest path");
            return;
        }

        // Initializing the visited nodes, distance and previous lists
        marked = new boolean[G.n];
        distance = new float[G.n];
        previous = new int[G.n];
        for (int i = 0; i < G.n; i++) {
            marked[i] = false;
            distance[i] = (i == s) ? 0 : Float.MAX_VALUE;
            previous[i] = -1;
        }

        boolean allVisitedNodes = false;

        while (!allVisitedNodes) { // We check if all the nodes have been visited
            // We initialize the current path and the current node
            float currentPath = Float.MAX_VALUE;
            int currentNode = -1;
            for (int i = 0; i < distance.length; i++) {
                if (!marked[i] && distance[i] < currentPath) {
                    currentNode = i;
                    currentPath = distance[currentNode];
                }
            }

            // We add the current node to the list of the visited node
            marked[currentNode] = true;

            // We now look at all the neighbours of the current nodes
            List<DirectedEdge> neighbours = G.edges.get(currentNode);
            for (DirectedEdge directedEdge : neighbours) {
                float distanceAlt = (float) (distance[currentNode] + directedEdge.getWeight());
                int destinationEdge = directedEdge.getW();
                if (distanceAlt < distance[destinationEdge]) {
                    distance[destinationEdge] = distanceAlt;
                    previous[destinationEdge] = currentNode;
                }
            }

            // We check if we have visited all the nodes
            allVisitedNodes = true;
            for (boolean isVisited : marked) {
                if (!isVisited) {
                    // At least one node hasn't benn visited yet
                    allVisitedNodes = false;
                    break;
                }
            }

        }
    }

    /**/
    public boolean hasPathTo(int v) {
        // If the node was marked, it should be visited
        // if a node is not visited at the end of the algorithm then there is no path
        return marked[v];
    }

    public float distTo(int v) {
        return distance[v];
    }

    public void printSP(int v) {
        if (!hasPathTo(v)) {
            System.out.println("No path to " + v);
            return;
        }
        if (previous[v] == -1) {
            System.out.println("Here is the shortest path : ");
            System.out.println(v + " ");
            return;
        }
        printSP(previous[v]);
        System.out.print(" → "+ v);
    }

}
