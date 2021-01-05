package algorithm12_20.ms;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
        //use backtracking algorithm
        fillSudokuCells(board);
   }
   
    private boolean fillSudokuCells(char[][] board) {
        //use backtracking algorithm
         int row = -1;
         int col = -1;
         char ch;
         boolean isEmpty = true;
         for(int i = 0; i< board.length; i++){
              for(int j = 0; j < board[0].length;j++){
                  ch = board[i][j];
                  if(ch == '.')
                  {
                      row = i;
                      col = j;
                      isEmpty = false;
                      break;  
                  }
              }
             if(!isEmpty)
             {
                 break;
             }
         }
       
       //terminate if no empty cell
        if(isEmpty){
            return true;
        }
        //assign numbers from 1 to 9
        for(int num = 1; num<=9; num++){
            if(isSafe(board,row, col,num)){
                board[row][col] = (char)(num + '0');
                if(fillSudokuCells(board))
                {
                    return true;
                }
                else{
                    board[row][col] = '.';
                }
            }
           
        }
        return false;
    }
       
   private boolean isSafe(char[][] board, int row, int col, int num){
       //1. Check row if number is not assigned
        int value=0;
        for(int i =  0; i< board[0].length;i++){
            value = board[row][i] - '0';
            if(value == num)
            {
               return false; 
            }
        }
        //2. Check colum if number is not assigned
        for(int i =  0; i< board.length;i++){
            value = board[i][col] - '0';
            if(value == num)
            {
               return false; 
            }
        }
       //3. Check the current 3X3 gird if number is assigned
       row = row - row % 3;
       col = col - col % 3;
       for(int i = row; i< row + 3; i++ ){
            for( int j= col; j< col+3;j++){
                value = board[i][j] - '0';
                if(value == num){
                    return false;
                }
            }
       }
       return true;
   }
}
