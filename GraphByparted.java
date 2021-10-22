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
public static class Pair{
    int v;
    String psf;
    int level;
    Pair(int v,String psf,int level){
        this.v=v;
        this.psf=psf;
        this.level=level;
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
      int[] visited=new int[vtces];
      Arrays.fill(visited,-1);
      for(int i=0;i<vtces;i++){
          if(visited[i]==-1){
              boolean byparted=checkBiparted(graph,i,visited);
              if(byparted==false){
                  System.out.println(false);
                  return;
              }
          }
      }
      System.out.println(true);
   }
   public static boolean checkBiparted(ArrayList<Edge>[] graph,int src,int[] visited){
       ArrayDeque<Pair> q=new ArrayDeque<>();
       q.add(new Pair(src,src+"",0));
       while(!q.isEmpty()){
           Pair p=q.poll();
           if(visited[p.v]!=-1){
               if(visited[p.v]!=p.level){
                   return false;
               }
           }else{
               visited[p.v]=p.level;
           }
           for(Edge e:graph[p.v]){
               if(visited[e.nbr]==-1){
                  q.add(new Pair(e.nbr,p.psf+e.nbr,p.level+1));
               }
           }
       }
       return true;
   }
}
/*
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
public static class Pair{
    int v;
    String psf;
    int level;
    Pair(int v,String psf,int level){
        this.v=v;
        this.psf=psf;
        this.level=level;
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
      int[] visited=new int[vtces];
      Arrays.fill(visited,-1);
      for(int i=0;i<vtces;i++){
          if(visited[i]==-1){
              boolean byparted=checkBiparted(graph,i,visited);
              if(byparted==false){
                  System.out.println(false);
                  return;
              }
          }
      }
      System.out.println(true);
   }
   //coloring method
   //in this adjacent nodes should not be marked with same colour
   //if marked then return false
   public static boolean checkBiparted(ArrayList<Edge>[] graph,int src,int[] visited){
       ArrayDeque<Integer> q=new ArrayDeque<>();
       q.add(src);
       visited[src]=1;
       while(!q.isEmpty()){
           int p=q.poll();
           
           for(Edge e:graph[p]){
               if(visited[e.nbr]==-1){
                   visited[e.nbr]=1-visited[p];
                  q.add(e.nbr);
               }else if(visited[e.nbr]==visited[p]){
                   return false;
               }
           }
       }
       return true;
   }
}
*/