// *************
// Rock.java 
// ************* 

import java.util.Scanner; 
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BarowoProject3 
{

  static char playGameQuestion() {
    System.out.println("Would you like to play Rock, Paper, Scissors game?");
    Scanner user_input = new Scanner(System.in);
    String yesorno = user_input.nextLine();
    Pattern yes_pattern = Pattern.compile("^[Yy].*$");
    Matcher yes_match = yes_pattern.matcher(yesorno);
    if (yes_match.find()) {
      return 'Y';
    } else {
      return 'N';
    }
  }

  static char getPlayerMove() {
    System.out.println("\nThen, let's play the game!");
    System.out.println("Please enter a move.");
    Scanner user_input = new Scanner(System.in);
    String rps = user_input.nextLine();
    Pattern rps_pattern = Pattern.compile("^[RrPpSs].*$");
    Matcher rps_match = rps_pattern.matcher(rps);
    if (rps_match.find()) {
      return rps.toUpperCase().charAt(0);
    } else {
      return ' ';
    }
  }

  static char getComputerMove() {
    char[] choice = {'R', 'P', 'S'};
    Random generator = new Random(); 
    return choice[generator.nextInt(2)];  
  }



public static void main(String[] args) 
{ 
  char personPlay; 
  char computerPlay;; 
  int computerInt; 

  if (playGameQuestion() == 'Y') {
    System.out.println("Yes, you want to play");
  } else {
    System.out.println("No, you don't");
  }

  personPlay = getPlayerMove();
  System.out.println("Player");
    switch (personPlay) {
      case 'R':
      System.out.println("Rock!");
      break;
      case 'P':
      System.out.println("Paper!");
      break;
      case 'S':
      System.out.println("Scissors!");
      break; 
      default:
      System.out.println("Huh? Not Valid!");
    }

  computerPlay = getComputerMove();
  System.out.println("Computer");
    switch (computerPlay) {
      case 'R':
      System.out.println("Rock!");
      break;
      case 'P':
      System.out.println("Paper!");
      break;
      case 'S':
      System.out.println("Scissors!");
      break; 
      default:
      System.out.println("Huh? Not Valid!");
    }

 
    if (personPlay == computerPlay) {
       System.out.println("It's a tie!"); 
    } else if (personPlay == 'R') {
       if (computerPlay == 'S') {
          System.out.println("Rock crushes scissors. You win!!");
       } else if (computerPlay == 'P') {
          System.out.println("Paper eats rock. You lose!!"); 
       }
    } else if (personPlay == 'P') {
       if (computerPlay == 'S') {
         System.out.println("Scissor cuts paper. You lose!!");
       } else if (computerPlay == 'R') {
            System.out.println("Paper eats rock. You win!!");
       }
    } else if (personPlay == 'S') {
        if (computerPlay == 'P') {
         System.out.println("Scissor cuts paper. You win!!"); 
        } else if (computerPlay == 'R') {
            System.out.println("Rock breaks scissors. You lose!!");
        }
    } else {
         System.out.println("Invalid user input."); 
    }
  }
}