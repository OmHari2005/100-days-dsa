class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char[][]board){
        for (int i =0;i<board.length;i++){
            for (int j=0;j<board.length;j++){
                if(board[i][j]=='.'){
                    for( char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                            if(solve(board)==true)
                            return true;
                            else
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean isValid(char[][]board,int row,int col,char c){
        for(int i =0;i<9;i++){
            if(board[i][col]==c)
            return false;
            if(board[row][i]==c)
            return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c)
            return false;
        }
        return true;
    }
}
/* when we want to print all solution then this code
class Solution {
    int solutionCount = 0; // Tracks total valid solutions found

    public void solveSudoku(char[][] board) {
        solve(board);
        System.out.println("Total solutions: " + solutionCount);
    }

    void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            // 1. Recurse to fill remaining cells
                            solve(board);

                            // 2. ALWAYS backtrack to explore other valid choices
                            board[i][j] = '.';
                        }
                    }
                    // Tried '1' through '9' on this empty cell; return to explore other branches
                    return;
                }
            }
        }

        // 3. Reached here only when no '.' is left in the grid -> VALID SOLUTION!
        solutionCount++;
        printBoard(board);
    }

    boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;
            if (board[row][i] == c)
                return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }

    void printBoard(char[][] board) {
        System.out.println("--- Solution " + solutionCount + " ---");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
*/