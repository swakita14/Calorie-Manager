import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.colorchooser.*;

import java.io.*;
/**
 * This is the actual GUI class that implements the calorie tracker program and makes it a GUI
 * 
 * @author Shion Wakita
 * @version CS 162 Final Project 5/29/16
 */
public class DemoGui
{
    private JFrame frame;
    private Container pane;
    private JTextField text1;
    private JTextField t1;
    private JTextField text2;
    private JTextField text3;
    private CalorieManager manager;
    private int goal;
    private ImageIcon image;
    private JLabel imagelabel;

    /**
     * The constructor of the GUI that takes in the calorie manager program and makes it into a GUI
     * @param a CalorieManager class, and makes it in a GUI
     * @throws a NullStringException when the value of the daily calorie goal is less than or equal to 0
     */
    public DemoGui(CalorieManager manager)
    {
        this.manager = manager;
        try {

            goal = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Your Daily Calorie Goal:"));
            if (goal <= 0){
                throw new NullStringException("Please enter a value that is greater than 0");

            }
            else {
                makeFrame();
            }

        }
        catch (NullStringException e){
            JOptionPane.showMessageDialog(pane, "Please enter a value that is greater than 0");
        }

    }

    /**
     * This method makes the Frame for the GUI
     */
    public void makeFrame()
    {
        frame = new JFrame("Calorie Tracker");
        makeMenuBar(frame);

        frame.setResizable(false);

        pane = frame.getContentPane();

        pane.setLayout(new BorderLayout());
        JButton b1 = new JButton("Add to list");
        b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { addFood(); }
            });
        JButton b2 = new JButton("Calories Left to Intake");
        b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { getDailyGoal(); }
            });

        JButton b3 = new JButton("Print food");
        b3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {outputFoodList(); }
            });

        JPanel p5 = new JPanel(new BorderLayout());
        JPanel p6 = new JPanel();

        JLabel category = new JLabel("Food Category:");
        category.setForeground(Color.blue);
        t1 = new JTextField(7);
        JLabel category2 = new JLabel("(Vegetable,Meat,Beverage)");

        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new BorderLayout());
        JPanel p4 = new JPanel(new FlowLayout());

        JPanel p3 = new JPanel(new FlowLayout());
        JLabel label1 = new JLabel("Food Name:", JLabel.CENTER);
        label1.setForeground(Color.red);
        text1 = new JTextField(5);
        p3.add(label1);
        p3.add(text1);

        JLabel label2 = new JLabel("Amount:",JLabel.CENTER);
        label2.setForeground(Color.red);
        text2 = new JTextField(5);
        p3.add(label2);
        p3.add(text2);

        JLabel label3 = new JLabel("Calories:",JLabel.CENTER);
        label3.setForeground(Color.red);
        text3 = new JTextField(5);
        p3.add(label3);
        p3.add(text3);

        image = new ImageIcon(getClass().getResource("Images/healthy.jpg"));
        imagelabel = new JLabel(image);

        p2.add(p3,BorderLayout.NORTH);


        p1.add(category);
        p1.add(t1);
        p1.add(category2);

        p3.add(p1);

        p3.add(label1);
        p3.add(text1);

        p3.add(label2);
        p3.add(text2);

        p3.add(label3);
        p3.add(text3);

        p4.add(b1);
        p4.add(b2);
        p4.add(b3);

        pane.add(imagelabel, BorderLayout.NORTH);
        pane.add(p3, BorderLayout.CENTER);
        pane.add(p2, BorderLayout.WEST);
        pane.add(p4, BorderLayout.SOUTH);

        frame.setSize(800,800);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This method is an external method that creates a textfile for the all food that has been added to the list
     */
    public void outputFoodList()
    {
        manager.saveData();
    }

    /**
     * This method shows a guide of how to correctly use the program
     */
    public void help()
    {
        JOptionPane.showMessageDialog(pane, "'Add to list' button tracks all the foods you consumed throughout the day. \n'Calories left to intake' tracks all the food and subtracts the calories from each food from you daily goal. \n'Print food' creates a textfile of all the foods added.");

    }

    /**
     * This method takes all the imputs in the textfields and puts it in the calorie manager program
     * @throws a NullStringException when the category chosen is not in the list of categories to choose from
     * @throws a IllegalArgumentException when there are blanks in the textfields
     */
    public void addFood()

    {

        try{
            String foodName = text1.getText();
            int amount = Integer.parseInt(text2.getText());
            int calories = Integer.parseInt(text3.getText());
            goal = goal - amount*calories;

            JOptionPane.showMessageDialog(pane, "Food successfully added!");
            if (goal == 0){
                JOptionPane.showMessageDialog(pane, "Congradulations! You have reached your daily goal. Keep it up!");
            }
            if (goal < 0){
                JOptionPane.showMessageDialog(pane, "You have passed your daily caloric intake");
                System.exit(0);
            }
            if (t1.getText().equals("Vegetable")){

                manager.addFood(new Vegetable(foodName,amount,calories));

            }
            else if (t1.getText().equals("Meat")){

                manager.addFood(new Meat(foodName,amount,calories));

            }
            else if (t1.getText().equals("Beverage")){
                manager.addFood(new Beverage(foodName,amount,calories));

            }

            else if (t1.getText().equals(null) || text2.getText().equals(null) || text3.getText().equals(null)){
                throw new IllegalArgumentException("Please fill in all the text fields");
            }

            else {
                throw new NullStringException( "Please choose from the 3 categories of food");
            }
        }
        catch (NullStringException e) {
            JOptionPane.showMessageDialog(pane, "Please choose from the 3 categories of food");
        }
        catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(pane, "Please fill in all the text fields");
        }
        finally{
            t1.setText("");
            text1.setText("");
            text2.setText("");
            text3.setText("");

        }
    }

    /**
     * This makes the actual frame of the Gui
     * 
     */
    public void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu menu;
        JMenuItem item; 

        menu = new JMenu("File");
        menubar.add(menu);

        item = new JMenuItem("Quit");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { quit(); }
            });
        menu.add(item);

        menu = new JMenu("About");    
        menubar.add(menu);

        item = new JMenuItem("About");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { about(); }
            });
        menu.add(item);  

        item = new JMenuItem("Help");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { help(); }
            });
        menu.add(item);

    }  

    /**
     * This method closes the program 
     */
    public void quit()
    {
        System.exit(0);
    }

    /**
     * This shows the daily goal that was set by the user
     */
    public void getDailyGoal()
    {

        JOptionPane.showMessageDialog(pane, "You have: " + goal + " kcal left, You got this!");

    }

    /**
     * This shows the creater and the contact information of the GUI
     */
    public void about()
    {
        JOptionPane.showMessageDialog(frame, "Created by: Shion Wakita \n Contact: swakita14@wou.edu");
    }
}
