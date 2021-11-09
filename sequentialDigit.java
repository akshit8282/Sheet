class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
     String s="123456789";
        int nl=String.valueOf(low).length();
        int nh=String.valueOf(high).length();
        List<Integer> a=new ArrayList<>();
        for(int i=nl;i<=nh;i++){
            for(int j=0;j<10-i;j++){
                int digit=Integer.parseInt(s.substring(j,j+i));
                if(digit>=low&&digit<=high){
                    a.add(digit);
                }
            }
        }
      return a;  
    }
    
}