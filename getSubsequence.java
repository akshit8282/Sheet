import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
Scanner sc=new Scanner(System.in);
String s=sc.next();
ArrayList<String> aa=gss(s);
System.out.print(aa);
    }

    public static ArrayList<String> gss(String str) {
    if(str.length()==0){
        ArrayList<String> a=new ArrayList<>();
        a.add("");
        return a;
    }
    char at=str.charAt(0);
    String ros=str.substring(1);
    ArrayList<String> e=gss(ros);
    ArrayList<String> res=new ArrayList<>();
    for(String s:e){
        res.add(""+s);
    }
    for(String s:e){
        res.add(at+s);
    }
    return res;
    }

}