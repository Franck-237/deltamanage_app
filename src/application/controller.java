package application;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controller {

    private Stage stage;
    private Scene scene;
    
    public void SwitchToAcceuil(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("PageAcceuil.fxml"));
    	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    public void SwitchToNewCompte(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("CrerCompte.fxml"));
    	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    public void SwitchToVerifCompte(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("vérificationCompte.fxml"));
    	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    
    public void SwitchToConnect(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
    	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    public void SwitchToCreate(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("connexion.fxml"));
    	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
        
}
