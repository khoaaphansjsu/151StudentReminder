package application;
	
import java.awt.Insets;
import java.awt.Label;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Pane root = new Pane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Text Text1 = new Text("Your Current Assignments");
			Text1.setStyle("-fx-font: normal bold 30px 'serif' ");
			Text1.setLayoutX(300);
			Text1.setLayoutY(50);
			
			root.getChildren().add(Text1);
			
			Button btn1 = new Button ("Add Custom Assignment");
			
			Button btn2 = new Button ("Add Canvas Assignment");
			
			Text testAssignment = new Text("Test Asssignment");
			testAssignment.setStyle("-fx-font: normal bold 20px 'serif' ");
			
			testAssignment.setLayoutX(200);
			testAssignment.setLayoutY(150);
			
			
			btn1.setLayoutX(200);
			btn1.setLayoutY(300);
			
			btn2.setLayoutX(500);
			btn2.setLayoutY(300);
			
			
			root.getChildren().add(btn1);
			root.getChildren().add(btn2);
			root.getChildren().add(testAssignment);			
			
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
