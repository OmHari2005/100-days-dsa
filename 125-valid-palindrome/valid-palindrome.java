class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Move left to next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Move right to previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (left < right) {
                char c1 = Character.toLowerCase(s.charAt(left));
                char c2 = Character.toLowerCase(s.charAt(right));

                if (c1 != c2) {
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }
}