public class Main08 
{
    // Global static variable
    public static int[][] myArray;

    public static void main(String[] args) 
    {
        // Initialize the global static variable, 'myArray'
        myArray = fillArray(args[0]);

        // Use methods to print out formatted output
        printArray(myArray);
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

    private static int[][] fillArray(String myFile) 
    {
        // Declare and initialize our text file input object
        TextFileInput input = new TextFileInput(myFile);

        // The first line of the input contains the row and col
        String line = input.readLine();
        String delimiter = ",";

        // Tokenize the first line from input
        StringTokenizer tokenizer = new StringTokenizer(line, delimiter);
        
        // Read in the number of rows and columns from the first line
        int rows = Integer.parseInt(tokenizer.nextToken());
        int cols = Integer.parseInt(tokenizer.nextToken());

        // Declare and initialize our array of integer array references 
        int[][] result = new int[rows][];

        // Manually initialize every element inside result to store a reference
        // to a new integer array
        for (int i = 0; i < rows; i++)
            result[i] = new int[cols];

        /* Note: You can also use the much shorter hand way of declaring and 
         * intialize a 2D array by the following:
         * int[][] result = new int[rows][cols];
         * They both do the same thing logically and physically
         */

        // Begin filling in the resulting array from the remainder of the input file
        for (int i = 0; i < rows; i++)
        {
            line = input.readLine(); // read the next line
            tokenizer = new StringTokenizer(line, delimiter);
            for (int j = 0; j < cols; j++)  
            {
                // Read a token from the current line
                String token = tokenizer.nextToken();
                
                // Wrap the potentially problematic code with a try-catch block
                try 
                {
                    int num = Integer.parseInt(token); // convert token to an integer
                    result[i][j] = num;
                } 
                catch (NumberFormatException e)
                {
                    e.printStackTrace(); // prints the function call leading up to the exception
                }
            }
        }

        // Finally, return the resulting 2D array after filling it
        return result;
    }

    
}