/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author RAJAB IMAM
 */
public class GraphImprovised {
    protected int n; //Number of nodes
	protected int m; //Number of edges
	protected List<List<Node>> adj; //Adjacency list
	
	public GraphImprovised(int nbVertices, int nbEdges) { //Initialize an empty graph
		n = nbVertices;
		m = nbEdges;
	}
	
	public GraphImprovised() { //When you don't know the number of nodes and edges (reading from file)
		
	}
	
	//Function to fill a graph by a .txt file
	public void fillGraphByFile(File path) throws IOException {
		Scanner scanner = new Scanner(path); //scanner 1
		Scanner toFindMax = new Scanner(path); //scanner 2
		
		int max = 0; //Max node value in the file
		
		//To find the number of nodes in the graph by reading the file
		while (toFindMax.hasNextLine()) {
			String line = toFindMax.nextLine(); //get all the line
			String lineItem[] = line.split(" "); //separate the elements of the line
			int v1 = Integer.parseInt(lineItem[0]); //vertex 1
			int v2 = Integer.parseInt(lineItem[1]); //vertex 2
			Double.parseDouble(lineItem[2]); //weight (to discard in this case)
			
			if (max < v1) {
				max = v1;
			}
			if (max < v2) {
				max = v2;
			}
		}
		
		toFindMax.close();
		
		n = max+1;
		m = 0;
		
		//Adjacency list allocation
		adj = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			adj.add(new ArrayList<>());
		}
		
		//Filling the adjacency list of the graph
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] lineItem = line.split(" ");
			int value1 = Integer.parseInt(lineItem[0]); //vertex 1
			int value2 = Integer.parseInt(lineItem[1]); //vertex 2
			double weight = Double.parseDouble(lineItem[2]); //weight
			
			adj.get(value1).add(new Node(value2, weight)); 
			m++; //edges++
		}
		
		scanner.close();
	}
	
	//Function to fill a graph by a .txt file
	public void fillGraphByFileMetroEdition() throws IOException {
		File path = new File("C:\\Users\\RAJAB IMAM\\Documents\\NetBeansProjects\\AlgorithmProject\\src\\main\\java\\subway\\metro.txt");
			
		Scanner scanner = new Scanner(path); //scanner 1
		
		String values = scanner.nextLine();
		String[] valuesItem = values.split(" ");
		
		n = Integer.parseInt(valuesItem[0]); //number of nodes
		m = Integer.parseInt(valuesItem[1]); //number of edges
			
		List<Metro> stationList = new ArrayList<>();
		
		int counter = 0;
			
		//Reading the first part of the file
		while (counter < n) {
				
			String line = scanner.nextLine();
			String[] lineItem = line.split(" ");
			
			String id = lineItem[0];
			String name = lineItem[1];
			
			stationList.add(new Metro(id, name));
			
			counter++;
		}
		
		scanner.nextLine();
			
		//Adjacency list allocation
		adj = new ArrayList<>();
			
		for (int i=0; i<n; i++) {
			adj.add(new ArrayList<>());
		}
			
		//Filling the adjacency list of the graph
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] lineItem = line.split(" ");
			int value1 = Integer.parseInt(lineItem[0]); //vertex 1
			int value2 = Integer.parseInt(lineItem[1]); //vertex 2
			double weight = Double.parseDouble(lineItem[2]); //weight
				
			if (weight != -1) {
			adj.get(value1).add(new Node(value2, weight)); 
			m++; //edges++
			}
		}
			
		scanner.close();
	}
	
	//Function to print the adjacency list of a graph
	public void printGraph() { 
		for (int i=0; i<n; i++) {
			System.out.print(i + " --> ");
			for (int j=0; j<adj.get(i).size(); j++) {
			System.out.print(adj.get(i).get(j).value + " " + 
					adj.get(i).get(j).weight + " | ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//Function to add a vertex
	public void addVertex () {
		adj.add(new ArrayList<>());
		n++;
	}
	
	//Function to add an edge (between existing vertices)
	public void addEdge (int source, int destination, double weight) {
		adj.get(source).add(new Node(destination, weight));
		m++;
	}
	
	//Function to calculate the degree of the vertex (incoming edges)
	public void inDegVertex (int vertex) {
		int inDegree = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<adj.get(i).size(); j++) {
				if (adj.get(i).get(j).value == vertex) {
					inDegree++;
				}
			}
		}
		System.out.println("The inDegree of the vertex " + vertex + " is " 
				+ inDegree);
	}
	
	//Function to calculate the degree of the vertex (outgoing edges)
	public void outDegVertex (int vertex) {
		int outDegree = adj.get(vertex).size();
		System.out.println("The outDegree of the vertex " + vertex + 
				" is " + outDegree);
	}
	
	public List<Integer> Neighbors (int vertex) { //Da levare il print!
		List<Integer> neighbors = new ArrayList<>();
		
		for (int i=0; i<adj.get(vertex).size(); i++) {
			neighbors.add(adj.get(vertex).get(i).value);
		}
		
		return neighbors;
	}
	
	public double[][] fromAdjListToAdjMatrix () {
		double[][] matrix = new double[n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				matrix[i][j] = Double.MAX_VALUE;
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<adj.get(i).size(); j++) {
				int k = adj.get(i).get(j).value;
				matrix[i][k] = adj.get(i).get(j).weight;
			}
		}
		return matrix;
	}
}
