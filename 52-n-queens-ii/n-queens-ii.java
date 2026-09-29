import java.util.*;
class Solution{
    static boolean isSafe(int row ,int col,char[][]board,int n){
        int duprow=row;
        int dupcol=col;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q')
            return false;
            row--;
            col--;
        }
        row =duprow;
        col=dupcol;
        while(col>=0){
            if(board[row][col]== 'Q')
            return false;
            col--;
        }
        row=duprow;
        col=dupcol;
        while(row<n && col>=0){
            if(board[row][col]=='Q')
            return false;
            row++;
            col--;
        }
        return true;
        
    }
    static int solve(int col,char[][]board,int n){
        if(col==n){
            return 1;
            
        }
          int cnt=0;
        for(int row=0;row<n;row++){
            if (isSafe(row,col,board,n)){
                board[row][col]='Q';
              cnt+= solve(col+1,board,n);
                board[row][col]='.';
            }
        }
        return cnt;
    }
     public int totalNQueens(int n){
     
        char[][]board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
      
       return solve(0,board,n);
        
    }

}






