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
boolean[] visited=new boolean[vtces];
      int src = Integer.parseInt(br.readLine());
      // write your code here
      //find shortest path based on weight
      //dyjastra algorithm
      PriorityQueue<Pair> q=new PriorityQueue<>();
      q.add(new Pair(src,src+"",0));
      while(!q.isEmpty()){
          Pair p=q.poll();
          if(visited[p.v]==true){
              continue;
          }
          visited[p.v]=true;
          System.out.println(p.v+" via "+p.psf+" @ "+p.w);
          for(Edge e:graph[p.v]){
              if(visited[e.nbr]==false){
                  q.add(new Pair(e.nbr,p.psf+e.nbr,p.w+e.wt));
              }
          }
      }
      
      
      
   }
   static class Pair implements Comparable<Pair>{
       String psf;
       int v;
       int w;
    Pair(int v,String psf,int w)
       {
           this.v=v;
           this.psf=psf;
           this.w=w;
       }
       public int compareTo(Pair o){
           return this.w-o.w;
       }
   }
}