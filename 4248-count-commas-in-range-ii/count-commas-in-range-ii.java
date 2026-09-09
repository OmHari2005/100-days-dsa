class Solution {
    public long countCommas(long n) {
        long count = 0;
        long p = 1000L;
        while(p<=n){
            count += (n-p+1);
            p *= 1000L;
        }
        return count;
    }
}