package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerSignUp {
	@FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;
    
    @FXML
    private TextField posteField;

    @FXML
    private PasswordField passwordField1;

    @FXML
    private PasswordField passwordField2;
    
    public void SwitchToConnexion(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("connexion.fxml"));
    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

    public void SwitchToCreate(ActionEvent e) throws IOException, SQLException {
        // Récupérer les valeurs des champs du formulaire
        String name = nameField.getText().trim();
        String surname = surnameField.getText().trim();
        String poste = posteField.getText().trim();
        String password1 = passwordField1.getText().trim();
        String password2 = passwordField2.getText().trim();

        // Valider si tous les champs sont remplis
        if (name.isEmpty() || surname.isEmpty() || password1.isEmpty() || password2.isEmpty() || poste.isEmpty()) {
            // Afficher une alerte d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur d'enregistrement");
            alert.setContentText("Veuillez remplir tous les champs avant de continuer.");
            alert.showAndWait();
            return;
        }

        // Vérifier si les mots de passe correspondent
        if (!password1.equals(password2)) {
            // Afficher une alerte d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur d'enregistrement");
            alert.setContentText("Veuillez vérifier vos mots de passe et réessayer.");
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
            	// Préparer la requête INSERT avec des paramètres préparés
                String query = "INSERT INTO admin (nom_officier, prenom_officer, poste, mtp) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);

                // Définir les valeurs des paramètres
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setString(3, poste);
                statement.setString(4, password1);

                // Exécuter la requête et enregistrer les données
                statement.executeUpdate();

                // Afficher une alerte de succès
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Enregistrement réussi");
                alert.setContentText("Vous pouvez maintenant vous connecter.");
                alert.showAndWait();
                
                connectionManager.closeConnection();

                // Rediriger vers la page de connexion
                Parent root = FXMLLoader.load(getClass().getResource("connexion.fxml"));
                Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        	} catch (SQLException ex) {
            // Afficher une alerte d'erreur en cas d'exception SQL
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Une erreur est survenue lors de l'enregistrement");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        } finally {
            connectionManager.closeConnection();
        }
    }



}
}



