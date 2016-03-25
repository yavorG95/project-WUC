package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;

import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

public class LoginController implements Initializable{
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private Label isConnected;

	
	
	public LoginModel loginModel = new LoginModel();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		if(loginModel.isDBconnected()){
			isConnected.setText("Connected");
		} else{
			isConnected.setText("Connection unsuccesful");
		}
	}
	
	public void Login(ActionEvent event) {
			
			try{
				if(loginModel.isLogin(txtUsername.getText(), txtPassword.getText())){
					isConnected.setText("username and password is correct");
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader();
					Pane root = loader.load(getClass().getResource("Admin.fxml").openStream());
					AdminController adminController = (AdminController)loader.getController();
					adminController.GetAdmin(txtUsername.getText());
					Scene scene = new Scene(root,700,400);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
					
				} 
				else{
					isConnected.setText("Wrong credentials");
				}
			}
			catch (SQLException e){
				isConnected.setText("Wrong credentials");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}

