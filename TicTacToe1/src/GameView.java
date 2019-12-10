import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameView extends JPanel{
	 public int turn;
	 FactoryPiece facP = new FactoryPiece();

	private static final long serialVersionUID = 1L;
	
	//Build view members
	public static JButton squares[] = new JButton[9];
	
	
	//Constructor
	public GameView() {
		

	
		setLayout(new GridLayout(3, 3));
		makeSquares();
		setBackground(Color.CYAN);
		
		
	}
	
	public void makeSquares(){
		for(int i = 0; i<= 8; i++) {

			squares[i] = new JButton();
			squares[i].setText("");
			squares[i].addActionListener(new buttonListener());


			add(squares[i]);

			}
	}
	
	public class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(turn==8 ) {
				checkForWin();
				if(checkForWin() == true) {
					JOptionPane.showMessageDialog(null, "Player Wins or Tie.");
					System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "Player Wins or Tie.");
					System.exit(0);
				}
			}
			
			else {
			GamePieces user = facP.setTurn(turn);
			JButton buttonClicked = (JButton)e.getSource();
			
			buttonClicked.setText(user.getMark());
			buttonClicked.setEnabled(false);
			turnCheck();
			
			computerTurn();
			checkWhoWon(checkForWin());
			
			}
		
		
			

				

			}
			
		}
	public boolean checkForWin() {

		if( checkAdjacent(0,1) && checkAdjacent(1,2) ) //no need to put " == true" because the default check is for true
		             return true;

		         else if( checkAdjacent(3,4) && checkAdjacent(4,5) )
		             return true;

		         else if ( checkAdjacent(6,7) && checkAdjacent(7,8))
		             return true;

		         

		         //vertical win check

		         else if ( checkAdjacent(0,3) && checkAdjacent(3,6))
		             return true;  

		         else if ( checkAdjacent(1,4) && checkAdjacent(4,7))
		             return true;

		         else if ( checkAdjacent(2,5) && checkAdjacent(5,8))
		             return true;

		         

		         //diagonal win check

		         else if ( checkAdjacent(0,4) && checkAdjacent(4,8))
		             return true;  

		         else if ( checkAdjacent(2,4) && checkAdjacent(4,6))
		             return true;

		         else 
		             return false;

		         

		         

		     }

		public boolean checkAdjacent(int a, int b){

		    if ( squares[a].getText().equals(squares[b].getText()) && !squares[a].getText().equals("") )
		        return true;

		    else
		        return false;

		}
		
		public void turnCheck() {
			turn++;
		}
		
		public void computerTurn() {
			
			GamePieces user1 = facP.setTurn(turn);
			
			int i = (int) Math.floor(Math.random() * 9);
			
			checkWhoWon(checkForWin());
			if(squares[i].isEnabled() == true) {
				squares[i].setText(user1.getMark());
				squares[i].setEnabled(false);
				turn++;
			}
			else if (turn == 6){
				
				
			}
			else {
				while(squares[i].isEnabled() == false) {
					 i = (int) Math.floor(Math.random() * 9);
				}
				squares[i].setText(user1.getMark());
				squares[i].setEnabled(false);
				turn++;
			}
			
		}
		
		public void checkWhoWon(Boolean b){
			if(b == true) {
				if(turn%2 == 0) {
				JOptionPane.showMessageDialog(null, "Computer Wins.");
				System.exit(0);
				}

				else {
				JOptionPane.showMessageDialog(null, "Player Wins.");
				System.exit(0);
				 	}
				}
		}

}
	

