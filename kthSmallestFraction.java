class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
     int n=arr.length;
        double low=arr[0]/(double)arr[n-1];
        double high=1;
       
        while(low<high){
            double target=(low+high)/2;
            int[] count=f(arr,target);
            if(k<count[0]){
                high=target;
            }else if(k>count[0]){
                low=target;
            }else{
                return new int[]{count[1],count[2]};
            }
        }
        return null;
    }
    public int[] f(int[] arr,double target){
         int i=0;
        int n=arr.length;
        int num=arr[0],den=arr[n-1];
        int count=0;
        for(int j=0;j<arr.length;j++){
            while(arr[i]<=target*arr[j]){
                i++;
            }
            count+=i;
            if(i>0&&arr[i-1]*den>arr[j]*num){
                num=arr[i-1];
                den=arr[j];
            }
        }
        return new int[]{count,num,den};
    }
}