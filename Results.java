public class Results { //class to get winner results

  public int winner; 

  //setter uses randomized option from other file to find who wins
  public void setWinner(String p1, String p2) { 
    winner = this.getWinner(p1, p2);
  }

  public int returnWinner() { //returns winner
    return winner;
  }

  //gets winner from setter by comparing all posibilites and seeing who wins
  public int getWinner(String p1, String p2) { 
    if (p1.equals("R") && p2.equals("P"))return 2; //returns 2 if player 2 wins
    else if (p1.equals("R") && p2.equals("S"))return 1; //returns 1 if player 1 wins
    else if (p1.equals("P") && p2.equals("S"))return 2;
    else if (p1.equals("P") && p2.equals("R"))return 1;
    else if (p1.equals("S") && p2.equals("R"))return 2;
    else if (p1.equals("S") && p2.equals("P"))return 1;
    return 3; //returns 3 if a tie
  }
}
