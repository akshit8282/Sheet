import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> val=new Stack<Integer>();
    Stack<Character> op=new Stack<>();
    for(int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);
        if(Character.isDigit(ch)){
                val.push(ch-'0');
            }
            else if(ch=='('){
                op.push(ch);
            }
        else if(ch==')'){
            while(op.peek()!='('){
                int val2=val.pop();
                int val1=val.pop();
                char oper=op.pop();
                int ans=solve(val2,val1,oper);
                val.push(ans);
            }
            
            op.pop();
        }
        else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
            while(!op.isEmpty()&&op.peek()!='('&&precendence(ch)<=precendence(op.peek())){
                int val2=val.pop();
                int val1=val.pop();
                char oper=op.pop();
                int ans=solve(val2,val1,oper);
                val.push(ans);
            }
            op.push(ch);  
        }
        
    }
    while(!op.isEmpty()){
                int val2=val.pop();
                int val1=val.pop();
                char oper=op.pop();
                int ans=solve(val2,val1,oper);
                val.push(ans);
            }
           System.out.println(val.peek()); 
    
 }
 public static int precendence(char ch){
     if(ch=='+'){
         return 1;
     }
     if(ch=='-'){
         return 1;
     }
     if(ch=='/'){
         return 2;
     }
     if(ch=='*'){
         return 2;
     }
     return 0;
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