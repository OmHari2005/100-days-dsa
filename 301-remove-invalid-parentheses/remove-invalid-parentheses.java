class Solution {
    boolean check(String s) {
        int a=0;
        int b=0;

        for (int i=0;i<s.length();i++) {
            char ch=s.charAt(i);

            if (ch=='(') {
                a++;
            }
            else if (ch==')') {
                b++;
            }

            if (b>a) {
                return false;
            }
        }

        return a==b;
    }
    void func(String s, int i, String curr, int r, HashSet<String> result, int[] min) {
        if (i==s.length()) {
            if (check(curr)) {
                if (r<min[0]) {
                    min[0]=r;

                    result.clear();
                    result.add(curr);
                }
                else if (r==min[0]) {
                    result.add(curr);
                }
            }
            return;
        }

        char ch=s.charAt(i);

        if (ch !='(' && ch !=')') {
            func(s, i+1, curr+ch, r, result, min);
        }
        else {
            func(s, i+1, curr+ch, r, result, min);

            func(s, i+1, curr, r+1,result, min);
        }
    }


    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> result = new HashSet<>();

        int[] min = {Integer.MAX_VALUE};
        func(s, 0, "", 0, result, min);

        return new ArrayList<>(result);
    }
}