// *************
// Rock.java 
// ************* 

import java.util.Scanner; 
import java.util.Random; 


public class BarowoProject3 
{ 
public static void main(String[] args) 
{ 
  Scanner user_input = new Scanner(System.in);
  
  System.out.println("Would you like to play Rock, Paper, Scissors game?");
  System.out.println("\nyes = 1 \nNo = 2 \n");
  String yesorno = user_input.nextLine();
    
    //System.out.println(yesorno);

    String personPlay; 
    String computerPlay = ""; 
    int computerInt; 
    
    String response; 


    Scanner scan = new Scanner(System.in); 
    Random generator = new Random(); 

    System.out.println("\nThen, let's play the game!\n" + "Please enter a move.\n" + "Rock = R, Paper" +  "= P, and Scissors = S.");

    System.out.println();

    
    computerInt = generator.nextInt(3)+1; 



    if (computerInt == 1) 
        computerPlay = "R"; 
    else if (computerInt == 2) 
       computerPlay = "P"; 
    else if (computerInt == 3) 
       computerPlay = "S"; 



    System.out.println("Enter your play: "); 
    personPlay = scan.next();

 
    personPlay = personPlay.toUpperCase(); 

    System.out.println("Computer play is: " + computerPlay); 



    if (personPlay.equals(computerPlay)) 
       System.out.println("It's a tie!"); 
    else if (personPlay.equals("R")) 
       if (computerPlay.equals("S")) 
          System.out.println("Rock crushes scissors. You win!!");
    else if (computerPlay.equals("P")) 
            System.out.println("Paper eats rock. You lose!!"); 
    else if (personPlay.equals("P")) 
       if (computerPlay.equals("S")) 
       System.out.println("Scissor cuts paper. You lose!!"); 
    else if (computerPlay.equals("R")) 
            System.out.println("Paper eats rock. You win!!"); 
    else if (personPlay.equals("S")) 
         if (computerPlay.equals("P")) 
         System.out.println("Scissor cuts paper. You win!!"); 
    else if (computerPlay.equals("R")) 
            System.out.println("Rock breaks scissors. You lose!!"); 
    else 
         System.out.println("Invalid user input."); 
}
}