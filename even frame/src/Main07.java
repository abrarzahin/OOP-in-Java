// Import libraries from the JDK so we can use them throughout the program
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main07 
{
    // Global static variable
    public static int[][] myArray;

    public static void main(String[] args) 
    {
        // Initialize the global static variable, 'myArray'
        myArray = fillArray(args[0]);
        
        // Use methods to print out formatted output
        printArray(myArray);
        System.out.println(); // To seperate output
        printArrayEven(myArray);
    }

    private static void printArray(int[][] theArray) 
    {
        for (int i = 0; i < theArray.length; i++) 
        {
            for (int j = 0; j < theArray[i].length; j++)
                System.out.printf("%d\t", theArray[i][j]); // '\t' is short for 'tab'

            System.out.println(); // Go to next line after printing row                            
        }
    }

    private static void printArrayEven(int[][] theArray) 
    {
        for (int i = 0; i < theArray.length; i++) 
        {
            for (int j = 0; j < theArray[i].length; j++) 
            {
                if (theArray[i][j] % 2 == 0) // Print out if the current element is even
                    System.out.printf("%d\t", theArray[i][j]);
                else
                    System.out.print("*\t");
            }
            System.out.println(); // Go to next line after printing row
        }
    }

    private static int[][] fillArray(String myFile) 
    {
        // Declare and initialize TextFileInput variable, tfi
        TextFileInput tfi = new TextFileInput(myFile);

        // The first line to the input is # of rows, the second
        // line of the input is # of columns.
        int row = Integer.parseInt(tfi.readLine());
        int col = Integer.parseInt(tfi.readLine());

        // Declare and initialize an array of integer arrays 
        int[][] result = new int[row][];

        // Initialize every element of 'result' as a new integer array. This part
        // is necessary!
        for (int i = 0; i < row; i++)
            result[i] = new int[col];

        // Begin filling array with the remaining input
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++) 
            {
                // Use try-catch block try prevent the programming
                // from halting if an exception is thrown by the
                // Integer.parseInt() method
                try 
                {
                    result[i][j] = Integer.parseInt(tfi.readLine());
                }
                catch (NumberFormatException e)
                {
                    e.printStackTrace();
                }
            }
        }

        // Return the resulting two-dimensional array after filling it
        return result;
    }

    // This method does the exact same thing as the method above 
    // (minus the error checking when reading from the file)
    private static int[][] fillArrayAlternate(String myFile) 
    {
        // Declare variables and initialize them to null
        FileReader fr = null;
        Scanner reader = null;
        try 
        {
            fr = new FileReader(myFile); // Can throw FileNotFoundException
            reader = new Scanner(fr);
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

        // Get the number of rows and columns from input
        int row = reader.nextInt();
        int col = reader.nextInt();

        // Declare and initialize an array of integer arrays
        int[][] result = new int[row][];

        // Initialize every element of 'result' as a new integer array. This part
        // is necessary!
        for (int i = 0; i < row; i++)
            result[i] = new int[col];

        // Begin filling array with the remaining input
        for (int i = 0; i < row; i++) 
        {
            for (int j = 0; j < col; j++) 
            {
                int num = reader.nextInt();
                result[i][j] = num;
            }
        }

        // Finally, return the result of filling in the array
        return result;
    }
}