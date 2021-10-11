import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc=new Scanner(System.in);
    int n1=sc.nextInt();
    int[] a1=new int[n1];
    for(int i=0;i<n1;i++){
        a1[i]=sc.nextInt();
    }
    int n2=sc.nextInt();
    int[] a2=new int[n2];
     for(int i=0;i<n2;i++){
        a2[i]=sc.nextInt();
    }
    HashMap<Integer,Integer> mp=new HashMap<>();
    for(int a:a1){
        mp.put(a,mp.getOrDefault(a,0)+1);
        
    }
    for(int a:a2){
        if(mp.containsKey(a)){
            System.out.println(a);
            mp.remove(a);
        }
    }
 }

}