/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvement;

import java.io.IOException;

/**
 *
 * @author RAJAB IMAM
 */
public class TestRun {
    public static void main(String[] args) throws IOException {
		
		GraphImprovised graphMetro = new GraphImprovised(); //graph used in Part B
		
		int v = 0; //node
				
		//Part B
		graphMetro.fillGraphByFileMetroEdition(); 
	
		
		// BellmanFord algorithm
		
		System.out.println("\nPart B - BellmanFord");
		
		BellmanFord bf = new BellmanFord();
		
		bf = bf.BFAlBellmanFord(graphMetro, v);
		
		bf.printDistances(bf);
		
		//Part B3 - FloydWarshall algorithm
		
		System.out.println("\n - FloydWarshall");
		
		FloydWarshall fw = new FloydWarshall();
		
		//fw.floydWarshall(graphMetro, v, v2); //Uncomment to see it (the printed matrix is too big)
		
		
	}
    
}
