// Import the library containing the JOptionPane class
import javax.swing.*;

public class Main04 
{
    public static void main(String[] args) 
    {
        // Hard-code the array
        String[] wordArray = { "hello", "goodbye", "cat", "dog", "red", "green", "sun", "moon" };
        String isOrIsNot = null, inputWord = null;

        // if the inputWord is contained within wordArray return true
        while (true)
        {
            // This line asks the user for input by popping out a single window
            // with text input
            inputWord = JOptionPane.showInputDialog(null, "Enter a word in all lower case:");

            if (inputWord.equals("STOP"))
                System.exit(0);
            else if (wordIsThere(inputWord, wordArray)) 
                isOrIsNot = "is"; // set to is if the word is on the list
            else
                isOrIsNot = "is not"; // set to is not if the word is not on the list

            // Output to a JOptionPane window whether the word is on the list or not
            JOptionPane.showMessageDialog(null, "The word " + inputWord + " " + isOrIsNot + " on the list.");
        }
    }

    public static boolean wordIsThere(String findMe, String[] theList) 
    {
        // Iterate through 'theList' and return true if the 
        // target word matches the current word in 'theList'
        for (int i = 0; i < theList.length; i++)
            if (findMe.equals(theList[i]))
                return true;
        
        // If we never returned true in the for-loop above, then
        // we return false
        return false;
    } 
}