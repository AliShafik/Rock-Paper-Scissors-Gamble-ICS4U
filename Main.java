import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class Main {

  public static class CLayout{

    JFrame startFrame = new JFrame("Rock Paper Scissors Gamble");
    JPanel panelCont = new JPanel();
    CardLayout cl = new CardLayout();
      
    JPanel startingPanel = new JPanel();
    JButton startGameButton = new JButton("Start Game");
    JButton instructionsButton = new JButton("Instructions");

    JPanel infoPanel = new JPanel();
    JButton backButton = new JButton("Back");

    JPanel amountPanel = new JPanel();

    JPanel namePanel = new JPanel();

    public CLayout(){

      panelCont.setLayout(cl);

      //STARTING PANEL
      
      startingPanel.setLayout(null);

      JLabel gameTitle1 = new JLabel("Rock Paper Scissors"); 
      gameTitle1.setFont(new Font("Verdana", Font.PLAIN, 35));
      gameTitle1.setBounds(50,70, 400, 50); 
      startingPanel.add(gameTitle1);

      JLabel gameTitle2 = new JLabel("Gamble"); 
      gameTitle2.setFont(new Font("Verdana", Font.PLAIN, 35));
      gameTitle2.setBounds(155,120, 400, 50); 
      startingPanel.add(gameTitle2);
      
      startGameButton.setBounds(50,200,150,25);
      startGameButton.setFocusable(false);
      startingPanel.add(startGameButton);

      instructionsButton.setBounds(250,200,150,25);
      instructionsButton.setFocusable(false);
      startingPanel.add(instructionsButton);

      startGameButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
          cl.show(panelCont, "3");
        }
      });

      instructionsButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
          cl.show(panelCont, "2");
        }
      });

      //INSTRUCTIONS PANEL

      infoPanel.setLayout(null);

      JLabel infoTitle = new JLabel("Instructions"); 
      infoTitle.setFont(new Font("Verdana", Font.PLAIN, 35));
      infoTitle.setBounds(120,-170,300,400); 
      infoPanel.add(infoTitle);

      JLabel howToPlayLabel = new JLabel("How to Play:"); 
      howToPlayLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
      howToPlayLabel.setBounds(20,40,400,50); 
      infoPanel.add(howToPlayLabel);

      JLabel firstInfo = new JLabel("1. Enter an even amount of players and their names."); 
      firstInfo.setFont(new Font("Verdana", Font.PLAIN, 15));
      firstInfo.setBounds(20,80,400,25); 
      infoPanel.add(firstInfo);

      JLabel secondInfo = new JLabel("<html>2. Enter amount of money for each player in order<br/>of who will play first without the “$” sign.</html>"); 
      secondInfo.setFont(new Font("Verdana", Font.PLAIN, 15));
      secondInfo.setBounds(20,105,400,35); 
      infoPanel.add(secondInfo);

      JLabel thridInfo = new JLabel("3. Wait for game results."); 
      thridInfo.setFont(new Font("Verdana", Font.PLAIN, 15));
      thridInfo.setBounds(20,140,400,25); 
      infoPanel.add(thridInfo);

      JLabel fourthInfo = new JLabel("<html>4. Step 3 will repeat for the next players games<br/>until no more games are left.</html>");
      fourthInfo.setFont(new Font("Verdana", Font.PLAIN, 15));
      fourthInfo.setBounds(20,165,400,35);
      infoPanel.add(fourthInfo);

      JLabel fifthInfo = new JLabel("<html>5. Click replay if you would like to play again or click<br/>quit to close the program.</html>");
      fifthInfo.setFont(new Font("Verdana", Font.PLAIN, 15));
      fifthInfo.setBounds(20,205,400,35);
      infoPanel.add(fifthInfo);

      backButton.setBounds(150,250,150,25);
      backButton.setFocusable(false);
      infoPanel.add(backButton);

      backButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
          cl.show(panelCont, "1");
        }
      });

      //AMOUNT PANEL

      JLabel amountInfo = new JLabel("<html>Enter the amount of players<br/>playing in numbers please<br/>and hit enter:</html>");
      amountInfo.setFont(new Font("Verdana", Font.PLAIN, 25));
      amountInfo.setBounds(40,205,400,35);
      amountPanel.add(amountInfo);

      JTextField amountPlayersInputBox = new JTextField(3);
      amountPlayersInputBox.setHorizontalAlignment(JTextField.CENTER);
      amountPlayersInputBox.setFont(new Font("Verdana", Font.PLAIN, 35));
      amountPanel.add(amountPlayersInputBox);

      amountPlayersInputBox.addActionListener(new ActionListener(){
        int amountPlayers;
        @Override
        public void actionPerformed(ActionEvent e){
          try{
            int amountInput = Integer.parseInt(amountPlayersInputBox.getText());
            if (amountInput % 2 == 0 && amountInput != 0)
              cl.show(panelCont, "4");
              amountPlayers = amountInput;
            if (amountInput % 2 == 1 || amountInput == 0)
              amountInfo.setText("<html>Please erase your answer<br/>and enter an even number.</html>");
          }
          catch(NumberFormatException ioe){
            amountInfo.setText("<html>Please erase your answer<br/>and enter an even number.</html>");
          }
        }
      });
      
      //NAMES PANEL

      int[] playerNames = new int[amountPlayers];

      //CONT PANEL ADJUSTMENTS

      panelCont.add(startingPanel, "1");
      panelCont.add(infoPanel, "2");
      panelCont.add(amountPanel, "3");
      panelCont.add(namePanel, "4");
      cl.show(panelCont, "1");

      //FRAME TO HOLD ALL PANELS

      startFrame.add(panelCont);
      startFrame.setSize(450, 350);
      startFrame.setLocation(100, 100);
      startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      startFrame.setVisible(true);
    }
  }

  public static void main(String[] args) {

    new CLayout();
    
    /*do{
      new MainMenu();
      put other classes here
      user clicks play playAgain
      sets playagain to true
      user clicks quit game
      sets playagain false

    }while(playAgain==true);*/
    
  }
}

