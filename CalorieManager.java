import java.util.ArrayList;
import java.io.*;

/**
 * This Class takes all the foods that the user consumed and adds it to a list
 * 
 * @author Shion Wakita
 * @version CS 162 Final Project 5/29/16
 */
public class CalorieManager 
{

    private ArrayList<Food> list;
    private String signature;
    private int amount;
    private int calorie;
    private DemoGui gui;

  
    /**
     * Constructor of the Calorie Manager, This creates a new GUI objected and inputs the class itself in it
     */
    public CalorieManager()
    {
        list = new ArrayList<Food>();
        gui = new DemoGui(this);

    }

    /**
     * this method takes in the foods of the three category and puts it in a list
     */
    public void addFood(Food food)
    {
        list.add(food);
    }

    /**
     * This prints out all the information of the food in a BlueJ Terminal Window
     */
    public void printDetails()
    {
        for (Food food: list){
            System.out.println("Category: " + food.getCategory());
            System.out.println("Food Name: " + food.getName());
            System.out.println("Total Calories: " + food.getCalories());
            System.out.println("Quantity: "  + food.getQuantity());
            System.out.println();
        }
    }

    /**
     * This method is a output method that takes the lsit of foods in the list, and makes a textfile with all the information of the consumed food
     * @throws a IOException when there is a problem writing the file
     */
    public void saveData()
    {
        try{
            FileWriter writer = new FileWriter("foodlist.txt");
            for (Food food: list){
                writer.write("Category: " + food.getCategory());
                writer.write(" Food Name: " + food.getName());
                writer.write(" Total Calories: " + food.getCalories());
                writer.write(" Quantity: "  + food.getQuantity() + "   ||   ");
                writer.write('\n');
            }
            writer.close();
        }
        catch (IOException e) {
            System.err.println("There was a problem writing to file...");
        }
    }
    
    public static void main (String [] args)
    {
        CalorieManager manager = new CalorieManager();
    }

    
   
}
