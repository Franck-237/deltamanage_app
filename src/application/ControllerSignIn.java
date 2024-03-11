package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerSignIn {
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField passwordField;
	
	public void SwitchToConnect(ActionEvent e) throws IOException, SQLException {
		
		String name = nameField.getText().trim();
        String password = passwordField.getText().trim();
        
        if (name.isEmpty() || password.isEmpty()) {
            // Afficher une alerte d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur d'enregistrement");
            alert.setContentText("Veuillez remplir tous les champs avant de continuer.");
            alert.showAndWait();
            return;
        }
        
        DatabaseConnection connectionManager = new DatabaseConnection();
        Connection connection = connectionManager.getConnection(); 
        
        if (connection == null) {
            // Afficher une alerte d'erreur de connexion
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur d'enregistrement");
            alert.setContentText("Echec de la connexion à la base de données");
        }else {
        	try {
        		// Préparer la requête
                String query = "SELECT * FROM admin WHERE nom_officier = ? AND mtp = ?";
                PreparedStatement statement = connection.prepareStatement(query);

                // Définir les valeurs des paramètres
                statement.setString(1, name);
                statement.setString(2, password);
                
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                	Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Enregistrement réussi");
                    alert.setContentText("Vous etes connecter.");
                    alert.showAndWait();
                    
                    connectionManager.closeConnection();
                    
                    Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
                	Scene scene = new Scene(root);
                	stage.setScene(scene);
                	stage.show();
                } else {
                    // Echec de l'authentification
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erreur de connexion");
                    alert.setContentText("Nom d'utilisateur ou mot de passe incorrect.");
                    alert.showAndWait();
                }
                
                
        	}catch (Exception ex) {
        		Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("Une erreur est survenue lors de la connexion");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
        	}finally {
                connectionManager.closeConnection();
            }
        }
        
    	
    }
	
	public void SwitchToNewCompte(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("CrerCompte.fxml"));
    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

}
