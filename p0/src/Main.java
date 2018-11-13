 import javax.swing.*;

 public class Main 
 {
     public static void main(String[] args) 
	 
		{
			String input;
			int upper=0;
			int lower=0;
			while(true){
				
			// This line asks the user for input by popping out a single window
			// with text input
				
			input = JOptionPane.showInputDialog(null, "Please enter a sentence");
				if (input.equalsIgnoreCase("STOP"))
					System.exit(0);
				break;
		}
			
			// this for loop will iterate through the entire string
			for(int i=0;i<input.length();i++)
				{
					input.charAt(i);
					// this if condition will count the number of upper case E's
					if(input.charAt(i)=='E')
						upper ++;
					
					// this if condition will count the number of lower case e's
					if(input.charAt(i)=='e')
						lower ++;
					
					
				}
			// Output to a JOptionPane window how many lower case e and how many upper case E were there 
         JOptionPane.showMessageDialog(null, "Number of lower case e's:" + lower +"\n Number of upper case E's:"+ upper );
     }
	 
 }
