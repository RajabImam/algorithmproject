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

    /*
     * takes as input a weighted directed graph
     * and verifies that all weights in the graph
     * are non negative.
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
        // If there is a least one negative edge, we prefer to not execute the
        // Dijkstra algorithm because we know we wouldn't find the correct shortest path
        if (!verifyNonNegative(G)) {
            System.out.println("The graph has negative value, so it is not possible to find the real shortest path");
            return;
        }

        // Initializing the visited nodes list
        marked = new boolean[G.n];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = (i == s);
        }

        // Initializing the distance list
        distance = new int[G.n];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = (i == s) ? 0 : Integer.MAX_VALUE;
        }

        // Initializing the previous list
        previous = new int[G.n];
        for (int i = 0; i < previous.length; i++) {
            previous[i] = (i == s) ? s : -1;
        }

        boolean allVisitedNodes = false;

        while (!allVisitedNodes) { // We chack if all the nodes have been visited
            // We initialize the current path and the current node
            int currentPath = Integer.MAX_VALUE, currentNode = -1;
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
                int distanceAlt = (int) (distance[currentNode] + directedEdge.getWeight());
                int destinationEdge = directedEdge.getW();
                if (distanceAlt < distance[destinationEdge]) {
                    distance[destinationEdge] = distanceAlt;
                    previous[destinationEdge] = currentNode;
                }
            }

            // We check if we have visited all the nodes
            for (boolean isVisited : marked) {
                if (!isVisited) {
                    // At least one node hasn't benn visited yet
                    break;
                }
            }
            // All the nodes have been visited if we arrive here
            allVisitedNodes = true;
        }
    }

    /**/
    public boolean hasPathTo(int v) {
        // If the node was marked, it should be visited
        // if a node is not visited at the end of the algorithm then there is no path
        return !marked[v];
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
            System.out.println("There is no need to show the shortest path, because you are already in the destination");
        }
        String shortestPath = "";
        while (previous[v] != -1) {
            printSP(previous[v]);
        }
        System.out.println(v + " ");
    }

}
