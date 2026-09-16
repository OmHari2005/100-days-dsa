import java.util.*;

class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
           for(int i=0;i<digits.length;i++){
            for(int j=0;j<digits.length;j++){
                for(int k=0;k<digits.length;k++){
                 if(i==j || j==k || k==i)
                 continue;
                 int a =digits[i];
                 int b =digits[j];
                 int c =digits[k];
                 if(c!=0 && a %2==0){
                     int nums= c *100 + b*10 + a;
                     set.add(nums);
                   }
                }
            }
        }
       
        return set.size();
    }
}