
public class EightQueens {
	private final int size=8;
	private int[][] board=new int[size][size];
	
	private void printSolution(){
		for (int i=0;i<8;i++){
			for (int j=0;j<8;j++){
				System.out.print(this.board[i][j]);
			}
			System.out.println();
		}
	}
	
	private boolean isSafe(int row, int col){
		//This utility function checks columns on the left
		for (int i=0;i<col;i++){
			if(board[row][i]==1){
				return false;
			}
		}
		for (int i=row, j=col; i>=0 && j>=0; i--, j--){
			if(board[i][j]==1){
				return false;
			}
		}
		for (int i=row, j=col; j>=0 && i<size; i++, j--){
			if(board[i][j]==1){
				return false;
			}
		}
		return true;
	}
	
	private boolean backtracking(int col){
		if (col==size){return true;}
		for (int i=0;i<size;i++){
			if (isSafe(i,col)){
				board[i][col]=1;
				if (backtracking(col+1)){
					return true;
				}
				board[i][col]=0;
			}
				
		}
		return false;
	}
	
	private void solve8Q(){
		if (!backtracking(0)){
			System.out.println("No solution for 8 queens!");
		}else {
			printSolution();
		}
	}

	public static void main(String[] args) {
		EightQueens prob=new EightQueens();
		prob.solve8Q();
	}

}
