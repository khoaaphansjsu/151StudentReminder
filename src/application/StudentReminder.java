package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;


public class StudentReminder {

	private static final int SCENE_SIZE_Y = 500;
	private static final int SCENE_SIZE_X = 800;

	private final Stage stage;

	Scene signIn, signUp, homepage, addCustomAssignment, editAssignment;
	String checkUsername, checkPassword;
	String user = "";
	String pw = "";
	Assignment assignment;

	public StudentReminder(Stage primaryStage) {
		super();
		this.stage = primaryStage;

		createSignIn();
		createSignUp();
		createWelcome();
		createAddCustomAssignment();
		if(!Main.assignmentDB.dbIsEmpty()) {
		createEditAssignment(assignment); //new edit assignment variable to have parallel structure with already implemented features.
		}
	
	}

	private void createAddCustomAssignment() {
		addCustomAssignment = new Scene(new AddCustomAssignmentPane(this).createPane(), SCENE_SIZE_X, SCENE_SIZE_Y);
	}
	
	/*
	 * creating edit Assignment Pane similar to add Custom Assignment Pane above
	 * -josh
	 */
	private void createEditAssignment(Assignment currentAssignment) {
		editAssignment = new Scene(new EditAssignmentPane(this, currentAssignment).createPane(), SCENE_SIZE_X, SCENE_SIZE_Y);
	}

	public Scene getSignIn() {
		return signIn;
	}

	public Scene getSignUp() {
		return signUp;
	}

	public Scene getHomepage() {
		return homepage;
	}

	public Stage getStage() {
		return stage;
	}
	
	public Scene geteditAssignment() {
		return editAssignment;
	}

	private void createSignIn() {

		// Scene: The Sign In Page
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setHgap(8);
		gridPane.setVgap(8);
		gridPane.setAlignment(Pos.CENTER);

		Text title = new Text("Sign In");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Label lblUserName = new Label("Username");
		final TextField textUserName = new TextField();
		Label lblPassword = new Label("Password");
		final PasswordField password = new PasswordField();
		Button btnLogin = new Button("Login");
		final Label lblMessage = new Label();
		Hyperlink signUpLink = new Hyperlink("Sign Up");
		Button clearButton = new Button("Clear");

		// Add action on the sign up link
		signUpLink.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(signUp);
			}
		});

		// Add action on the log in button
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				checkUsername = textUserName.getText().toString();
				checkPassword = password.getText().toString();
				if (checkUsername.equals(user) && checkPassword.equals(pw)) {
					lblMessage.setText("Login Success");
					lblMessage.setTextFill(Color.GREEN);

					/*
					 * dataController controller2 = new dataController(); if
					 * (!controller2.readLine()) {
					 * 
					 * lblMessage.setText("Login Success"); lblMessage.setTextFill(Color.GREEN); }
					 */

					// go to the homepage
					stage.setScene(homepage);

				} else {
					lblMessage.setText("Incorrect username or password!");
					lblMessage.setTextFill(Color.RED);
				}
				textUserName.setText("");
				password.setText("");
			}
		});

		// Add action to the Clear button
		clearButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textUserName.clear();
				password.clear();
				lblMessage.setText(null);
			}
		});

		gridPane.add(title, 0, 0);
		gridPane.add(lblUserName, 0, 1);
		gridPane.add(textUserName, 1, 1);
		gridPane.add(lblPassword, 0, 2);
		gridPane.add(password, 1, 2);
		gridPane.add(btnLogin, 1, 3);
		gridPane.add(lblMessage, 1, 4);
		gridPane.add(signUpLink, 1, 5);
		gridPane.add(clearButton, 1, 6);

		signIn = new Scene(gridPane, SCENE_SIZE_X, SCENE_SIZE_Y);
	}

	private void createSignUp() {

		// Scene 2: The sign Up Page
		Text signUptitle = new Text("Sign Up");
		signUptitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Label username = new Label("Username:");
		final TextField usernameField = new TextField();
		Label signUppassword = new Label("Password");
		final PasswordField passwordField = new PasswordField();
		Button buttonReturn = new Button("Return Sign In");
		buttonReturn.setOnAction(e -> stage.setScene(signIn));
		Button submit = new Button("submit");
		submit.setPrefHeight(30);
		submit.setDefaultButton(true);
		submit.setPrefWidth(70);

		VBox layout2 = new VBox(20);
		layout2.setStyle("-fx-background-color: cyan;");
		layout2.setSpacing(10);
		layout2.setPadding(new Insets(20, 20, 20, 20));
		layout2.getChildren().addAll(signUptitle, username, usernameField, signUppassword, passwordField, submit,
				buttonReturn);
		signUp = new Scene(layout2, SCENE_SIZE_X, SCENE_SIZE_Y);

		// Add action on the submit button
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (usernameField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, signUp.getWindow(), "Error!", "Please Enter Your Name");

					/*
					 * dataController newControl = new dataController(); newControl.addLine();
					 */

					return;
				}

				if (passwordField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, signUp.getWindow(), "Error!", "Please Enter Your Password");
					return;
				}

				showAlert(Alert.AlertType.CONFIRMATION, signUp.getWindow(), "Successful!",
						"Welcome " + usernameField.getText());
			}

			private void showAlert(Alert.AlertType alertType, Window window, String title, String message) {

				Alert alert = new Alert(alertType);
				alert.setTitle(title);
				alert.setHeaderText(null);
				alert.setContentText(message);
				alert.initOwner(window);
				alert.show();

			}
		});

	}

	private void createWelcome() {
		// Scene 3: the homepage
		Label label3 = new Label("Homepage");
		VBox layout3 = new VBox(20);
		
		
		
		Button btnCustom = new Button("Add Custom Assignment");
		btnCustom.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(addCustomAssignment);
			}
		});
		
		
		/*
		 * NOTE VERY IMPORTANT: IF NOTHING IN YOUR DB, COMMENT LINE 244 OUT
		 * AND ADD SOMETHING TO THE DB, THEN RUN THE CODE WITH THAT ASSIGNMENT NAME TO EDIT
		 * IF YOU ARE GETTING AN ERROR HERE, MAKE THE PARAMETER OF THIS FUNCTION AN ASSIGNMENT YOU HAVE SAVED
		 * THEN IT WILL WORK.
		 */
		assignment = Main.assignmentDB.getAssignment("math");
		
		
		/*
		 * Edit button goes here for now,
		 * but consider having one on each listed asssignment.
		 * adding an isempty checker so that the program wont crash if you have nothing in db.
		 * -josh
		 */
		
		if(!Main.assignmentDB.dbIsEmpty()) {
		Label label4 = new Label(assignment.getName());
		Button btnEdit = new Button("Edit Assignment");
		btnEdit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {	
				stage.setScene(editAssignment);
			}
		});
		
		layout3.getChildren().addAll(label4, btnEdit);
		}
		
		
		/*
		 * 
		 * We will add a delete button here too for testing,
		 * my plan is to have an edit/delete button next to each assignment.
		 * -josh
		 */
		
		if(!Main.assignmentDB.dbIsEmpty()) {
			Label label5 = new Label("Delete Button");
			
			
			Button btnDelete = new Button("Delete Assignment");
			btnDelete.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {	
					Main.assignmentDB.deleteAssignment(assignment);
					stage.setScene(homepage);
				}
			});
			
			layout3.getChildren().addAll(label5, btnDelete);
		}
		
		
		
		
		layout3.getChildren().addAll(label3, btnCustom);

		homepage = new Scene(layout3, SCENE_SIZE_X, SCENE_SIZE_Y);

	}
}
