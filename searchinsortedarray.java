import java.util.*;
import java.io.*;

public class Main {

    public static int find(int[]arr,int target) {
        //write your code here
        int lo=0;
        int hi=arr.length-1;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(target==arr[mid]){
                return mid;
            }else if(arr[mid]>arr[lo]){
                if(target>=arr[lo]&&target<arr[mid]){
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
            }else if(arr[mid]<arr[hi]){
                if(target>arr[mid]&&target<=arr[hi]){
                    lo=mid+1;
                }else{
                    hi=mid-1;
                }
            }
           
        }
        
    
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        int ans = find(arr,target);
        System.out.println(ans);
    }
}