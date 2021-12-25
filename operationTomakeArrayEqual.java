/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    int[] arr={1,1,1,1,6};
		minoperation(arr);
	}
	public static void minoperation(int[] arr){
	    int operation=0,j=0,index=0;
	    int x=Arrays.stream(arr).max().getAsInt();
	    int y=Arrays.stream(arr).min().getAsInt();
	    for(int i=0;i<arr.length;i++){
	        if(arr[i]==x){
	            index=i;
	            break;
	        }
	    }
	    for(int i:arr){
	        if(i!=x&&i<=y&&i!=0){
	            arr[index]--;//changing in the array
	            arr[j]++;//changing in array
	            
	            x--;//changing in value so as to check the if condition
	            operation++;
	            j++;//only for loop run
	        }else if(i!=0){
	            j++;
	        }
	    }
	    for(int i:arr){
	        if(i!=x){
	            operation=-1;
	            break;
	        }
	    }
	    System.out.println(operation);
	}

    
}