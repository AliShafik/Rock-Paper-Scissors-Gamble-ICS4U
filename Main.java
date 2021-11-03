/*
Rock Paper Scissors Gamble asks the user for player names, then asks for the amount of money each player is putting in. The program then calculates the total money and assigns a random number to each name which decides who wins or ties the rock, paper,scissors game. The winner is then displayed with the total money they won. The user gets the option to play again or quit after.
*/

//Imports for all features in code

//Imports for java swing
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Import for scanner for user input
import java.util.Scanner;

class Main {

  //Class for layout to manage panels and frame
  public static class CLayout {
    
    //Class to retrieve main frame, main panel and card layout 
    public class infoToRetreive {
      private JPanel panelCont = new JPanel(); //main panel
      private CardLayout cl = new CardLayout(); //card layout to manage all panels
      private JFrame startFrame = new JFrame("Rock Paper Scissors Gamble"); //main frame 

      //Getters for main frame, main panel and card layout
      public CardLayout getcl() {
        return cl;
      }

      public JPanel getPanelCont() {
        return panelCont;
      }

      public JFrame getStartingFrame() {
        return startFrame;
      }
    }

    public CLayout() {

      //Scanner class for user input
      Scanner input = new Scanner(System.in);

      //Retrieving info from class above to re-use
      infoToRetreive infoRetreival = new infoToRetreive();
      JPanel panelcont = infoRetreival.getPanelCont();
      CardLayout cl = infoRetreival.getcl();
      JFrame startFrame = infoRetreival.getStartingFrame();
      
      //Setting main panel to follow the card layout
      panelcont.setLayout(cl);

      // FRAME TO HOLD ALL PANELS

      //Setting attributes of main frame
      startFrame.add(infoRetreival.getPanelCont());
      startFrame.setSize(450, 350);
      startFrame.setLocation(100, 100);
      startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      startFrame.setVisible(true);

      // STARTING PANEL

      //Declaring starting panel
      JPanel startingPanel = new JPanel();
      startingPanel.setLayout(null); //setting layout to null to allow for movement of items

      //Labels to display on starting label
      JLabel gameTitle1 = new JLabel("Rock Paper Scissors"); //declaring label
      gameTitle1.setFont(new Font("Verdana", Font.PLAIN, 35)); //setting font and font size of label
      gameTitle1.setBounds(50, 70, 400, 50); //setting the location of label
      startingPanel.add(gameTitle1); //adding label to panel

      JLabel gameTitle2 = new JLabel("Gamble");
      gameTitle2.setFont(new Font("Verdana", Font.PLAIN, 35));
      gameTitle2.setBounds(155, 120, 400, 50);
      startingPanel.add(gameTitle2);

      JButton startGameButton = new JButton("Start Game"); //declaring button
      startGameButton.setBounds(150, 200, 150, 25);
      startGameButton.setFocusable(false); //removing focus on button
      startingPanel.add(startGameButton);

      //Action Listener to scan button action
      startGameButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) { //checks for button click
          cl.show(infoRetreival.getPanelCont(), "2"); //shows next panel on button click
        }
      });

      // INSTRUCTIONS OUTPUT

      //Prints instructions to console
      System.out.println("---------------------------");
      System.out.println("Instructions");
      System.out.println("---------------------------");
      System.out.println("How to Play:");
      System.out.println("1. Login with player names.");
      System.out.println("2. Enter amount of money for each player without the “$” sign.");
      System.out.println("3. Click 'Start Game' for game results.");
      System.out.println("4. Click replay if you would like to play again or click quit to close the program.");

      // OUTPUT FOR USER INFO

      //Creating variables and list for names and money of each player
      String[] namesList = new String[2];
      namesList[0] = "1";
      namesList[1] = "2";
      double money1 = 0;
      double money2 = 0;
      boolean again = false; //for restarting just in case of false answer
      
      System.out.println("---------------------------");
      System.out.println("Login: ");
      String name1;
      String name2;
      do { //loop for errors
        System.out.println("---------------------------");
        //asks user for both names and stores them in variables
        System.out.println("Enter the first player name: ");
        name1 = input.nextLine();
        System.out.println("Enter the second player name: ");
        name2 = input.nextLine(); 
        if ("".equals(name1) || "".equals(name2)) { //checks to see if the user inputs nothing as a name 
          System.out.println("");
          System.out.println("Please enter a valid name. ");
          again = true; //sets to true so it resets because of wrong input
        } else {
          again = false; //sets to false so it does not reset because user enetered correct input
        }
        //adding names to a list
        namesList[0] = name1;
        namesList[1] = name2;
      } while (again); //while loop restes if again = true
      do {
        try { //try catch to catch inputs that are not ints
          System.out.println("---------------------------");
          System.out.println("Money:");
          System.out.println("---------------------------");
          //asks user for amount of money for each player and saves into variables
          System.out.println("How much money for " + name1 + ": ");
          money1 = Double.parseDouble(input.nextLine()); //parseInt to make sure the variable is an int not a string
          System.out.println("How much money for " + name2 + ": ");
          money2 = Double.parseDouble(input.nextLine());
          again = false; //sets loop to flase because of correct input
        } catch (NumberFormatException ioe) { //catches exception that is input that is not an int
          System.out.println("");
          System.out.println("Invalid input please try again and enter a number.");//informs user of invalid input
          again = true;//sets loop to true because of invalid input
        }
      } while (again); //loops when true

      // WINNER PANEL

      JPanel winnerPanel = new JPanel(); //creating winner panel
      winnerPanel.setLayout(null); //set layout to null to allow movement of attributes

      double moneyTotal = money1 + money2; //gets money total from both players

      //declaring result strings for final result of randomizer
      String result1;
      String result2;

      int randnumb1 = (int) (Math.random() * 3 + 1); //getting first random number for player 1
      int randnumb2 = (int) (Math.random() * 6 + 1) / 2; //getting second random number for player 2
      
      //checks to see what the random number will equal
      if (randnumb1 == 1) { //if 1 then rock
        result1 = "R";
      } else if (randnumb1 == 2) {//if 2 then paper
        result1 = "P";
      } else { //if 3 the scissors
        result1 = "S";
      }

      if (randnumb2 == 1) {
        result2 = "R";
      } else if (randnumb2 == 2) {
        result2 = "P";
      } else {
        result2 = "S";
      }

      Results results = new Results(); //creating results class to call checker
      results.setWinner(result1, result2); //setter method to compare reults
      int winner = 0; 
      winner = results.returnWinner(); //winner is equal to result of the result checker

      String winnerName = ""; 

      //checks to see who wins
      if (winner == 1) {//if winner is 1 then player 1 wins
        winnerName = namesList[0];//sets winner name to player 1 name
      } else if (winner == 2) {//if winner is 2 then player 2 wins
        winnerName = namesList[1]; //sets winner name to player 2 name
      } else { //if winner is 3 it is a tie
        winnerName = "It's a tie!";
      }

      //Labels to display on panel
      JLabel winnerDisplay = new JLabel("The winner is: " + winnerName); //displays the winner
      winnerDisplay.setFont(new Font("Verdana", Font.PLAIN, 25));
      winnerDisplay.setBounds(25, 50, 400, 100);
      winnerPanel.add(winnerDisplay);

      JLabel totalMoneyDisplay = new JLabel("The money won is: " + "$" + moneyTotal); //displays the total money won
      totalMoneyDisplay.setFont(new Font("Verdana", Font.PLAIN, 25));
      totalMoneyDisplay.setBounds(25, 100, 400, 100);
      winnerPanel.add(totalMoneyDisplay);

      JButton quitButton = new JButton("Quit"); //quit button to exit program
      quitButton.setFocusable(false);
      quitButton.setBounds(250, 200, 150, 25);
      winnerPanel.add(quitButton);

      JButton playAgainButton = new JButton("Play Again"); //play again button to reset program
      playAgainButton.setFocusable(false);
      playAgainButton.setBounds(50, 200, 150, 25);
      winnerPanel.add(playAgainButton);

      quitButton.addActionListener(new ActionListener() { //action listener to see if quit button is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
          System.exit(0); //closes program
        }
      });

      playAgainButton.addActionListener(new ActionListener() { //action listener to see if play again button is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
          new CLayout(); //starts a new program from the start
        }
      });

      // CONT PANEL ADJUSTMENTS

      infoRetreival.getPanelCont().add(startingPanel, "1"); //adds starting panel to main panel
      infoRetreival.getPanelCont().add(winnerPanel, "2"); //adds winner panel to main panel
      cl.show(infoRetreival.getPanelCont(), "1"); //shows first panel on game start

    }
  }

  public static void main(String[] args) {
    new CLayout(); //calls entire program to start
  }
}
