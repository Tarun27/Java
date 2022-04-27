package datastructures.graph;

import java.util.LinkedList;


//this works only when edges are numbered from 0 to n, its due to adj list representation of graph
//and visited array also needs edges to be from 0 to n
//BFS traversal from graph
public class Graph1 {
	public LinkedList<Integer>	adj[];

	int vertices;
	
	Graph1(int v){
		vertices = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]= new LinkedList();
		}	
		
	}
	
	
	public void addEdge(int a, int b) {
		adj[a].add(b);		
	}
	
}
