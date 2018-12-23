
/**
 * This is a check Exception that throws a error message when the category chosen for the foods is not in the list
 * 
 * @author Shion Wakita
 * @version CS 162 Final Project 5/29/16
 */
public class NullStringException extends Exception
{
    private String category;

    /**
     * Constructor for objects of class NullStringException
     * @param String category: takes in the category of the foods
     */
    public NullStringException(String category)
    {
        this.category = category;
    }

    /**
     * Returns the category of the food
     * @return The category of the food
     */
    public String getCategory()
    {
        return category;
    }

    /**
     * Overrrides a toString method that shows an error when the category selected is not in the list
     * @return the message that is returned when the selected category of food is not in the list
     */
    public String toString()
    {
        return "The input" + category + " is not in the list of choices. ";
    }

}
