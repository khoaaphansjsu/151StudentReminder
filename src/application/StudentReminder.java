package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class StudentReminder extends Application {

	public static final Database database = new Database();

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Student Reminder");

		// Create a scene with add custom assignment form grid pane as the root node
		GridPane addCustomAssignmentPane = new AddCustomAssignmentPane(primaryStage).createPane();

		Scene scene = new Scene(addCustomAssignmentPane, 800, 500);
		// Set the scene in primary stage
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {

		StudentReminder.database.getAllAssignments().forEach((k, v) -> System.out.println(v.toString()));

		launch(args);
	}

	public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
}