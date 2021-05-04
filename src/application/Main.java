package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

//When this code is integrated into the main branch, I'll just
//		a) change from primaryStage to whatever Stage we're using
//		b) adjust the positions of the button
//		c) In Notification.java, I'll change "Hello World" to our assignments
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Create a Notification object
			Notification ntf = new Notification();
			
			//Add a button to show Notify called showNotify
			Button showNotify = new Button("SHOW UPCOMING WORK");
			
			//VBox containing the showNotify button
			VBox vb = new VBox();
			vb.getChildren().addAll(showNotify);
			
			//showNotify button calls displayInAppNotify in Notification.java
			showNotify.setOnAction(event -> ntf.displayInAppNotify("Hello"));
			
			//Create a scene for the VBox
			Scene scene = new Scene(vb);
			
			//Set scene for the stage above
			primaryStage.setScene(scene);
			primaryStage.show();	
	    	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
