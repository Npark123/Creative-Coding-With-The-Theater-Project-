import org.code.theater.*;
import org.code.media.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TheaterRunner {
  public static void main(String[] args) {
    
  /*
 In superclass, have methods to get the instance variables (getProtein(), getIngredients() ) 
 In subclass, have methods to print the pictures based on what is in the instance variables (protein, and whatever's in the toppings: (getProteinImage(), getIngrediantImages() )
 
  Chipotle class handles user input and printing the actual images
  Creates objects within methods based on the user input
 
*/

    Chipotle nathan = new Chipotle("protein.txt", "toppings.txt");

    //Test
    ArrayList<String> top = new ArrayList<>();
    top.add("Guacamole");
    top.add("Brown Rice");
    Food temp = new Food("Chicken", top);
    System.out.println(temp.getPrice());

    
    nathan.drawScenes();



    
    Theater.playScenes(nathan);
  }
}


