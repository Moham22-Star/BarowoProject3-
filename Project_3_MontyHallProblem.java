/*This code simulates the Monty Hall Problem
which is based on the Let's Make a Deal gameshow.
More information about this problem can be found here https://en.wikipedia.org/wiki/Monty_Hall_problem
*/

import java.util.*;
import java.text.*;

public class Project_3_MontyHallProblem
{
  //Define Variables
  static int totalGames = 0;
  static int gamesWonDoorChanged = 0;
  static int gamesWonDoorNotChanged = 0;
  static int gamesLost = 0;
  static Scanner user_input= new Scanner(System.in);
  static Random randNum = new Random();

  //Method summarizes wins and losses
  public static void summary()
  {
    int totalWins = gamesWonDoorChanged + gamesWonDoorNotChanged;
    int totalLosses=totalGames-totalWins;

    System.out.println("Total Games: "+totalGames);
    System.out.println("Total Wins: "+totalWins);
    System.out.println("Total Losses: "+totalLosses);

    double doubleWinsDoorChanged=(double)gamesWonDoorChanged/(double) totalGames;
    System.out.println("Percent of wins when door is changed "+doubleWinsDoorChanged);
    
    double doubleWinsDoorNotChanged=(double)gamesWonDoorNotChanged/(double) totalGames;
    System.out.println("Percent of wins when door is not changed "+doubleWinsDoorNotChanged+"\n");
    userMenu();
  }

  //Method updates wins and losses
  public static void updateTotal(int score)
  {
    if(score==1)
    {
      gamesWonDoorNotChanged++;
      totalGames++;
    }
    else if(score==2)
    {
      gamesWonDoorChanged++;
      totalGames++;
    }
    else
    {
      gamesLost++;
      totalGames++;
    }
  }

  //Method used to obtain initial door choice
  public static int userDoorSelection()
  {
    System.out.println("There is a prize behind one of these doors");
    System.out.println("Choose Door 0, 1, or 2!");
    String strSelectedDoor=user_input.nextLine();

    //Ensure string is not null or a non-number
    if(strSelectedDoor.matches("^[0-2]{1}$"))
    {
      //Do nothing
    }
    else
    {
      System.out.println("Invalid selection.");
      userMenu();
    }

    int selectedDoor = Integer.parseInt(strSelectedDoor);
    
    if ((selectedDoor<0)||(selectedDoor>2))
    {
      System.out.println("Please select a value of 0, 1, or 2");
      letsMakeaDeal();
    }
    return selectedDoor;
  }

  //Method used to give user option to change door
  public static int changeDoorOption()
  {
    System.out.println("Would you like to change initial door choice?");

    System.out.println("Choose 1 for YES and 2 for NO.");
    String strChangeDoor=user_input.nextLine();

    if(strChangeDoor.matches("^[1-2]{1}$"))
    {
      //Do nothing
    }
    else
    {
      System.out.println("Invalid selection.");
      userMenu();
    }

    int changeDoor = Integer.parseInt(strChangeDoor);

    if ((changeDoor<0)||(changeDoor>2))
    {
      System.out.println("Please select a value of 1 or 2");
      letsMakeaDeal();
    }

    return changeDoor;
  }  

  //Method simulates Lets Make a Deal Game
  public static void letsMakeaDeal()
  {
    System.out.println("Welcome to Lets Make a Deal!\n");
    int winningDoor = randNum.nextInt(3);

    int intSelectedDoor=userDoorSelection();

    int notDoor = randNum.nextInt(3);

    while((notDoor==winningDoor)||(notDoor==intSelectedDoor))
    {
      notDoor = randNum.nextInt(3);
    }
    System.out.println("The prize is not behind door "+notDoor);

    int intChangeDoor=changeDoorOption();
    
    if((intSelectedDoor==winningDoor) && (intChangeDoor==2))
    {
      System.out.println("YOU WON THE PRIZE\n");
      updateTotal(1);
      userMenu();
    }
    else if ((intSelectedDoor!=winningDoor) && (intChangeDoor==1))
    {
      System.out.println("YOU WON THE PRIZE\n");
      updateTotal(2);
      userMenu();
    }
    else
    {
      System.out.println("YOU LOST. BETTTER LUCK NEXT TIME\n");
      updateTotal(0);
      userMenu();
    }

  }
  //Method used to provide user options
  public static void userMenu()
  {
    System.out.println("Select '1' to Exit");
    System.out.println("Select '2' to Summarize Wins and Losses");
    System.out.println("Select '3' to play Lets Make a Deal");
    String strSelection=user_input.nextLine();
        //Ensure string is not null or a non-number
    if(strSelection.matches("^[1-3]{1}$"))
    {
      //Do nothing
    }
    else
    {
      System.out.println("Invalid selection.");
      userMenu();
    }

    int intSelection = Integer.parseInt(strSelection);

    if(intSelection==1)
    {
      System.exit(0);
    }
    else if (intSelection==2)
    {
      summary();
    }
    else if (intSelection==3)
    {
      letsMakeaDeal();
      userMenu();
    }
    else
    {
      System.out.println("Please make a valid selection");
      userMenu();
    }
  }

  //Main Method simply starts the program
  public static void main(String[] args)
  { 
    userMenu();
  }
}
