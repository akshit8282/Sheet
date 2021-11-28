import java.util.*;
import java.lang.Math;
public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] sortedSquares(int[] nums) {
        // write your code here
        int i=0;
        int j=i+1;
        while(i<nums.length&&j<nums.length){
            int a=Math.abs(nums[i]);
            int b=Math.abs(nums[j]);
            System.out.println(a+" "+b);
            if(a*a>b*b){
        int temp=a;
        nums[i]=b;
        nums[j]=temp;
       j++;
       i++;
            }else{
                nums[i]=a;
                nums[j]=b;
                
                j++;
            }
            
        }
        return nums;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) 
            nums[i] = scn.nextInt();
        
        int[] res = sortedSquares(nums);

        for(int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}