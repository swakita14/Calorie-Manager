
/**
 * This is an abstract class that stores all the common information that all the food (Meat, Vegetable, Beverage) have in common
 * 
 * @author Shion Wakita
 * @version CS 162 Final Project 5/29/16
 */
public abstract class Food
{
    protected int quantity;
    protected int calories;
    protected String name;
    protected String category;

    /**
     * This is the abstract method that all the food class have in order to add a certain food to the list
     */
    public abstract void addFood(String name, int quantity, int calories);

    /**
     * Gets the name of the food
     * @return Returns the name of the food
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the calorie of the food
     * @return Returns the calorie of the item
     */
    public int getCalories()
    {
        return calories;
    }

    /**
     * Gets the quantity of the food
     * @return Returns the quantity of the item
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Gets the category of the food
     * @return Returns the category of the item
     */
    public String getCategory()
    {
        return category;
    }

}
