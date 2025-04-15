import org.code.theater.*;
import org.code.media.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Food {
  private String protein;
  private ArrayList<String> toppings;

  private double price = 0.0;
  
  public Food(String protein, ArrayList<String> toppings){
    this.protein = protein;
    this.toppings = toppings;

    ArrayList<String> tempProteins = Chipotle.getProteinList();
    for(int i = 0; i < tempProteins.size(); i++){
      if(protein.toLowerCase().equals(tempProteins.get(i).toLowerCase())){
        setPrice(Chipotle.getProteinPrice().get(i));
      }
    }
    //System.out.println(temp);
  }

  public String getProtein(){
    return protein;
  }
  public ArrayList<String> getToppings(){
    return toppings;
  }

  public double getPrice(){
    return price;
  }
  public void setPrice(double p){
    price = p;
  }

  public double getPrice(boolean hasGuac){
    if(hasGuac == true){
      return getPrice() + 4.25;
    }
    return getPrice();
  }

  public String getImage(String protein){
    if(protein.toLowerCase().equals("chicken")){
      return "chicken.png";
    }else if(protein.toLowerCase().equals("steak")){
      return "steak.png";
    }else if(protein.toLowerCase().equals("carnitas")){
      return "carn.png";
    }else if(protein.toLowerCase().equals("barbacoa")){
      return "barbo.png";
    }else{
      return "sofr.png";
    }
  }
  public ArrayList<String> getImage(ArrayList<String> topps){
    ArrayList<String> tImages = FileReader.toStringList("toppingImageNames.txt");
    
    ArrayList<String> temp = new ArrayList<String>();
    ArrayList<String> compare = Chipotle.getToppingList();
    for(int i = 0; i < compare.size(); i++){
      for(int g = 0; g < topps.size(); g++){
        if(topps.get(g).toLowerCase().equals(compare.get(i))){
          temp.add(tImages.get(i));
        }
      }
    }
    
    return temp;
  }
  
}


