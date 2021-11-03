import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class Main {

  public static class CLayout{

    JFrame startFrame = new JFrame("Rock Paper Scissors Gamble");

    public class infoToRetreive{
      private JPanel panelCont = new JPanel();
      private CardLayout cl = new CardLayout();

      public CardLayout getcl(){
        return cl;
      }

      public JPanel getPanelCont(){
        return panelCont;
      }
    }

    public CLayout(){

      infoToRetreive infoRetreival = new infoToRetreive();

      JPanel panelcont = infoRetreival.getPanelCont();
      CardLayout cl = infoRetreival.getcl();
      
      panelcont.setLayout(cl);

      //STARTING PANEL

      JPanel startingPanel = new JPanel();
      JButton startGameButton = new JButton("Start Game");
      JButton instructionsButton = new JButton("Instructions");
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
          cl.show(infoRetreival.getPanelCont(), "3");
        }
      });

      instructionsButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
          cl.show(infoRetreival.getPanelCont(), "2");
        }
      });

      //INSTRUCTIONS PANEL

      JPanel infoPanel = new JPanel();
      JButton backButton = new JButton("Back");
      infoPanel.setLayout(null);

      JLabel infoTitle = new JLabel("Instructions"); 
      infoTitle.setFont(new Font("Verdana", Font.PLAIN, 35));
      infoTitle.setBounds(120,-170,300,400); 
      infoPanel.add(infoTitle);

      JLabel howToPlayLabel = new JLabel("How to Play:"); 
      howToPlayLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
      howToPlayLabel.setBounds(20,40,400,50); 
      infoPanel.add(howToPlayLabel);

      JLabel firstInfo = new JLabel("1. Enter player names."); 
      firstInfo.setFont(new Font("Verdana", Font.PLAIN, 15));
      firstInfo.setBounds(20,80,400,25); 
      infoPanel.add(firstInfo);

      JLabel secondInfo = new JLabel("<html>2. Enter amount of money for each player<br/>without the “$” sign.</html>"); 
      secondInfo.setFont(new Font("Verdana", Font.PLAIN, 15));
      secondInfo.setBounds(20,105,400,35); 
      infoPanel.add(secondInfo);

      JLabel thridInfo = new JLabel("3. Wait for game results."); 
      thridInfo.setFont(new Font("Verdana", Font.PLAIN, 15));
      thridInfo.setBounds(20,140,400,25); 
      infoPanel.add(thridInfo);

      JLabel fourthInfo = new JLabel("<html>4. Click replay if you would like to play again or click<br/>quit to close the program.</html>");
      fourthInfo.setFont(new Font("Verdana", Font.PLAIN, 15));
      fourthInfo.setBounds(20,165,400,35);
      infoPanel.add(fourthInfo);

      backButton.setBounds(150,250,150,25);
      backButton.setFocusable(false);
      infoPanel.add(backButton);

      backButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
          cl.show(infoRetreival.getPanelCont(), "1");
        }
      });
      
      //NAMES PANEL

      JPanel namesPanel = new JPanel();
      namesPanel.setLayout(null);

      JLabel namesInfo = new JLabel("<html>Please enter the names of each<br/>player in the textfields and click<br/>enter for each and then click continue:</html>");
      namesInfo.setFont(new Font("Verdana", Font.PLAIN, 20));
      namesInfo.setBounds(30,15,400,100);
      namesPanel.add(namesInfo);

      JLabel player1Label = new JLabel("Player 1:");
      player1Label.setFont(new Font("Verdana", Font.PLAIN, 35));
      player1Label.setBounds(50,105,400,100);
      namesPanel.add(player1Label);

      JTextField name1Field = new JTextField(45);
      name1Field.setBounds(250,125,150,60);
      name1Field.setFont(new Font("Verdana", Font.PLAIN, 45));
      namesPanel.add(name1Field);

      JLabel player2Label = new JLabel("Player 2:");
      player2Label.setFont(new Font("Verdana", Font.PLAIN,35));
      player2Label.setBounds(50,170,400,100);
      namesPanel.add(player2Label);

      JTextField name2Field = new JTextField(45);
      name2Field.setBounds(250,190,150,60);
      name2Field.setFont(new Font("Verdana", Font.PLAIN, 45));
      namesPanel.add(name2Field);

      JButton continueButton1 = new JButton("Continue");
      continueButton1.setBounds(150,260,150,25);
      continueButton1.setFocusable(false);
      namesPanel.add(continueButton1);
      continueButton1.setEnabled (false);

      continueButton1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
          cl.show(infoRetreival.getPanelCont(), "4");
        }
      });

      class Name1Field implements ActionListener{
        String name1;
        boolean nextAccess1;
        @Override
        public void actionPerformed(ActionEvent arg0){
          name1 = name1Field.getText();
          name1Field.setBackground(Color.GREEN);
          nextAccess1 = true;
        }
        public String getName1(){
          return name1;
        }
        public boolean getAccess1(){
          return nextAccess1;
        }
      }

      Name1Field nameGetter1 = new Name1Field();
      name1Field.addActionListener(nameGetter1);

      class Name2Field implements ActionListener{
        String name2;
        boolean nextAccess2;
        @Override
        public void actionPerformed(ActionEvent arg0){
          name2 = name2Field.getText();
          name2Field.setBackground(Color.GREEN);
          nextAccess2 = true;
          if (nameGetter1.getAccess1() && nextAccess2){
          continueButton1.setEnabled(true);
          }
        }
        public String getName2(){
          return name2;
        }
      }

      Name2Field nameGetter2 = new Name2Field();
      name2Field.addActionListener(nameGetter2);

      //MONEY PANEL

      JPanel moneyPanel = new JPanel();
      moneyPanel.setLayout(null);

      JLabel moneyInfo = new JLabel("<html>Please enter the amount of money each player will be<br/>putting in and hit enter:</html>");
      moneyInfo.setFont(new Font("Verdana", Font.PLAIN, 25));
      moneyInfo.setBounds(50,15,400,100);
      moneyPanel.add(moneyInfo);

      JLabel money1Label = new JLabel("Money for 1:");
      money1Label.setFont(new Font("Verdana", Font.PLAIN, 35));
      money1Label.setBounds(25,105,400,100);
      moneyPanel.add(money1Label);

      JTextField money1Field = new JTextField(45);
      money1Field.setBounds(250,125,150,60);
      money1Field.setFont(new Font("Verdana", Font.PLAIN, 45));
      moneyPanel.add(money1Field);

      JLabel money2Label = new JLabel("Money for 2:");
      money2Label.setFont(new Font("Verdana", Font.PLAIN, 35));
      money2Label.setBounds(25,170,400,100);
      moneyPanel.add(money2Label);

      JTextField money2Field = new JTextField(45);
      money2Field.setBounds(250,190,150,60);
      money2Field.setFont(new Font("Verdana", Font.PLAIN, 45));
      moneyPanel.add(money2Field);

      JButton continueButton2 = new JButton("Continue");
      continueButton2.setBounds(150,270,150,25);
      continueButton2.setFocusable(false);
      moneyPanel.add(continueButton2);
      continueButton2.setEnabled (false);

      continueButton2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
          cl.show(infoRetreival.getPanelCont(), "5");
        }
      });

      class Money1Field implements ActionListener{
        private double money1;
        private boolean nextAccess3;
        @Override
        public void actionPerformed(ActionEvent arg0){
          try{
            money1 = Double.parseDouble(money1Field.getText());
            money1Field.setBackground(Color.GREEN);
            nextAccess3 = true;
          }
          catch(NumberFormatException ioe){
            moneyInfo.setText("<html>Please erase and enter a<br/>valid money amount</html>");
            money1Field.setBackground(Color.RED);
            nextAccess3 = false;
            continueButton2.setEnabled(false);
          }
        }
        public double getMoney1(){
          return money1;
        }
        public boolean getAccess3(){
          return nextAccess3;
        }
      }

      Money1Field moneyGetter1 = new Money1Field();
      money1Field.addActionListener(moneyGetter1);

      class Money2Field implements ActionListener{
        private double money2;
        private boolean nextAccess4;
        @Override
        public void actionPerformed(ActionEvent arg0){
          try{
            money2 = Double.parseDouble(money2Field.getText());
            money2Field.setBackground(Color.GREEN);
            nextAccess4 = true;
          }
          catch(NumberFormatException ioe){
            moneyInfo.setText("<html>Please erase and enter a<br/>valid money amount and hit enter</html>");
            money2Field.setBackground(Color.RED);
            nextAccess4 = false;
            continueButton2.setEnabled(false);
          }
          if (moneyGetter1.getAccess3() && nextAccess4){
            continueButton2.setEnabled(true);
          }
        }
        public double getMoney2(){
          return money2;
        }
      }

      Money2Field moneyGetter2 = new Money2Field();
      money2Field.addActionListener(moneyGetter2);

      //WINNER PANEL

      JPanel winnerPanel = new JPanel();
      winnerPanel.setLayout(null);

      double moneyTotal = moneyGetter1.getMoney1() + moneyGetter2.getMoney2();

      List<String> namesList = new ArrayList<String>();
      namesList.add(nameGetter1.getName1());
      namesList.add(nameGetter2.getName2());

      String winner;

      Results results = new Results();
      String winnerResult = results.returnWinner();

      if (winnerResult.equals("1")){
        winner = namesList.get(0);
      }
      else if (winnerResult.equals("2")){
        winner = namesList.get(1);
      }
      else{
        winner = "It's a tie!";
      }

      JLabel winnerDisplay = new JLabel("The winner is: ");
      winnerDisplay.setFont(new Font("Verdana", Font.PLAIN, 35));
      winnerDisplay.setBounds(25,50,400,100);
      winnerPanel.add(winnerDisplay);

      JLabel totalMoneyDisplay= new JLabel("The money won is: ");
      totalMoneyDisplay.setFont(new Font("Verdana", Font.PLAIN, 35));
      totalMoneyDisplay.setBounds(25,100,400,100);
      winnerPanel.add(totalMoneyDisplay);

      //CONT PANEL ADJUSTMENTS

      infoRetreival.getPanelCont().add(startingPanel, "1");
      infoRetreival.getPanelCont().add(infoPanel, "2");
      infoRetreival.getPanelCont().add(namesPanel, "3");
      infoRetreival.getPanelCont().add(moneyPanel, "4");
      infoRetreival.getPanelCont().add(winnerPanel, "5");
      cl.show(infoRetreival.getPanelCont(), "1");

      //FRAME TO HOLD ALL PANELS

      startFrame.add(infoRetreival.getPanelCont());
      startFrame.setSize(450, 350);
      startFrame.setLocation(100, 100);
      startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      startFrame.setVisible(true);
    }
  }

  public static void main(String[] args) {
    new CLayout();   
  }
}
