import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
ArrayList<String> res=getStairPaths(n);
System.out.print(res);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n==0){
            ArrayList<String> a=new ArrayList<>();
            a.add("");
            return a;
        }
        if(n<0){
                 ArrayList<String> ab=new ArrayList<>();
           
            return ab;
        }
    ArrayList<String> path1=getStairPaths(n-1);
     ArrayList<String> path2=getStairPaths(n-2);
     ArrayList<String> path3=getStairPaths(n-3);
     ArrayList<String> paths=new ArrayList<>();
     for(String s:path1){
         paths.add(1+s);
     }
 for(String s:path2){
         paths.add(2+s);
     }
      for(String s:path3){
         paths.add(3+s);
     }
        return paths;
        
    }
}