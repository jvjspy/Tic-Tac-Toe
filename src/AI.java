import static java.lang.Math.*;
public class AI {
	private char[][] board;
	public AI(char[][] b){
		board=b;
	}
	public int[] takeTurn(){
		int[] move=new int[]{-1,-1};
		int best=-1000;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[i][j]=='_'){
					board[i][j]='o';
					int score=AIhelper(0,false);
					if(score>best){
						best=score;
						move[0]=i;
						move[1]=j;
					}
					board[i][j]='_';
				}
			}
		}
		return move;
	}
	private int AIhelper(int depth,boolean isAITurn){
		int score=GameUtils.checkGameState(board);
		if(score==10)		return score-depth;
		if(score==-10)	return score+depth;
		if(GameUtils.isCellFull(board))		return 0;
		if(isAITurn){
			int best=-1000;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(board[i][j]=='_'){
						board[i][j]='o';
						best=max(best,AIhelper(depth+1,false));
						board[i][j]='_';
					}
				}
			}
			return best;
		}else {
			int best=1000;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(board[i][j]=='_'){
						board[i][j]='x';
						best=min(best,AIhelper(depth+1,true));
						board[i][j]='_';
					}
				}
			}
			return best;
		}
	}
}
//end
























//end