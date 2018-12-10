import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class Date212GUI extends JFrame {
  // declear text area
JTextArea left_area, right_area;
// constractor to initialize 
public Date212GUI(String fileName)
{
super("Date212List");

         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setLayout(new GridLayout(1, 2, 10, 10));
         this.left_area = new JTextArea();// text areas
         this.right_area = new JTextArea();
         this.add(left_area);// adding them.
         this.add(right_area);       
         this.setSize(400, 300);// To set size 
         this.setLocation(200, 200);
         this.setTitle("Project 2");// To set title     

              // new   file menu objects created here
        JMenuItem open = new JMenuItem("Open");
        JMenuItem quit = new JMenuItem("Quit");
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        FileMenuHandler fmh = new FileMenuHandler(this);
        
        // the action listener has been added to the menu bar 
        open.addActionListener(fmh);
        quit.addActionListener(fmh);
        
        // Add the menu items to the file menu
        fileMenu.add(open);
        fileMenu.addSeparator();
        fileMenu.add(quit);

        // Add file menu to the menu bar, and set this gui's
        // menu bar to the menuBar we created above
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);

         this.setVisible(true);// To set visibility       
      // calling all the functions in the GUI 
}
 public void readFile(File file)
 {       //A new file class
   Scanner reader=null;
    try {
        //Scanner object and passed the file to its parameter
        reader = new Scanner(file);
        String current;
        // two new objects of unsorted and sorted class type.
        SortedDate212List StList = new SortedDate212List();
        UnsortedDate212List UtList = new UnsortedDate212List();
        //Continue until theres a line in the file.
        while(reader.hasNextLine())
        {//Strore from scanner to string 
         current = reader.nextLine();
         if(current.trim().equals("")) continue; //skip over empty lines
         String[] datelist = current.split(",");
         //Traverse through date array list
         for(int i = 0; i < datelist.length; i++)
        {
        try
         {// new date212 object 
         Date212 dt = new Date212(datelist[i]);
        //add the date to both list
         StList.add(dt);
         UtList.add(dt);
        }
          //Catch block to show excaptions
         catch(Exception e)
           {
        System.out.println("the date is invalid : " + datelist[i]);
                }
             }
        }
        // To scanner close
    reader.close();
    //adding sorted part in the right text area.
     right_area.setText("Sorted Dates  \n" + StList.toString());
     //Adding unsorted_part into the left text area
     left_area.setText("Unsorted Dates  \n" + UtList.toString());
   } catch (FileNotFoundException e) {
                 System.out.println("There is no Input");
       }
     }
   }
