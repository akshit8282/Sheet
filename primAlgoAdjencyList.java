import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      PriorityQueue<Pair> q=new PriorityQueue<>();
      q.add(new Pair(0,-1,0));
      boolean[] visited=new boolean[vtces];
      while(!q.isEmpty()){
          Pair p=q.poll();
        
              
          if(visited[p.v]==true){
              continue;
          }
          visited[p.v]=true;
          if(p.pa!=-1){
              System.out.println("["+p.v+"-"+p.pa+"@"+p.w+"]");
              
          }
          for(Edge e:graph[p.v]){
              if(visited[e.nbr]==false){
                  q.add(new Pair(e.nbr,p.v,e.wt));
              }
          }
      }
      
   }
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

}