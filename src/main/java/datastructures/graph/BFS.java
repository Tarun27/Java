package datastructures.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//this works only when edges are numbered from 0 to n, its due to adj list representation of graph
//and visited array also needs edges to be from 0 to n
//BFS traversal from graph
public class BFS {
	
	int vertices;
	private LinkedList<Integer>	adj[];
	
	BFS(int v){
		vertices = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]= new LinkedList();
		}	
		
	}
	
	public void addEdge(int a, int b) {
		adj[a].add(b);		
	}

	public void BFSUtil(int x, boolean[] visited) {
		
		
		Queue<Integer> que = new LinkedList<Integer>();

		visited[x]=true;
		que.add(x);
		while(!que.isEmpty()) {
			int y = que.poll();
			System.out.print(y+" ");
			
			Iterator<Integer> it = adj[y].listIterator();
			
			while(it.hasNext()) {
				int n = it.next();
				if(!visited[n]) {
					visited[n]= true;
					que.add(n);
				}
			}
			
			
		}
		
		
		
	}
	
	public void BFSTr(int x){
		// by default all vertices not visited, as default value is false in visited
				boolean[] visited = new boolean[vertices];
				
				BFSUtil(x,visited);
				
				for(int i=0;i<vertices;i++) {
					if(!visited[i])
						BFSUtil(i,visited);
				}
				
	}
	
	public static void main(String[] args) {
		 BFS g = new BFS(6);
		 
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	        g.addEdge(4, 4); // adding node not connected to above nodes 
	        g.addEdge(4,5);
	    
	        System.out.println("Following is Breadth First Traversal "+
	                           "(starting from vertex 2)");
	 
	        g.BFSTr(2);
	}
	
	
	
}
