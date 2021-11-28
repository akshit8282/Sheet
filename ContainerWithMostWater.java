import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int mostWater(int[] heights) {
        // write your code here
        int i=0,j=heights.length-1;
        int ans=0;
        while(i<j){
            int h=Math.min(heights[i],heights[j]);
            int ar=(j-i)*h;
            if(ar>ans){
                ans=ar;
               }
               if(heights[i]<heights[j]){
                   i++;
               }else{
                   j--;
               }
        }
        return ans;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        // Write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] heights = new int[n];
        for(int i = 0; i < n; i++) {
            heights[i] = scn.nextInt();
        }

        int res = mostWater(heights);
        System.out.println(res);
    }
}