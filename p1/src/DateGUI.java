import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;
public class DateGUI extends JFrame
{
     private Date212[] unsorted;
     private Date212[] sorted;
     JTextArea left_area, right_area;
     private static int Total = 0;
     private final int maxIndex = 100;  
     private StringBuilder leftsb,rightsb; 

     public void readFile(String file_name)
     {
          //A new file class
          File file = new File(file_name);
         //declear an array object .
          unsorted = new Date212[maxIndex];
          //To scan file
          Scanner reader = null;
          try
          {     //Scanner object and passed the file to its parameter
               reader= new Scanner(file);
               //Continue until theres a line in the file.
         while(reader.hasNextLine())
         {     //Strore from scanner to string 
                String current = reader.nextLine();
               //Used string tokeneizer to generate tokens.
                StringTokenizer sng = new StringTokenizer(current, ",");
               //Continue till there is a token.
         while(sng.hasMoreTokens())
          {
           //Store the next token
            String current_date = sng.nextToken();
           //New date 212 object to pass the next token.
             Date212 d = new Date212(current_date);                       
           // Check the validations of the date
             if(d.isValid(current_date))
            {
             // store to the unsorted array .
            unsorted[Total++] =  d;
                }
              // display invalid message
                  else
                {
                    System.out.println(d+ " the date is invalid.");
                     }
                  }
               }
          }
          //Catch block to show excaptions
          catch(FileNotFoundException e)
          {
               System.out.println("There is no Input");
          }
          //To close scanner.
          reader.close();
     }
     //Define the method addUnsorted().
     public void addUnsorted()
     {    
          String unsorted_part = "";
         //Traverse through the list
          for(int index = 0; index < Total; index++)
          {
               //add the dates stored in the array
               unsorted_part = unsorted_part + unsorted[index].toString();
               if(index != Total - 1)
               {
                     unsorted_part = unsorted_part + "\n";// use new line
               }
          } 
          //Adding unsorted_part into the left text area.
          left_area.setText(unsorted_part);
     }
   //Add sorted function to add sorted dates 
     public void addSorted()
     {
          String sorted_part = "";
          //Traverse through the list
          for(int index = 0; index < Total; index++)
          {   // Add the dates stored in the array.
               sorted_part = sorted_part +
               sorted[index].toString();
               if(index != Total - 1)
               {
                     sorted_part = sorted_part + "\n";// new line if dosent reach the end.
               }
          }
          //adding sorted part in the right text area.
          right_area.setText(sorted_part);
     }  // SelectionSort function to sort dates.
     public void SelectionSort()
     {
          sorted = new Date212[maxIndex];
          for(int i = 0; i < Total; i++)
          {
               sorted[i] = unsorted[i];
          }
          int minIndex = -1;
          //Traverse through the array
          for(int i = 0; i < Total - 1; i++)
          {    minIndex = i;
               for(int j = i + 1; j < Total; j++)
               {
               if(sorted[j].compareTo(sorted[minIndex]) < 0)
               {
                     minIndex = j;
                }
               }
               //Swap telement.
         Date212 temp = sorted[minIndex];
              sorted[minIndex] = sorted[i];
               sorted[i] = temp;
          }
     }
     // DateGUI Constractor.
     public DateGUI(String fileName)
     {
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setLayout(new GridLayout(1, 2, 10, 10));
         this.left_area = new JTextArea();// text areas
         this. right_area = new JTextArea();
         this. add(left_area);// adding them.
         this.add(right_area);       
         this.setSize(400, 300);// To set size 
         this.setLocation(200, 200);
         this.setTitle("Project 1");// To set title     
         this.setVisible(true);// To set visibility       
      // calling all the functions in the GUI 
          readFile(fileName);   
          addUnsorted();
          SelectionSort();
          addSorted();

     }

}