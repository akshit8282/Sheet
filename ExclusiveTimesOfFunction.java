import java.io.*;
import java.util.*;

public class Main {
public static class Pair{
    int id;
    int st;
    int ct;
    Pair(int id,int st,int ct){
        this.id=id;
        this.st=st;
        this.ct=ct;
    }
}
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // use read for taking input
        int n=Integer.parseInt(read.readLine());
        int len=Integer.parseInt(read.readLine());
        int[] ftime=new int[n];
        Stack<Pair> st=new Stack<>();
        for(int i=0;i<len;i++){
            String log[]=read.readLine().split(":");//0 id 1 start 2 start or end time
            if(log[1].equals("start")){
                Pair p=new Pair(Integer.parseInt(log[0]),Integer.parseInt(log[2]),0);
             
             st.push(p);   
            }else if(log[1].equals("end")){
                Pair p=st.pop();
                int interval=Integer.parseInt(log[2])-p.st+1;
                int time=interval-p.ct;
                ftime[p.id]+=time;
                if(st.size()>0){
                    st.peek().ct+=interval;
                }
            }
            
        }
        for(int e:ftime){
            System.out.println(e);
        }
        
    }
}
