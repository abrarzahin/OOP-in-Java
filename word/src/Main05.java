// Import libraries from the JDK so we can use them throughout the program
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;

public class Main05 
{
    public static void main(String[] args) 
    {
        // Declare our variables
        String[] wordArray;
        String isOrIsNot, inputWord;
        TextFileInput input;
        
        // Retrieve the input text file from the parameter passed in when executing this program
        // when running: java -cp bin Main05 lab05_input.txt
        // Note: lab05_input.txt corresponds to args[0]!
        input = new TextFileInput(args[0]);

        // Use the static method from below to initialize our wordArray variable
        wordArray = inputFromFile(input);

        // This line asks the user for input by popping out a single window
        // with text input
        inputWord = JOptionPane.showInputDialog(null, "Enter a word in all lower case:");

        // if the inputWord is contained within wordArray return true
        if (wordIsThere(inputWord, wordArray))
            isOrIsNot = "is"; // set to is if the word is on the list
        else
            isOrIsNot = "is not"; // set to is not if the word is not on the list

        // Output to a JOptionPane window whether the word is on the list or not
        JOptionPane.showMessageDialog(null, "The word " + inputWord + " " + isOrIsNot + " on the list.");
    }

    public static boolean wordIsThere(String findMe, String[] theList) 
    {
        for (int i = 0; i < theList.length; i++) 
        {
            if (findMe.equals(theList[i]))
                return true;
        }
        return false;
    }

    public static String[] inputFromFile(TextFileInput input) 
    {
        // Here, we use an ArrayList since it's a dynamic structure that 
        // we can keep adding elements to without worrying about it getting 
        // full. This helps us avoid worrying about how many lines is contained
        // in the input file.
        ArrayList<String> helper = new ArrayList<String>();
        String line = input.readLine();

        while (line != null)
        {
            helper.add(line);
            line = input.readLine(); // read next line
        }

        // Create the String array with the proper size
        String[] result = new String[helper.size()];

        // Convert ArrayList to String array
        result = helper.toArray(result);

        // Finally, return the converted String array
        return result;
    }

    // Sort an integer array from least to greatest
    public static void selectionSort(int[] input)
    {
        for (int i = 0; i < input.length; i++)
        {
            int smallestIndex = i;
            for (int j = i + 1; j < input.length; j++)
            {
                if (input[j] < input[smallestIndex])
                {
                        smallestIndex = j;
                }
            }
            swap(input, i, smallestIndex);
        }
    }

    // Swap elements in an integer array
    public static void swap(int[] input, int i, int j)
    {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}