package application;

import java.awt.TrayIcon.MessageType;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * Guys, this class uses an image called ball.png
 * It is located in an image folder: image/ball.png
 * This folder is OUTSIDE THE SRC FOLDER
 * So when we submit, it's 
 * 		a) the src folder, containing application package
 * 		b) build.fxbuild
 * 		c) image folder
 * 
 * 		d) whatever other stuff you guys have
 */
public class Notification {
//	private static SystemTray tray;
//	private static TrayIcon trayIcon;
//	private static TrayIcon[] trayIconArr;
//	private static PopupMenu popup;
//	MenuItem checkForNotify;
//	MenuItem closeNotify;
	
	//Check if how many tray already exist
//	private static int trayCheck = 0;
	
	//read the icon image from image folder
//	static Image img = grabImage("image/ball.png");
	
	
	public Notification() {
//		if (SystemTray.isSupported()) {
//			displayTray();
//		} 
	}
	
	//Let's talk about how the notification should be displayed then I'll implement better
	//For now, I'll just display a default STRING
	//using JavaFX Alert
	//on a separate stage
	public static void displayInAppNotify(String notifyString) {
		Stage stage = new Stage();
			
		stage.setTitle("Work To Be Done");
		stage.setWidth(300);
			
		//Creating a Text object 
	    Text text = new Text();      
	      
	    //Setting the text to be added. 
	    text.setText("Hello World"); 
	       
	    //setting the position of the text 
	    text.setX(50); 
	    text.setY(50); 
	         
	    //Creating a Group object  
	    Group root = new Group(text);   
	               
	    //Creating a scene object 
	    Scene scene = new Scene(root, 500, 250);
		stage.setScene(scene);
			
		stage.showAndWait();
			
//		Alert notifyAlert = new Alert(AlertType.INFORMATION);
//		notifyAlert.setTitle("notifyA title");
//		notifyAlert.setHeaderText("header");
//		notifyAlert.setContentText(notifyString);
//		notifyAlert.show();
	}
	
	//To obtain image from the image folder
	//Will be used create TrayIcon in displayTray()
//	private static Image grabImage(String location) {
//		Image img = null; 
//		 try {
//		 	// Read image from a file
//		 	File imgFile = new File(location);
//		 	img = ImageIO.read(imgFile);
//		 } catch (IOException e) {
//		 	System.out.println("IOException with image file");
//		 }
//		 return img;
//	}
	
	//Display SystemTray on user's computer if SystemTray is supported on their OS
//	public static void displayTray() {
//		//Get the SystemTray instance
//		tray = SystemTray.getSystemTray();
//
//        //Create a pop-up menu
//        popup = new PopupMenu();
//        
//        //Create the icon for SystemTray
//      	trayIcon = new TrayIcon(img, "StudentReminder", popup);
//      	trayIcon.setImageAutoSize(true);
//      		
//      	try {
//      		tray.add(trayIcon);
//      	}
//      	catch (AWTException e) {System.out.println(e);}   
//    }

//	public void createItemMenu() {
//		//Create menu item for the ......
//        checkForNotify = new MenuItem(...);
//        checkForNotify.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // execute default action of the application
//                // ...
//            }
//        });
//	}
	
}