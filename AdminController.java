package application;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class AdminController implements Initializable{
	@FXML
	private Label adminlbl;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void GetAdmin(String admin) {
		// TODO Auto-generated method stub
		adminlbl.setText(admin);
	}

}
