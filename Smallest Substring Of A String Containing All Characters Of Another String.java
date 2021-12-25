import java.util.*;

public class Main {

	public static String solution(String s1, String s2){
		// write your code here
		String ans="";
		HashMap<Character,Integer> mp1=new HashMap<>();
			HashMap<Character,Integer> mp2=new HashMap<>();
			//count frequency of ch in s2
			for(int i=0;i<s2.length();i++){
			    char ch=s2.charAt(i);
			    mp2.put(ch,mp2.getOrDefault(ch,0)+1);
			    
			}
			int j=-1,i=-1;
			//acquire
			int desiredmarkedcount=s2.length();
			int markedcount=0;
			while(true){
			    boolean flag1=false,flag2=false;
			while(i<s1.length()-1&&markedcount<desiredmarkedcount){
			     i++;
			 char ch=s1.charAt(i);
			 mp1.put(ch,mp1.getOrDefault(ch,0)+1);
			 if(mp1.getOrDefault(ch,0)<=mp2.getOrDefault(ch,0)){
			     markedcount++;
			 }
		
			
			 flag1=true;
			}
			//collect ans and release
			while(j<i&&markedcount==desiredmarkedcount){
			    String pans=s1.substring(j+1,i+1);
			    
			    if(ans.length()==0||pans.length()<ans.length()){
			        
			        ans=pans;
			    }
			    //release
			    j++;
			    char ch=s1.charAt(j);
			    if(mp1.get(ch)==1){
			        mp1.remove(ch);
			    }else{
			        mp1.put(ch,mp1.get(ch)-1);
			    }
			    if(mp1.getOrDefault(ch,0)<mp2.getOrDefault(ch,0)){
			        markedcount--;
			    }
			    flag2=true;
			}
			if(flag1==false&&flag2==false){
			   
			    break;
			}
			}
		
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
