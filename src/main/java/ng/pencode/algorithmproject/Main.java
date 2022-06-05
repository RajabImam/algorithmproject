/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.pencode.algorithmproject;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author RAJAB IMAM
 */
public class Main {
    
     public static void main(String args[]) throws IOException{
        Scanner input = new Scanner(System.in);
        // Create a unweighted-digraphs
        System.out.println("Introduce the path where the graph-DFS-BFS.txt file is stored");
        String file = input.nextLine();
        if (file.isEmpty()) {file = "src/main/java/ng/pencode/algorithmproject/graph-DFS-BFS.txt";}

        Graph diGraph = GraphFactory.createDiGraphFromTextFile(file);
        System.out.println(diGraph.getGraphType());
        diGraph.printGraph();

        System.out.println("------------------------------------------");
        // Create a weighted-digraphs
        System.out.println("Introduce the path where the graph-WDG.txt file is stored");
        String file2 = input.nextLine();
        if (file2.isEmpty()) {file2 = "src/main/java/ng/pencode/algorithmproject/graph-WDG.txt";}

        Graph wdGraph = GraphFactory.createWDGraphFromTextFile(file2);
        System.out.println(wdGraph.getGraphType());
        wdGraph.printGraph();

        System.out.println("------------------------------------------");
        System.out.println("Test the dfs(.) function with the graph is the graph-DFS-BFS.txt file");
        List<Integer> result = diGraph.dfs(5, new HashSet<Integer>());
        System.out.println("Visited order form vertex 5: ");
        for (Integer vertex: result)
            System.out.print(vertex+"->" );
        System.out.println("End");

        System.out.println(DijkstraSP.verifyNonNegative((WDgraph) wdGraph));
        DijkstraSP dijkstraWDG = new DijkstraSP((WDgraph) wdGraph, 0);
        System.out.println(dijkstraWDG.hasPathTo(7));
        System.out.println(dijkstraWDG.distTo(7));
        dijkstraWDG.printSP(7);
     }
    
}
