import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
Scanner sc=new Scanner(System.in);
String s=sc.nextLine();
int flag=0;
Stack<Character> st=new Stack<>();
for(int i=0;i<s.length();i++){
    char ch=s.charAt(i);
    
    if(ch=='('||ch=='{'||ch=='['){
        st.push(ch);
    }
    else if(ch==')'||ch==']'||ch=='}'){
        switch(ch){
            case ')':
                if(st.isEmpty()||st.peek()!='(') flag=1;
                break;
             case ']':
                if(st.isEmpty()||st.peek()!='[') flag=1;
                break;
             case '}':
                if(st.isEmpty()||st.peek()!='{') flag=1;
                break;
            
        }
        
        if(flag==1){
            System.out.println(false);
            return;
        }
        st.pop();
    }
}
if(st.isEmpty())
System.out.println(true);
else
System.out.println(false);
    }

}