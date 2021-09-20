import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
        Stack<String> post=new Stack<>();
        Stack<String> pre=new Stack<>();
    Stack<Character> op=new Stack<>();
    for(int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);
        if(ch>='0'&&ch<='9'||ch>='a'&&ch<='z'||ch>='A'&&ch<='Z'){
                pre.push(ch+"");
                post.push(ch+"");
            }
            else if(ch=='('){
                op.push(ch);
            }
        else if(ch==')'){
            while(op.peek()!='('){
               String post2=post.pop();
               String post1=post.pop();
               char ops=op.pop();
               String postans=post1+post2+ops;
               post.push(postans);
               String pre2=pre.pop();
               String pre1=pre.pop();
               
               String preans=ops+pre1+pre2;
               pre.push(preans);
            }
            
            op.pop();
        }
        else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
            while(!op.isEmpty()&&op.peek()!='('&&precendence(ch)<=precendence(op.peek())){
                String post2=post.pop();
               String post1=post.pop();
               char ops=op.pop();
               String postans=post1+post2+ops;
               post.push(postans);
               String pre2=pre.pop();
               String pre1=pre.pop();
               
               String preans=ops+pre1+pre2;
               pre.push(preans);
            }
            op.push(ch);  
        }
        
    }
    while(!op.isEmpty()){
                String post2=post.pop();
               String post1=post.pop();
               char ops=op.pop();
               String postans=post1+post2+ops;
               post.push(postans);
               String pre2=pre.pop();
               String pre1=pre.pop();
               
               String preans=ops+pre1+pre2;
               pre.push(preans);
            }
           System.out.println(post.peek()); 
           System.out.println(pre.peek()); 
    
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
 
}

 