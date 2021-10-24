import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   static class Pair{
    String psf;
    int v;
    Pair(int v,String psf){
        this.v=v;
        this.psf=psf;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here
       boolean[] visited=new boolean[vtces];
      Stack<Pair> q=new Stack<>();
      Pair p=new Pair(src,src+"");
      q.push(p);
      while(!q.isEmpty()){
          Pair c=q.pop();
        if(visited[c.v]==true){
            continue;
        }
        visited[c.v]=true;
        System.out.println(c.v+"@"+c.psf);
        for(Edge e:graph[c.v]){
            if(visited[e.nbr]==false){
                q.push(new Pair(e.nbr,c.psf+e.nbr));
            }
        }
      }
   }
}