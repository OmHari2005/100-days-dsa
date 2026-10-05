class Solution {

    int func(String s, int l, int r) {

        if (r-l==1) {
            return 1;
        }

        int a=0;
        int b=0;

        for (int i=l;i<=r;i++) {

            if (s.charAt(i)=='(') {
                a++;
            } else {
                b++;
            }
            if (a==b) {
                if (i==r) {
                    return 2*func(s, l+1, r-1);
                }
                return func(s, l, i) +func(s, i+1, r);
            }
        }
        return 0;
    }

    public int scoreOfParentheses(String s) {
        return func(s, 0, s.length()-1);
    }
}