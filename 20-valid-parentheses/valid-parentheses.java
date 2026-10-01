import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // Push expected closing brackets onto the stack when seeing an opening bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket, verify it matches the top of the stack
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}