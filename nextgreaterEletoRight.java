import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   // solve
   
   Stack<Integer> st=new Stack<>();
   int[] brr=new int[arr.length];
   brr[arr.length-1]=-1;
   st.push(arr.length-1);
   for(int i=arr.length-2;i>=0;i--){
       while(!st.isEmpty()&&arr[st.peek()]<=arr[i]){
           st.pop();
           
       }
       if(st.isEmpty()){
           brr[i]=-1;
       }else{
           brr[i]=arr[st.peek()];
       }
       st.push(i);
   }
   return brr;
 }

}