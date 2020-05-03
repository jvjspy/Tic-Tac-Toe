import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GameBoard extends JPanel implements ActionListener {

	private char[][] board;
	private JButton[][] cells;
	private boolean AIFirst;
	private AI bot;
	private Game game;
	private int winner;
	private final ImageIcon xIcon = IconFactory.getIcon(Icon.X);
	private final ImageIcon oIcon = IconFactory.getIcon(Icon.O);

	public int getWinner() {
		return winner;
	}

	public Game getGame() {
		return game;
	}

	public GameBoard(Game g) {
		game = g;
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new GridLayout(3, 3, 20, 20));
		createBoard();
		AIFirst = false;
		winner = -1;
		bot = new AI(board);
	}

	public void clearBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cells[i][j].setIcon(null);
				board[i][j] = '_';
			}
		}
		if (AIFirst) {
			int[] move = bot.takeTurn();
			cells[move[0]][move[1]].setIcon(oIcon);
			board[move[0]][move[1]] = 'o';
		}
		AIFirst = !AIFirst;
		winner = -1;
	}

	private void createBoard() {
		cells = new JButton[3][3];
		board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cells[i][j] = new JButton();
				cells[i][j].setContentAreaFilled(false);
				cells[i][j].setBorder(new EmptyBorder(0, 0, 0, 0));
				cells[i][j].setFocusPainted(false);
				cells[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
				add(cells[i][j]);
				cells[i][j].addActionListener(this);
				board[i][j] = '_';
			}
		}
	}

	private void drawGrid(Graphics g) {
		g.setColor(Color.BLACK);
		int w = getWidth();
		int h = getHeight();
		g.fillRoundRect((w - 40) / 3, 0, 20, h, 45, 45);
		g.fillRoundRect(2 * (w - 40) / 3 + 20, 0, 20, h, 45, 45);
		g.fillRoundRect(0, (h - 40) / 3, w, 20, 45, 45);
		g.fillRoundRect(0, 2 * (h - 40) / 3 + 20, w, 20, 45, 45);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawGrid(g);
	}

	public int[] getPos(JButton btn) {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (cells[i][j] == btn)
					return new int[] { i, j };
		return null;
	}

	public void checkForWinner() {
		int i = GameUtils.checkGameState(board);
		if (i != 0 || (i == 0 && GameUtils.isCellFull(board))) {
			winner = i;
			game.setScene(this, new GameOver(this));
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton cell = (JButton) event.getSource();
		int[] move = getPos(cell);
		if (GameUtils.isValidMove(board, move) && winner == -1) {
			board[move[0]][move[1]] = 'x';
			cells[move[0]][move[1]].setIcon(xIcon);
			getToolkit().beep();
			checkForWinner();
			move = bot.takeTurn();
			if (move[0] > -1 && move[1] > -1) {
				cells[move[0]][move[1]].setIcon(oIcon);
				board[move[0]][move[1]] = 'o';
				checkForWinner();
			}
		}
	}
}// end

//end
