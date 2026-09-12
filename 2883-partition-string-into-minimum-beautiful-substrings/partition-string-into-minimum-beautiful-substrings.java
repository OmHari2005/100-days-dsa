 class Solution {

    public boolean isPowerOfFive(int num) {
        if (num <= 0)
            return false;

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }

    public int func(int partition, int i, String s) {
        if (i == s.length())
            return partition;
        if (s.charAt(i) == '0')
            return Integer.MAX_VALUE;

        int ans = Integer.MAX_VALUE;
        int num = 0;

        for (int j = i; j < s.length(); j++) {
            num = num * 2 + (s.charAt(j) - '0');

            if (isPowerOfFive(num)) {
                ans = Math.min(ans, func(partition + 1, j + 1, s));
            }
        }

        return ans;
    }

    public int minimumBeautifulSubstrings(String s) {
        int ans = func(0, 0, s);

        if (ans == Integer.MAX_VALUE) return -1;

        return ans;
    }
}