import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
Scanner sc=new Scanner(System.in);
String s=sc.next();
printKPC(s,"");
    }
static String[] se={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printKPC(String str, String asf) {
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        
        char ch=str.charAt(0);
        String s=str.substring(1);
        String co=se[ch-'0'];
        for(int i=0;i<co.length();i++){
            char cq=co.charAt(i);
            printKPC(s,asf+cq);
        }
    }

}