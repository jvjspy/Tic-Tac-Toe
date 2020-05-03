import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

public class GameOver extends JPanel{

	public GameOver(GameBoard gameBoard) {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(50);
		add(panel, BorderLayout.NORTH);
		
		JLabel congrlb = new JLabel("");
		congrlb.setFont(new Font("Consolas", Font.BOLD, 40));
		int winner=gameBoard.getWinner();
		if(winner==0){
			congrlb.setText("TIE!");
		}else if(winner==-10){
			gameBoard.getGame().incPlayerScore();
			congrlb.setForeground(Color.BLUE);
			congrlb.setText("YOU WIN!");
		}else {
			gameBoard.getGame().incAIScore();
			congrlb.setForeground(Color.RED);
			congrlb.setText("YOU LOST!");
		}
		panel.add(congrlb);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
		
		JButton restartbtn = new JButton("");
		restartbtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		restartbtn.setIcon(IconFactory.getIcon(Icon.RESTART));
		restartbtn.setContentAreaFilled(false);
		restartbtn.setFocusPainted(false);
		restartbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		restartbtn.addActionListener((e)->{
			gameBoard.clearBoard();
			gameBoard.getGame().setScene(this,gameBoard);
			gameBoard.repaint();
		});
		panel_1.add(restartbtn);
	}
}
//end
























//end