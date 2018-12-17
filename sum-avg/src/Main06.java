
// Import libraries from the JDK so we can use them throughout the program
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;

public class Main06
{
    public static void main(String[] args)
    {
        // Declare our variables
        int[] inputArray;
        int sum, average;
        TextFileInput input;

        // Initialize our variables
        input = new TextFileInput(args[0]);
        inputArray = inputFromFile(input);

        
        System.out.printf("Before sorting: %s \n", Arrays.toString(inputArray));
        selectionSort(inputArray);
        System.out.printf("Before sorting: %s \n", Arrays.toString(inputArray));

        sum = sum(inputArray);
        average = average(inputArray);

        System.out.printf("Sum: %d \nAverage: %d \n", sum, average);
    }

    public static int[] inputFromFile(TextFileInput input)
    {
        // Here, we use an ArrayList since it's a dynamic structure that
        // we can keep adding elements to without worrying about it getting
        // full. This helps us avoid worrying about how many lines is contained
        // in the input file.
        ArrayList<Integer> helper = new ArrayList<Integer>();
        String line = input.readLine();

        while (line != null) 
        {
            int num = Integer.parseInt(line);
            helper.add(num);
            line = input.readLine(); // read next line
        }

        // Create an integer array from the 'helper' ArrayList
        int[] result = new int[helper.size()];
        for (int i = 0; i < helper.size(); i++)
            result[i] = helper.get(i);

        // Finally, return the converted integer array
        return result;
    }

    public static int sum(int[] input) 
    {
        int sum = 0;
        for (int i = 0; i < input.length; i++)
            sum += input[i];
        return sum;
    }

    public static int average(int[] input) 
    {
        return sum(input) / input.length;
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