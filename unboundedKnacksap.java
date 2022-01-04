import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
int n;
    Scanner sc=new Scanner(System.in);
n=sc.nextInt();
int[] wt=new int[n];
for(int i=0;i<n;i++){
    wt[i]=sc.nextInt();
}
int[] val=new int[n];
for(int i=0;i<n;i++){
    val[i]=sc.nextInt();
}
int cap=sc.nextInt();
//in this repetion is allowed
int[] dp=new int[cap+1];
dp[0]=0;
for(int i=1;i<=cap;i++){
    int max=0;
    for(int j=0;j<n;j++){//j loop means the no of player and their score //and it should be iterated for every index of dp[i];
        if(val[j]<=i){
            //weight at j
            int weight=dp[i-val[j]]+wt[j];
           
            if(max<weight){
                max=weight;
                
            }
            
        }
    }
    dp[i]=max;
}

System.out.println(dp[cap]);
    }
}