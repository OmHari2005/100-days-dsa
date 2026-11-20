class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m=g.length;
        int n=s.length;
        int cnt=0;
        int i=0;
        int j=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<m && j<n){
            if(s[j]>=g[i]){
                cnt++;
                j++;
                i++;
            }
            else{
                j++;
            }
        }
        return cnt;
        
    }
}