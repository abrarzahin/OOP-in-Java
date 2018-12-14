
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.File;

public class EditMenuHandler implements ActionListener 
{
     // Save the reference to the gui object this FileMenuHandler is 
    // associated with
    private Date212GUI gui;
   
    // Constructor that takes as its paramaeter the gui associated 
    // with this FileMenuHandler
    public EditMenuHandler(Date212GUI gui) 
    {
        this.gui = gui;
    }
 


@Override

public void actionPerformed(ActionEvent event) {
     // Get the command name from the event
    String MenuName = event.getActionCommand();
        
        // If user select insert then show dialouge input 
        // take that string and use insertdate function from the gui to 
        // place that date in the unsorted and sorted part 
        if (MenuName.equals("insert")) {
            String original = JOptionPane.showInputDialog(null,"Input a date212 object to insert");
             this.gui.insertdate(original);
				
        }
    }
}