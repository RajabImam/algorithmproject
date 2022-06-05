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
public class FloydWarshall {
    double adjMatrix[][];
	
	public void floydWarshall(GraphImprovised g, int start, int end) {
		 adjMatrix = g.fromAdjListToAdjMatrix();
		 
		 for (int k = 0; k < g.n; k++) {
			 for (int i = 0; i < g.n; i++) {
				 for (int j = 0; j < g.n; j++) {
					 if (adjMatrix[i][k] + adjMatrix[k][j] < adjMatrix[i][j])
						 adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
				 }
			 }
		 }
		 
		 System.out.print(adjMatrix[start][end]);
		 printMatrix(adjMatrix);
	 }
	 
	 public static void printMatrix(double matrix[][]) {
		  for (int i = 0; i < matrix.length; i++){
		      for (int j = 0; j < matrix.length; j++){
				     if (matrix[i][j] == Double.MAX_VALUE)
						 System.out.print("INF ");
				    else 
						System.out.print(matrix[i][j] +" ");
				 }
		      System.out.println();
		  }
	 }
}
