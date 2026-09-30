import java.util.ArrayList;
import java.util.List;

class Solution {
    private void fun(String s, int a, int b, int n, List<String> ans) {
        if (a > n || b > a) {
            return;
        }
        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }
        fun(s + "(", a + 1, b, n, ans);
        fun(s + ")", a, b + 1, n, ans);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        fun("", 0, 0, n, ans);
        return ans;
    }
}