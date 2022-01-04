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
    //allowed to put only 1 time or 0 time
    
    int[][] dp=new int[n+1][cap+1];
    
    for(int i=1;i<=n;i++){
        for(int j=1;j<=cap;j++){
            
            if(j>=val[i-1]){
            int preScore=dp[i-1][j];//if player doesnot participate
            //if player participate
            int score=wt[i-1];//how much score will it score in that no.of balls
            //i-1 because the dp loop starts from 1 and wt and val array from 0
           
            int leftout=j-val[i-1];////leftout balls to play by rest of team
            int nowscore=score+dp[i-1][leftout];//new score 
            dp[i][j]+=Math.max(nowscore,preScore);//max of two
            
            }else{
                dp[i][j]+=dp[i-1][j];//the score made by rest of team
            }
        }
    }
    /*for(int i=0;i<=n;i++){
        for(int j=0;j<=cap;j++){
            System.out.print(dp[i][j]);
        }
        System.out.println();
    }*/
    System.out.println(dp[n][cap]);

    }
}