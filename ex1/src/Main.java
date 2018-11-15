class Main03
{
    public static void main(String[] args) 
    {
        // Declare variables
        float fahrenheit, centigrade;

        // Initialize variables
        fahrenheit = 98.6f;
        centigrade = convertToCentigrade(fahrenheit);

        // Print out results
        System.out.printf("Fahrenheit: %f\nCentigrade: %f\n", fahrenheit, centigrade);

        // Use a for loop to print out 0.0, 5.0., ..., 40.0 to centigrade
        for (float i = 0.0f; i <= 40.0f; i += 5.0f) 
        {
            System.out.printf("%f ", convertToCentigrade(i));
        }

        System.out.println(); // To seperate the above output with the below

        // Use a while loop to do the same as above
        float i = 0.0f;
        while (i <= 40.0f) 
        {
            System.out.printf("%f ", convertToCentigrade(i));
            i += 5.0f;
        }
    }

    public static float convertToCentigrade(float f) 
    {
        return (5.0f / 9.0f) * (f - 32.0f);
    }

    public static float convertToFahrenheit(float c) 
    {
        return (9.0f / 5.0f) + 32;
    }
}