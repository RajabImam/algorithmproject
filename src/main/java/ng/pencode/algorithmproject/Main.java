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

        Graph diGraph = GraphFactory.createDiGraphFromTextFile(file);
        System.out.println(diGraph.getGraphType());
        diGraph.printGraph();

        System.out.println("------------------------------------------");
        // Create a weighted-digraphs
        System.out.println("Introduce the path where the graph-WDG.txt file is stored");
        String file2 = input.nextLine();

        Graph wdGraph = GraphFactory.createWDGraphFromTextFile(file2);
        System.out.println(wdGraph.getGraphType());
        wdGraph.printGraph();

        System.out.println("------------------------------------------");
        System.out.println("Test the dfs(.) function with the graph is the graph-DFS-BFS.txt file");
        List<Integer> result = diGraph.dfs(5, new HashSet<Integer>());
        System.out.println("Visited order form vertex 5: ");
        for (Integer vertex: result)
            System.out.print(vertex+"->" );
        System.out.print("End");
    }
    
}
