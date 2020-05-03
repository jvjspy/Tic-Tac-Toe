import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Game extends JFrame {

    private JPanel contentPane;
    private GameBoard board;
    private JLabel playerScore;
    private JLabel aiScore;
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Game frame = new Game();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public Game() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 500, 500);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	
	JPanel panel = new JPanel();
	contentPane.add(panel, BorderLayout.NORTH);
	
	JLabel lblNewLabel = new JLabel("TIC TAC TOE");
	lblNewLabel.setForeground(Color.RED);
	lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
	panel.add(lblNewLabel);
	
	board = new GameBoard(this);
	contentPane.add(board, BorderLayout.CENTER);
	
	JPanel panel_2 = new JPanel();
	contentPane.add(panel_2, BorderLayout.SOUTH);
	
	JLabel lblNewLabel_1 = new JLabel("YOU( X ): ");
	lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 20));
	lblNewLabel_1.setForeground(Color.RED);
	panel_2.add(lblNewLabel_1);
	
	playerScore = new JLabel("0");
	playerScore.setFont(new Font("Consolas", Font.BOLD, 20));
	panel_2.add(playerScore);
	
	JLabel lblNewLabel_3 = new JLabel(" VS ");
	lblNewLabel_3.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
	lblNewLabel_3.setForeground(Color.MAGENTA);
	panel_2.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("AI( O ): ");
	lblNewLabel_4.setForeground(Color.BLUE);
	lblNewLabel_4.setFont(new Font("Consolas", Font.BOLD, 20));
	panel_2.add(lblNewLabel_4);
	
	aiScore = new JLabel("0");
	aiScore.setFont(new Font("Consolas", Font.BOLD, 20));
	panel_2.add(aiScore);
    }
    public void incPlayerScore(){
    	playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText())+1));
    }
    public void incAIScore(){
    	aiScore.setText(String.valueOf(Integer.parseInt(aiScore.getText())+1));
    }
    public void setScene(Component oldScene,Component newSence){
    	remove(oldScene);
    	add(newSence);
    }
}
//end
























//end
