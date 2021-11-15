import java.util.*;

public class Main {
	
	public static void solution(int[] arr, int k){
		//write your code here
		HashMap<Integer,Integer> mp=new HashMap<>();
for(int val:arr){
    int rem=val%k;
    mp.put(rem,mp.getOrDefault(rem,0)+1);
}
for(int val:arr){
    int rem=val%k;
    if(rem==0){
        int f=mp.get(rem);
        if(f%2==1){
            System.out.println(false);
            return;
        }
    }else if(2*rem==k){
        int f=mp.get(rem);
        if(f%2==1){
            System.out.println(false);
            return;
        }
    }else{
        int f=mp.get(rem);
        int fc=mp.getOrDefault(k-rem,0);
        if(f!=fc){
            System.out.println(false);
            return;
        }
    }
}
System.out.println(true);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
	}

}
