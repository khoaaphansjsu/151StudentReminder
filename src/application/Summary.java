package application;

import java.awt.TrayIcon.MessageType;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

// Create a quick summary of all Assignments due in 7 days
public class Summary {
	private final Map<String, Assignment> allAssigns = new AssignmentDB().getAllAssignments();
	
	public Summary() {}
	
	public void createSummary() {
		String sumString = "Date format: yyyy-mm-dd\n\n";
		
		LocalDateTime now = LocalDateTime.now();
		//What is the date 7 days from now?
		LocalDateTime sevenFromNow = now.plusDays(7);
		
		//Traverse through allAssigns to obtain Assignments
		for (Map.Entry mapE : allAssigns.entrySet()) {
			LocalDateTime assignDueDate = ((Assignment)mapE.getValue()).getDueDate();
			String dueString = assignDueDate.toString();
			//Concatenate the "time" tail from LocalDateTime String
			String dueSubString = dueString.substring(0, dueString.length()-6);
			//Obtain assignments that come after now
			//but before sevenFromNow
			if (assignDueDate.isAfter(now) && assignDueDate.isBefore(sevenFromNow)) {
				String key = (String)mapE.getKey();
				sumString += key + ",  Due: " + dueSubString +"\n";
			}
	    } 
		
		this.displaySummary(sumString);
	}
	
	private void displaySummary (String displayString) {
		////Remove this 
		////and use existing stage
		Stage primaryStage = new Stage();
			
		primaryStage.setTitle("Upcoming Dues In 7 Days");
		primaryStage.setWidth(600);
			
		//Creating a Text object for summary String
	    Text text = new Text();      
	      
	    //Setting the text to be added. 
	    text.setText(displayString); 
	       
	    //setting the position of the text 
	    text.setX(20);
	    text.setY(20); 
	      
	    //Creating a Group object  
	    Group root = new Group(text);   
	               
	    //Creating a scene object 
	    Scene scene = new Scene(root, 500, 250);
		primaryStage.setScene(scene);
			
		primaryStage.showAndWait();
	}
}