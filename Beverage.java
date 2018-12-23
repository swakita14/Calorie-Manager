import java.util.ArrayList;
/**
 * This class stores beverage and adds it to a list 
 * 
 * @author Shion Wakita
 * @version CS 162 Final Project 5/29/16
 */
public class Beverage extends Food
{
    
    private ArrayList<String> beverageList;
    /**
     * Constructor for the Beverage Class, uses a internal method to add Beverages
     * @param String name: the name of the beverage
     * @param int Quantity: the amount of the item
     * @param: the amount of calories of each serving of food
     */
    public Beverage(String name, int quantity, int calories)
    {
       this.name = name;
       category = "Beverage";
       beverageList = new ArrayList<String>();
       addFood(name, quantity, calories);
       
    }

     /**
     * This method adds a new meat to the list
     * @param String name: the name of the meat
     * @param int Quantity: the amount of the item
     * @param: the amount of calories of each serving of food
     */
    public void addFood(String name, int quantity, int calories)
    {
        this.quantity = quantity;
        beverageList.add(name); 
        this.calories = calories*quantity;
    }
    
   
   
    
}
