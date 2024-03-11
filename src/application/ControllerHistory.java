package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerHistory {
	
	
	
	public void SwitchBack(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
}
