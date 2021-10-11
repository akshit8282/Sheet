import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
        mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        int max=Integer.MIN_VALUE;
        String a="";
        for(int i=0;i<s.length();i++){
        if(mp.get(s.charAt(i))>max){
            max=mp.get(s.charAt(i));
             a=s.charAt(i)+"";
        }
        }
        System.out.println(a);
    }

}