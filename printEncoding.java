import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String str = scn.next();
        printEncodings(str,"");
    }
    public static String[] codes = {"","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public static void printEncodings(String str,String ans) {
        
        int i =0;
        String ros2 ="";
        
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        if(str.length()>=2){
            i=Integer.parseInt(str.substring(0,2)); 
            if(str.length()>2){
                ros2 = str.substring(2);
            }else{
                ros2 = "";
            }
        }
        char ch = str.charAt(0);
        String ros1 = str.substring(1);
        
        //System.out.println(i);
        
        if((ch - '0') >0){
            printEncodings(ros1,ans + codes[ch - '0']);    
        }
        if((ch - '0' )==0){
            return;
        }
        if(i>0 && i<27){
            printEncodings(ros2,ans + codes[i]);  
        }   
    }

}