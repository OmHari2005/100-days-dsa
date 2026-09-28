class Solution {
    public int alternateDigitSum(int n) {
        int temp=n;
        int sign =+1;
         int sum =0;
        while(temp>0){
           
          int  a=temp%10;
            sum+=a*sign;
            sign=-sign;
            temp=temp/10;
        }
        if(sign==1){
            return -sum;
           }
           return sum;
       
    }
}