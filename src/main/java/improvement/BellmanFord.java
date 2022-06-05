/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvement;

/**
 *
 * @author RAJAB IMAM
 */
public class BellmanFord {
    double[] distance; //distance from s to every node
	
	public BellmanFord BFAlBellmanFord(GraphImprovised g, int s) {
		BellmanFord bf = new BellmanFord();
		
		bf.distance = new double[g.n]; //distance of every node from node s
		
		int counter=0; //count the iteration of BellmanFord algorithm
		
		//1st phase - Initialization of the distance array
		for (int i=0; i<g.n; i++) { 
			if (i == s) {
				bf.distance[i] = 0; //d[s] = 0
			}
			else {
				bf.distance[i] = Double.MAX_VALUE; //d[i] for i not s = inf
			}
		}
		
		//2nd phase - Iteration (BellmanFord algorithm)
		while (counter < (g.n - 1)) {
			for (int i=0; i<g.n; i++) {
				for (int j=0; j<g.adj.get(i).size(); j++) {
					double distItoJ = g.adj.get(i).get(j).weight;
					double distTot = bf.distance[i] + distItoJ;
					int k = g.adj.get(i).get(j).value;
					
					if (distTot < bf.distance[k]) {
						bf.distance[k] = distTot;
					}
				}
			}
			
			counter++;
		}
		return bf;
	}
	
	public void printDistances(BellmanFord b) { //Function to print the shortest path (calculated with Dijkstra)
		System.out.println("\n-Final result BF-");
		System.out.println("\nDistances: ");
			
		for (int i=0; i<b.distance.length; i++) {
			System.out.println(i + " = " + b.distance[i]);
		}
	}
  
}
