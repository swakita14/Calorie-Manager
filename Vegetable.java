import java.util.ArrayList;
/**
 * This class stores vegetables and adds it to a list 
 * 
 * @author Shion Wakita
 * @version CS 162 Final Project 5/29/16
 */
public class Vegetable extends Food
{

    private ArrayList<String> vegetableList;

    /**
     * Constructor for the Vegetable Class, uses a internal method to add Vegetables
     * @param String name: the name of the vegetable
     * @param int Quantity: the amount of the item
     * @param: the amount of calories of each serving of food
     */
    public Vegetable(String name, int quantity, int calories)
    {
        category = "Vegetable";
        this.name = name;
        vegetableList = new ArrayList<String>();
        addFood(name, quantity, calories);

    }

    /**
     * This method adds a new vegetable to the list
     * @param String name: the name of the vegetable
     * @param int Quantity: the amount of the item
     * @param: the amount of calories of each serving of food
     */
    public void addFood(String name, int quantity, int calories)
    {
        this.quantity = quantity;
        vegetableList.add(name); 
        this.calories=calories*quantity;
    }

    
}
