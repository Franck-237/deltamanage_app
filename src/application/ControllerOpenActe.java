package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerOpenActe {

	public void SwitchToNaissance(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("AjoutActeNaissance.fxml"));
    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
	
	public void SwitchToDeces(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("AjoutActeDeces.fxml"));
    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
	
	public void SwitchToMariage(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("AjoutActeMariage.fxml"));
    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
	
	public void SwitchToDivorce(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("AjoutActeDivorce.fxml"));
    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
	
	public void SwitchToHistory(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("History.fxml"));
    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
	
	
}
