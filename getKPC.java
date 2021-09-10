import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
Scanner sc=new Scanner(System.in);
String z=sc.next();
ArrayList<String> aa=getKPC(z);
System.out.print(aa);
    }
static String[] se={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String str) {
        if(str.length()==0){
            ArrayList<String> bb=new ArrayList<>();
            bb.add("");
            return bb;
        }
    char a=str.charAt(0);
    String ros=str.substring(1);
    ArrayList<String> aa=getKPC(ros);
    ArrayList<String> res=new ArrayList<>();
    String sw=se[a-'0'];
    for(int i=0;i<sw.length();i++){
        char q=sw.charAt(i);
        for(String s:aa){
            res.add(q+s);
        }
    }
    return res;
    }

}