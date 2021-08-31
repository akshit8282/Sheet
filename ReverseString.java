//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String a)
    {
        // Reverse the string str
        int s=a.length()-1;
   char[] str=a.toCharArray();
        int i=0;
     while(i<s){
            char temp=str[i];
            str[i]=str[s];
            str[s]=temp;
            i++;
            s--;
        }
         return String. valueOf(str);
        
    }
}