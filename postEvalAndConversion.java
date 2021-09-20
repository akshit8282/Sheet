import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> val=new Stack<>();
  Stack<String> inf=new Stack<>();
        Stack<String> pre=new Stack<>();
    Stack<Character> op=new Stack<>();
    for(int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);
        if(ch>='0'&&ch<='9'||ch>='a'&&ch<='z'||ch>='A'&&ch<='Z'){
                pre.push(ch+"");
                inf.push(ch+"");
                val.push(ch-'0');
            }
            
        else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
            
                String inf2=inf.pop();
               String inf1=inf.pop();
              
               String infans="("+inf1+ch+inf2+")";
               inf.push(infans);
               String pre2=pre.pop();
               String pre1=pre.pop();
               
               String preans=ch+pre1+pre2;
               pre.push(preans);
               int val2=val.pop();
               int val1=val.pop();
               int ans=solve(val2,val1,ch);
               val.push(ans);
            }
            
            
        
        
    }
    
            System.out.println(val.peek()); 
           System.out.println(inf.peek()); 
           System.out.println(pre.peek()); 
    
 }
 
 public static int solve(int val2,int val1,char op){
     if(op=='+'){
         return val1+val2;
     }
     if(op=='-'){
         return val1-val2;
     }
     if(op=='/'){
         return val1/val2;
     }
     if(op=='*'){
         return val2*val1;
     }
     return 0;
 }
 
}

 