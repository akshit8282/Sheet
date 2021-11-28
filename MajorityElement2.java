import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    public static boolean findCount(int val,int[] arr){
        int c=0;
        for(int a:arr){
            if(a==val){
                c++;
            }
        }
        return c>arr.length/3;
    }
    public static ArrayList<Integer> majorityElement2(int[] arr) {
        // write your code here
        int val1=arr[0];
        int count1=1;
        int val2=arr[0];
        int count2=0;
        for(int i=1;i<arr.length;i++){
            if(val1==arr[i]){
                count1++;
            }else if(val2==arr[i]){
                count2++;
            }else{
                if(count1==0){
                    val1=arr[i];
                    count1=1;
                }else if(count2==0){
                    val2=arr[i];
                    count2=1;
                }
                else{
                    count1--;
                    count2--;
                }
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        boolean c1=findCount(val1,arr);
        boolean c2=findCount(val2,arr);
        if(val1!=val2&&c1==true&&c2==true){
            res.add(val1);
            res.add(val2);
        }else if(val1!=val2&&c1==true){
            res.add(val1);
        }else{
            res.add(val2);
        }
        return res;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    }
}