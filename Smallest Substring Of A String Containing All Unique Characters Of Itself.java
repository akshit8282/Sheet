import java.util.*;

public class Main {

	public static int solution(String str){
		// write your code here
		String ans="";
		HashSet<Character> unique=new HashSet<>();
		for(int i=0;i<str.length();i++){
		   char ch=str.charAt(i);
		   unique.add(ch);
		}
		HashMap<Character,Integer> mp=new HashMap<>();
		int i=-1;
		int j=-1;
		while(true){
		    //acquire till till became equal to unique hashset size
		    boolean flag1=false,flag2=false;
		    while(i<str.length()-1&&mp.size()<unique.size()){
		        i++;
		        char ch=str.charAt(i);
		        mp.put(ch,mp.getOrDefault(ch,0)+1);
		        flag1=true;
		    }
		    while(j<i&&unique.size()==mp.size()){
		        //stroring ans
		      String pans=str.substring(j+1,i+1);
		      if(ans.equals("")||pans.length()<ans.length()){
		          ans=pans;
		      }
		      //release property
		      j++;
		      char ch=str.charAt(j);
		      if(mp.get(ch)==1){
		          mp.remove(ch);
		      }else{
		          mp.put(ch,mp.get(ch)-1);
		      }
		      flag2=true;
		    }
		    if(flag1==false&&flag2==false){
		        break;
		    }
		}
		
		return ans.length();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
