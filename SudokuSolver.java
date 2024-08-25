import java.util.*;
public class SudokuSolver {
    public static void main(String[] args) {
        int [][] board=new int[][]{ {3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0} };
 if(solve(board)){
   display(board);
 }else{
    System.out.println("cannot Solve");
 }
    }
    static boolean solve(int [][] board){
        int n=board.length;
        int row=-1;
        int col=-1;
        boolean emptyleft=true;
        //replacing r,c from arguments
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){//found an empty Item
                    row=i;
                    col=j;
                    emptyleft=false;
                    break;
                }
            }
            //if u found some emty element in row ,then break
            if(emptyleft==false) {
                break;
            }
            
        }
    
        if(emptyleft==true){
            return true;
            //sudoku is solved
        }
           //backtracking
           for(int number=1;number<=9;number++){
            if(isSafe(board, row, col, number)){
                board[row][col]=number;
                if(solve(board)){
                    //found the answer
                    
                    return true;
                }else{
                    //backtrack
                    board[row][col]=0;
                }
            }
        }
        return false;
    }
     static void display(int[][] board) {
            for(int[] row :board){
                for(int num:row){
                    System.out.print(num+" ");

                }
                System.out.println();
            }
    }
    static boolean isSafe(int [][]board,int row,int col,int num){
        //check the row
        for(int i=0;i<board.length;i++){
            //check if the number is in row or not
            if(board[row][col]==num){
                return false;
            }
           
        }
//check the col
        for(int []nums:board){
            //check if the number is in col or not
            if(nums[col]==num){
                return false;
            }
           
        }
        int sqrt=(int)(Math.sqrt(board.length));
        int rowstart=row-row%sqrt;
        int colstart=col-col%sqrt;
         //for row
        for(int r=rowstart;r<rowstart+sqrt;r++){
          //for col
          for(int c=colstart;c<colstart+sqrt;c++){
                if(board[r][c]==num){
                    return false;
                }
          }
        }
        return true;
    }

}
