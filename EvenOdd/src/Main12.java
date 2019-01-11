import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

import java.awt.GridLayout;

import javax.swing.JTextArea;
import javax.swing.JFrame;

public class Main12
{
    public static void main(String[] args)
    {
        // Declare and instantiate the Gui12 variable

        Gui12 myGui = new Gui12("Lab 12 gui");
        
        // Make the gui visible
        myGui.showGui();

        // Wrap the method call with a try catch block since it may throw a
        // FileNotFoundException if the file we give it cannot be found
        try
        {
            myGui.displayEvenAndOddNumbers(args[0]);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace(); // catch FileNotFoundException and print stack trace
        }
        catch (Exception e)
        {
            e.printStackTrace(); // catch any other exception and print stack trace
        }
    }
}


// Create a custom gui class
class Gui12 extends JFrame
{
    // Instance variables
    private JTextArea leftTextArea;
    private JTextArea rightTextArea;
    private StringBuilder oddStringBuilder;
    private StringBuilder evenStringBuilder;

    // Default constructor
    public Gui12()
    {
        // Call the constructor below
        this("No title");
    }

    public Gui12(String title)
    {
        // Call the super class constructor to initialize the super
        // class variables before initializing this class's variables
        super(title);

        // Configure the JFrame
        // Configure the JFrame components we inherited
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(100, 100);
        this.setLocation(200, 200);
        this.setLayout(new GridLayout(1, 2)); // layout is 1 row to columns

        // Initialize the StringBuilder variables that will be used to 
        // build the strings that will contain the even or odd numbers
        this.oddStringBuilder = new StringBuilder("Odd numbers:\n"); 
        this.evenStringBuilder = new StringBuilder("Even numbers:\n");

        // Initialize the JTextArea variables with the current StringBuilder's
        // string representation, and its number of rows and columns
        this.leftTextArea = new JTextArea(this.oddStringBuilder.toString(), 5, 20);
        this.rightTextArea = new JTextArea(this.evenStringBuilder.toString(), 5, 20);

        // Add the JTextArea's to the content pane
        this.getContentPane().add(this.leftTextArea);
        this.getContentPane().add(this.rightTextArea); 
    }

    public void showGui()
    {
        this.pack();
        this.setVisible(true);
    }


    public void displayEvenAndOddNumbers(String file) throws FileNotFoundException
    {
        // use the Scanner class to easily read integers from a file
        Scanner reader = new Scanner(new File(file));
        
        while (reader.hasNextInt()) // while there is still numbers in the file
        {
            int num = reader.nextInt(); // get next number in the file
            if (num % 2 == 0)
            {
                this.evenStringBuilder.append(num + " "); // append even number to this StringBuilder
            }
            else
            {
                this.oddStringBuilder.append(num + " "); // append odd number to this StringBuilder
            }
        }

        // Set the text areas to the string representations of the StringBuilders
        this.leftTextArea.setText(this.evenStringBuilder.toString());
        this.rightTextArea.setText(this.oddStringBuilder.toString());

        // Close the reader when finished reading from the file
        reader.close();
    }
}