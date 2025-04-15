import org.code.theater.*;
import org.code.media.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Chipotle extends Scene{
  private static ArrayList<String> proteinList = new ArrayList<String>();
  private static ArrayList<Integer> proteinCals = new ArrayList<Integer>();
  private static ArrayList<Double> proteinPrice = new ArrayList<Double>();
  
  private static ArrayList<String> toppingList = new ArrayList<String>();
  private static ArrayList<Integer> toppingCals = new ArrayList<Integer>();
  
  
  public Chipotle(String proteinList, String toppingList){
    ArrayList<String> proteins = FileReader.toStringList(proteinList);
    ArrayList<String> toppings = FileReader.toStringList(toppingList);
    
    for(int i = 0; i < proteins.size(); i++){
      this.proteinList.add(proteins.get(i).substring(0, proteins.get(i).indexOf("-")));
      proteinCals.add(Integer.parseInt(proteins.get(i).substring(proteins.get(i).indexOf("-") + 1, proteins.get(i).indexOf("/"))));
      proteinPrice.add(Double.parseDouble(proteins.get(i).substring(proteins.get(i).indexOf("/") + 1)));
    }
    
    for(int i = 0; i < toppings.size(); i++){
      this.toppingList.add(toppings.get(i).substring(0, toppings.get(i).indexOf("-")));
      toppingCals.add(Integer.parseInt(toppings.get(i).substring(toppings.get(i).indexOf("-") + 1)));
    }
  }
  
  //Accessor methods
  public static ArrayList<String> getProteinList(){
      return proteinList;
    }
  public static ArrayList<Integer> getProteinCals(){
      return proteinCals;
    }
  public static ArrayList<Double> getProteinPrice(){
      return proteinPrice;
    }
  public static ArrayList<String> getToppingList(){
      return toppingList;
    }
  public static ArrayList<Integer> getToppingCals(){
      return toppingCals;
    }

  public ArrayList<String> getWordsFromSentence(String sentence){
    ArrayList<String> words = new ArrayList<String>();
    int s = sentence.indexOf(" ");
    while(s != -1){
      String curWrd = sentence.substring(0, s);
      words.add(curWrd); 
      sentence = sentence.substring(s + 1);
      s = sentence.indexOf(" ");
    }
    words.add(sentence.substring(0, sentence.length()));
    return words;
  }
  
  //Scenes
  public void drawScenes(){
    orderScene();

    
  }
  
  public void orderScene(){
    drawBackground();
    pause(1);
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to Chipotle, \nWould you like a bowl or a burrito?");
    String ans = input.nextLine();

    String item = "";
    if(ans.toLowerCase().equals("bowl")){
      item = "bowl";
    }else if(ans.toLowerCase().equals("burrito")){
      item = "burrito";
    }
      System.out.println("Pick a protein:\n-Chicken\n-Steak\n-Carnitas\n-Barbacoa\n-Sofritas");
      String protein = input.nextLine().toLowerCase();
      String[] symbols = {",", ".", "/", "!", "?"};
      for (String s : symbols) {
      protein = protein.replace(s, "");
    }

    System.out.println("Pick your toppings:\n-Rice\n-Guacamole\n-Cream\n-Lettuce\n-Pico\n-Salsa\n-Fajitas\n-Chips\n-Cheese\n-Beans\n-Corn");
    String line = input.nextLine().toLowerCase();
    
    for (String s : symbols) {
      line = line.replace(s, "");
    }
    
    ArrayList<String> tempTopp = getWordsFromSentence(line);
    System.out.println(tempTopp);

    if(item.equals("bowl")){
      Bowl nathan = new Bowl(protein, tempTopp);
      
    }else if(item.equals("burrito")){
      Burrito nathan = new Burrito(protein, tempTopp);
      
    }
  }

  
  
  public void drawBackground(){
    clear("white");
    drawImage("counterPic.png", 0, 0, 400);
  }
  




}


