
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test
{
    private int[] rows;
    private static final int MAX = 12;

    /**
     * Constructor for objects of class test
     */
    public test()
    {
        rows = new int[MAX];
    }

    public void add( int x, int y)
    {
        rows[x] = y;
    }
}
