// A Java program for Prim's Minimum Spanning Tree (MST) algorithm.
// The program is for adjacency matrix representation of the graph

import java.util.*;
import java.lang.*;
import java.io.*;

class MST {
	// Number of vertices in the graph
	
 static class Pair implements Comparable<Pair>{
       
       int v;
       int pa;
       int w;
    Pair(int v,int pa,int w)
       {
           this.v=v;
           this.pa=pa;
           this.w=w;
       }
       public int compareTo(Pair o){
           return this.w-o.w;
       }

}
	// A utility function to find the vertex with minimum key
	// value, from the set of vertices not yet included in MST
	

	// A utility function to print the constructed MST stored in
	// parent[]
	void printMST(int parent[], int graph[][])
	{
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}

	// Function to construct and print MST for a graph represented
	// using adjacency matrix representation
	void primMST(int graph[][])
	{
		// Array to store constructed MST
		
		// The MST will have V vertices
		
		PriorityQueue<Pair> q=new PriorityQueue<>();
      int[] parent=new int[5];
      
      q.add(new Pair(0,-1,0));
      boolean[] visited=new boolean[5];
      while(!q.isEmpty()){
          Pair p=q.poll();
        //System.out.println("p"+p.v);
              
          if(visited[p.v]==true){
              continue;
          }
          visited[p.v]=true;
          if(p.pa!=-1){
            parent[p.v]=p.pa;
              //System.out.println(p.pa+" - "+p.v+"\t"+p.w);
              
          }
          for(int i=0;i<5;i++){
              if(graph[p.v][i]!=0&&visited[i]==false){
                  q.add(new Pair(i,p.v,graph[p.v][i]));
              }
          }
      }
      
printMST(parent,graph);
		// print the constructed MST
		
	}

	public static void main(String[] args)
	{
		/* Let us create the following graph
		2 3
		(0)--(1)--(2)
		| / \ |
		6| 8/ \5 |7
		| /	 \ |
		(3)-------(4)
			9		 */
		MST t = new MST();
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
									{ 2, 0, 3, 8, 5 },
									{ 0, 3, 0, 0, 7 },
									{ 6, 8, 0, 0, 9 },
									{ 0, 5, 7, 9, 0 } };

		// Print the solution
		t.primMST(graph);
	}
}
// This code is contributed by Aakash Hasija
