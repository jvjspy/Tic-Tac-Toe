
public class GameUtils {
	
	public static boolean isValidMove(char[][] board,int[] move){
		return board[move[0]][move[1]]=='_';
	}
	
	public static boolean isCellFull(char[][] board){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[i][j]=='_')	return false;
			}
		}
		return true;
	}
	
	private static int checkRow(char[][] board,int r){
		if(board[r][0]==board[r][1]&&board[r][1]==board[r][2]){
			if(board[r][0]=='o')	return 10;
			else if(board[r][0]=='x')	return -10;
		}
		return 0;
	}
	
	private static int checkColumn(char[][] board,int c){
		if(board[0][c]==board[1][c]&&board[1][c]==board[2][c]){
			if(board[0][c]=='o')	return 10;
			else if(board[0][c]=='x')	return -10;
		}
		return 0;
	}
	
	private static int checkDiagonal(char[][] board){
		if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]){
			if(board[0][0]=='o')	return 10;
			else if(board[0][0]=='x')	return -10;
		}
		if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]){
			if(board[0][2]=='o')	return 10;
			else if(board[0][2]=='x')	return -10;
		}
		return 0;
	}
	
	public static int checkGameState(char[][] board){
		int res;
		for(int r=0;r<3;r++){
			res=checkRow(board,r);
			if(res!=0)	return res;
		}
		for(int c=0;c<3;c++){
			res=checkColumn(board,c);
			if(res!=0)	return res;
		}
		res=checkDiagonal(board);
		if(res!=0)	return res;
		return 0;
	}
}
//end
























//end