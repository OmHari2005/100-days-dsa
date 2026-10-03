class Solution {
    int[][] dp;

    public int func(int i, int j, String s1, String s2){
        if(i==s1.length()){
            return s2.length()-j;
        }

        if(j==s2.length()){
            return s1.length()-i;
        }

        if(dp[i][j]!= -1){
            return dp[i][j];
        }

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=func(i+1,j+1,s1,s2);
        }

        int a=func(i,j+1,s1,s2);
        int b=func(i+1,j,s1,s2);
        int c=func(i+1,j+1,s1,s2);

        return dp[i][j]= 1+Math.min(a,Math.min(b,c));
    }
    public int minDistance(String word1, String word2) {
        dp=new int[word1.length()][word2.length()];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return func(0,0,word1,word2);
    }
}