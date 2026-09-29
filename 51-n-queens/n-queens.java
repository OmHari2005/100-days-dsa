import java.util.*;

class Solution {

    void solve(int col, char[][] board, List<List<String>> ans, 
               int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, int n) {
        
        // Base case: saare columns me queen place ho gayi
        if (col == n) {
            List<String> current = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }
            ans.add(current);
            return;
        }

        for (int row = 0; row < n; row++) {
            // Check if safe in O(1) time using hash arrays
            if (leftRow[row] == 0 && 
                lowerDiagonal[row + col] == 0 && 
                upperDiagonal[(n - 1) + (col - row)] == 0) {

                // 1. Queen place karo aur Hash arrays update karo
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[(n - 1) + (col - row)] = 1;

                // 2. Next column ke liye recursive call
                solve(col + 1, board, ans, leftRow, upperDiagonal, lowerDiagonal, n);

                // 3. Backtrack: Queen hatao aur Hash arrays reset (0) karo
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[(n - 1) + (col - row)] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> ans = new ArrayList<>();
        
        // Hash arrays initialize kar rahe hain
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        solve(0, board, ans, leftRow, upperDiagonal, lowerDiagonal, n);
        return ans;
    }
}