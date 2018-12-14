 import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.*;

public class Date212GUI extends JFrame {
	// initializing tree map 
	TreeMap tm = new TreeMap <String,Date212>();
	UnsortedDate212List udl;
	// constractor to initialize 
	public Date212GUI(){
		this.setSize(400,300); // setting size
		this.setLocation(200,200); // setting location
		this.setTitle("Project 4"); // setting title

		 // new   file menu objects created here
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenuItem Open = new JMenuItem("Open");
		JMenuItem Quit = new JMenuItem("Quit");
		JMenuItem insert = new JMenuItem("insert");
		FileMenuHandler fmh = new FileMenuHandler(this);
		EditMenuHandler inst = new EditMenuHandler(this);

		// the action listener has been added to the menu bar 
		Open.addActionListener(fmh);
		Quit.addActionListener(fmh);
		insert.addActionListener(inst);
		 // Add the menu items to the file menu
		file.add(Open);
		file.add(Quit);
		edit.add(insert);
		// Add file menu to the menu bar, and set this gui's
        // menu bar to the menuBar we created above
		menuBar.add(file);
		menuBar.add(edit);
		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); // To set visibility  

	}
	
	public void readFile(File file)
 			{       //A new file class
  
				//Scanner object and passed the file to its parameter
				Scanner in=null;
				try{
					in = new Scanner(new FileReader(file));
					}
				catch (Exception e){ 
					// cannot be opened if there is no file
					 System.out.println("the date is invalid : ");
						}
				// new array list to store list of dates
				ArrayList<Date212> al = new ArrayList<Date212>();
				//Continue until theres a line in the file.
				while(in.hasNext()){
					String[] dates = in.next().split(",");
					//Traverse through the date array list
					for(int i=0; i<dates.length;i++){
						try{
							//add the dates to thelist
							al.add(new Date212(dates[i]));
						}
						//Catch block to show excaptions
						catch(Date212Exception de){
							System.out.println(de.getMessage());
						}
						
					} 
				}
				// new arraylist 
				Date212 [] dateArray = al.toArray(new Date212[al.size()]);
				// new unsorted list
				udl = new UnsortedDate212List();
				// Iterate through key set, looking up the value for each iteration
				for(Date212 d : al){
						// sort and add
						tm.put(d.getOriginal(),d);
						// add unsorted part
						udl.add(d);		
				}
				printDateGUI(udl,tm);
			}
	// function to insert new string of dates into the list 
	public void insertdate(String original){
			try{	// new date object with original value 
					Date212 newDate = new Date212(original);
					// sort and add 
					tm.put(original,newDate);
					// add unsorted part 
					udl.add(newDate);
					// print in the contect pane 
					printDateGUI(udl,tm);					
				}
				// to catch exception
				catch(Date212Exception de){
					System.out.println(de.getMessage());
				}

			}
   
	// function to print list in the both text area
	public void printDateGUI(UnsortedDate212List udl, TreeMap <String,Date212>tm){
		this.setVisible(false);
		Container contentPane = getContentPane();
		contentPane.removeAll();
		// new textareas 
		JTextArea unsorted = new JTextArea();
		JTextArea sorted = new JTextArea();
		unsorted.setEditable(false);
		sorted.setEditable(false);
		// new node setted to the head of the list
		Date212Node usn = udl.head;

		while(usn!=null){
			unsorted.setText(unsorted.getText()+usn.data.getOriginal()+"\n");
			usn = usn.next;
		}
		Iterator itr = tm.values().iterator();
		while(itr.hasNext()){
			sorted.setText(sorted.getText()+itr.next().toString()+"\n");
		}
		// nre gridlayout 
		GridLayout gl = new GridLayout(1,2);
		contentPane.setLayout(gl);
		//Adding unsorted_part into the left text area
		contentPane.add(unsorted);
		//adding sorted part in the right text area.
		contentPane.add(sorted);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);


	}
}

