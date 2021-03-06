package application;
import javafx.application.Application;
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

public class logInSignUp extends Application {

Scene signIn, signUp, homepage;
String checkUsername, checkPassword;
String user = "HELLO";
String pw = "pass";
    
@Override
public void start(Stage primaryStage) {
        
primaryStage.setTitle("Student Reminder");




//Scene: The Sign In Page
GridPane gridPane = new GridPane();
gridPane.setPadding(new Insets(20,20,20,20));
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


//Add action on the sign up link
signUpLink.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent event) {
    	primaryStage.setScene(signUp);    	
    }});


//Add action on the log in button
btnLogin.setOnAction(new EventHandler<ActionEvent>() {
 public void handle(ActionEvent event) {	 
  checkUsername = textUserName.getText().toString();
  checkPassword = password.getText().toString();
  if(checkUsername.equals(user) && checkPassword.equals(pw)){
   lblMessage.setText("Login Success");
   lblMessage.setTextFill(Color.GREEN);           
   
   
  /*
   dataController controller2 = new dataController();
   if (!controller2.readLine()) {
	   
	   lblMessage.setText("Login Success");
	   lblMessage.setTextFill(Color.GREEN);     
   }
  */ 
    
   
// go to the homepage
   primaryStage.setScene(homepage);
	
  }
  else{
   lblMessage.setText("Incorrect username or password!");
   lblMessage.setTextFill(Color.RED);
  }
  textUserName.setText("");
  password.setText("");
 }});



//Add action to the Clear button
clearButton.setOnAction(new EventHandler<ActionEvent>() {
 public void handle(ActionEvent event) {         
 textUserName.clear();
 password.clear();
 lblMessage.setText(null); 		
 }});



//Scene 2: The sign Up Page
Text signUptitle = new Text("Sign Up");
title.setFont(Font.font("Arial", FontWeight.BOLD, 20));        
Label username = new Label("Username:");
final TextField usernameField = new TextField();
Label signUppassword = new Label("Password");
final PasswordField passwordField = new PasswordField();
Button buttonReturn = new Button("Return Sign In");
buttonReturn.setOnAction(e -> primaryStage.setScene(signIn));
Button submit = new Button("submit"); 
submit.setPrefHeight(30);
submit.setDefaultButton(true);
submit.setPrefWidth(70);



VBox layout2 = new VBox(20);
layout2.setStyle("-fx-background-color: cyan;");
layout2.setSpacing(10);
layout2.setPadding(new Insets(20, 20, 20, 20));
layout2.getChildren().addAll(signUptitle, username, usernameField, signUppassword, passwordField, submit, buttonReturn);
signUp = new Scene(layout2, 400, 400);


// Add action on the submit button    
submit.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent event) {
        if(usernameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, signUp.getWindow(), 
            "Error!", "Please Enter Your Name");
            
            
            /* 
            dataController newControl = new dataController();
            newControl.addLine();
            */        
            
            return;
        }
      
        if(passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, signUp.getWindow(), 
            "Error!", "Please Enter Your Password");
            return;
        }

        showAlert(Alert.AlertType.CONFIRMATION, signUp.getWindow(), 
        "Successful!", "Welcome " + usernameField.getText());
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




//Scene 3: the homepage
Label label3 = new Label("Homepage");
VBox layout3= new VBox(20);
layout3.getChildren().addAll(label3);
homepage = new Scene(layout3,300,250);


gridPane.add(title, 0, 0);
gridPane.add(lblUserName, 0, 1);
gridPane.add(textUserName, 1, 1);
gridPane.add(lblPassword, 0, 2);
gridPane.add(password, 1, 2);
gridPane.add(btnLogin, 1, 3);
gridPane.add(lblMessage, 1, 4);
gridPane.add(signUpLink, 1, 5);
gridPane.add(clearButton, 1, 6);


signIn = new Scene(gridPane, 300, 300);
primaryStage.setScene(signIn);
primaryStage.show();
}

public static void main(String[] args) {
	launch(args);
}
    
}
