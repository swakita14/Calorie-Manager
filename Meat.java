
import java.util.ArrayList;
/**
 * This class stores meats and adds it to a list 
 * 
 * @author Shion Wakita
 * @version CS 162 Final Project 5/29/16
 */
public class Meat extends Food
{
    
    private ArrayList<String> meatList;

    /**
     * Constructor for the Meat Class, uses a internal method to add Vegetables
     * @param String name: the name of the meat
     * @param int Quantity: the amount of the item
     * @param: the amount of calories of each serving of food
     */
    public Meat(String name, int quantity, int calories)
    {
       this.name = name;
       meatList = new ArrayList<String>();
       addFood(name, quantity, calories);
       category = "Meat";
    }
   
    /**
     * This method adds a new meat to the list
     * @param String name: the name of the meat
     * @param int Quantity: the amount of the item
     * @param: the amount of calories of each serving of food
     */
    public void addFood(String name, int quantity, int calories)
    {
       this. quantity=quantity;
       meatList.add(name);
       this.calories = calories*quantity;
    }
    
   
    
   
    
}
