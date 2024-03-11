package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControllerRegister {
	
	@FXML
	private TextField numField;
	@FXML
	private TextField nameField;
	@FXML
	private TextField surnameField;
	@FXML
 	private TextField dateField;
	@FXML
	private TextField lieuField;
	@FXML
	private TextField sexeField;
	@FXML
	private TextField nompField;
	@FXML
	private TextField prenompField;
	@FXML
	private TextField datepField;
	@FXML
	private TextField natpField;
	@FXML
	private TextField profpField;
	@FXML
	private TextField nommField;
	@FXML
	private TextField prenommField;
	@FXML
	private TextField datemField;
	@FXML
	private TextField natmField;
	@FXML
	private TextField profmField;
	@FXML
	private TextField nomoffField;
	@FXML
	private TextField assField;
	@FXML
	private TextField dateeField;
	@FXML
	private TextField decedeField;
	@FXML
	private TextField datedField;
	@FXML
	private TextField lieudField;
	@FXML
 	private TextField datenField;
	@FXML
	private TextField lieunField;
	@FXML
	private TextField profField;
	@FXML
	private TextField domField;
	@FXML
	private TextField nompeField;
	@FXML
	private TextField dompField;
	@FXML
	private TextField nommeField;
	@FXML
	private TextField dommField;
	@FXML
	private TextField datecField;
	@FXML
	private TextField nomofField;
	@FXML
	private TextField numdField;
	@FXML
	private TextField pdecedeField;
	@FXML
	private TextField nomepoField;
	@FXML
	private TextField prenomepField;
	@FXML
	private TextField datenepField;
	@FXML
 	private TextField profepField;
	@FXML
	private TextField domepField;
	@FXML
	private TextField nompepField;
	@FXML
	private TextField nommepField;
	@FXML
	private TextField nomepseField;
	@FXML
	private TextField prenomepseField;
	@FXML
	private TextField datenepseField;
	@FXML
	private TextField profepseField;
	@FXML
	private TextField domepseField;
	@FXML
	private TextField nompepseField;
	@FXML
	private TextField nommepseField;
	@FXML
	private TextField nommaireField;
	@FXML
	private TextField numdivField;
	@FXML
	private TextField nomavField;
	@FXML
	private TextField telField;
	@FXML
	private TextField numadField;
	@FXML
	private TextField numamField;
	@FXML
	private TextField nepField;
	@FXML
	private TextField pepField;
	@FXML
 	private TextField dnepField;
	@FXML
	private TextField prepField;
	@FXML
	private TextField depField;
	@FXML
	private TextField npepField;
	@FXML
	private TextField nmepField;
	@FXML
	private TextField nepseField;
	@FXML
	private TextField pepseField;
	@FXML
	private TextField dnepseField;
	@FXML
	private TextField prepseField;
	@FXML
	private TextField depseField;
	@FXML
	private TextField npepseField;
	@FXML
	private TextField nmepseField;
	@FXML
	private TextField rmField;
	@FXML
	private TextField cfepField;
	@FXML
	private TextField cfepseField;
	@FXML
	private TextField tepField;
	@FXML
	private TextField tepseField;
	@FXML
	private TextField nofField;
	@FXML
	private TextField asField;
	@FXML
	private TextField dField;
	
	@FXML
	
	
	public void SwitchBack(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
	
	
	
	public void SwitchToCreateActe(ActionEvent e) throws IOException {

		String num = numField.getText().trim();
		String name = nameField.getText().trim();
		String username = surnameField.getText().trim();
        String date = dateField.getText().trim();
        String lieu = lieuField.getText().trim();
        String sexe = sexeField.getText().trim();
        String nomp = nompField.getText().trim();
        String prenomp = prenompField.getText().trim();
        String datep = datepField.getText().trim();
        String natp = natpField.getText().trim();
        String profp = profpField.getText().trim();
        String nomm = nommField.getText().trim();
        String prenomm = prenommField.getText().trim();
        String datem = datemField.getText().trim();
        String natm = natmField.getText().trim();
        String profm = profmField.getText().trim();
        String nomoff = nomoffField.getText().trim();
        String ass = assField.getText().trim();
        String datee = dateeField.getText().trim();
        
        if (name.isEmpty() || username.isEmpty() || num.isEmpty() || date.isEmpty() || lieu.isEmpty() || sexe.isEmpty() || nomp.isEmpty() || nomm.isEmpty()) {
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
            	// Préparer la requête INSERT avec des paramètres préparés
                String query = "INSERT INTO acte_naissance (num_acte, nom_enfant, prenom_enfant, date_naissance, lieu_naissance, sexe, nom_pere, prenom_pere, date_naissance_pere, nationalite_pere, profession_pere, nom_mere, prenom_mere, date_naissance_mere, nationalite_mere, profession_mere, id_admin1, nom_assistant, date_delivrance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);

                // Définir les valeurs des paramètres
                statement.setString(1, num);
                statement.setString(2, name);
                statement.setString(3, username);
                statement.setString(4, date);
                statement.setString(5, lieu);
                statement.setString(6, sexe);
                statement.setString(7, nomp);
                statement.setString(8, prenomp);
                statement.setString(9, datep);
                statement.setString(10, natp);
                statement.setString(11, profp);
                statement.setString(12, nomm);
                statement.setString(13, prenomm);
                statement.setString(14, datem);
                statement.setString(15, natm);
                statement.setString(16, profm);
                statement.setString(17, nomoff);
                statement.setString(18, ass);
                statement.setString(19, datee);

                // Exécuter la requête et enregistrer les données
                statement.executeUpdate();

                // Afficher une alerte de succès
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Enregistrement réussi");
                alert.setContentText("Vous Venez d'ajouter un nouvel acte de naissance!!");
                alert.showAndWait();
                
                connectionManager.closeConnection();

                // Rediriger vers la page de connexion
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
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
	
	public void SwitchToDeces(ActionEvent e) throws IOException {
		
		String numd = numdField.getText().trim();
		String nomd = decedeField.getText().trim();
		String prenomd = pdecedeField.getText().trim();
		String dated = datedField.getText().trim();
		String lieud = lieudField.getText().trim();
        String daten = datenField.getText().trim();
        String lieun = lieunField.getText().trim();
        String prof = profField.getText().trim();
        String dom = domField.getText().trim();
        String nompe = nompeField.getText().trim();
        String domp = dompField.getText().trim();
        String nomme = nommeField.getText().trim();
        String domm = dommField.getText().trim();
        String datec = datecField.getText().trim();
        String nomof = nomofField.getText().trim();
        
        if (numd.isEmpty() || nomd.isEmpty() || prenomd.isEmpty()  || dated.isEmpty() || lieud.isEmpty() || prof.isEmpty() || dom.isEmpty() || nompe.isEmpty() || nomme.isEmpty() || nomof.isEmpty()) {
            // Afficher une alerte d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur d'enregistrement");
            alert.setContentText("Veuillez remplir les champs importants liés au décédé.");
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
                String query = "INSERT INTO acte_deces (num_acte, nom_decede, prenom_decede, date_deces, lieu_deces, date_naissance, lieu_naissance, profession, domicile, nom_pere, domicile_pere, nom_mere, domicile_mere, id_admin2, date_delivrance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);

                // Définir les valeurs des paramètres
                statement.setString(1, numd);
                statement.setString(2, nomd);
                statement.setString(3, prenomd);
                statement.setString(4, dated);
                statement.setString(5, lieud);
                statement.setString(6, daten);
                statement.setString(7, lieun);
                statement.setString(8, prof);
                statement.setString(9, dom);
                statement.setString(10, nompe);
                statement.setString(11, domp);
                statement.setString(12, nomme);
                statement.setString(13, domm);
                statement.setString(14, datec);
                statement.setString(15, nomof);

                // Exécuter la requête et enregistrer les données
                statement.executeUpdate();

                // Afficher une alerte de succès
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Enregistrement réussi");
                alert.setContentText("Vous Venez d'ajouter un nouvel acte de décès!!");
                alert.showAndWait();
                
                connectionManager.closeConnection();

                // Rediriger vers la page de connexion
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
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
	
	public void SwitchToDivorce(ActionEvent e) throws IOException {
		
		String numad = numadField.getText().trim();
		String nomep = nomepoField.getText().trim();
		String prenomep = prenomepField.getText().trim();
		String datenep = datenepField.getText().trim();
        String profep = profepField.getText().trim();
        String domep = domepField.getText().trim();
        String nompep = nompepField.getText().trim();
        String nommep = nommepField.getText().trim();
        String nomepse = nomepseField.getText().trim();
        String prenomepse = prenomepseField.getText().trim();
        String datenepse = datenepseField.getText().trim();
        String profepse = profepseField.getText().trim();
        String domepse = domepseField.getText().trim();
        String nompepse = nompepseField.getText().trim();
        String nommepse = nommepseField.getText().trim();
        String nommaire = nommaireField.getText().trim();
        String numdiv = numdivField.getText().trim();
        String nomav = nomavField.getText().trim();
        String tel = telField.getText().trim();
        
        if (nomep.isEmpty() || prenomep.isEmpty() || nomepse.isEmpty() || prenomepse.isEmpty() || nompep.isEmpty() || nommep.isEmpty() || nompepse.isEmpty() || nommepse.isEmpty() || nommaire.isEmpty() || nomav.isEmpty() || tel.isEmpty()) {
            // Afficher une alerte d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur d'enregistrement");
            alert.setContentText("Veuillez remplir les champs importants par rapport aux deux époux.");
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
                String query = "INSERT INTO acte_divorce (num_acte, nom_epoux, prenom_epoux, date_naissance_epoux, profession_epoux, domicile_epoux, nom_pere_epoux, nom_mere_epoux, nom_epouse, prenom_epouse, date_naissance_epouse, profession_epouse, domicile_epouse, nom_pere_epouse, nom_mere_epouse, num_acte_mariage, nom_avocat, num_avocat, nom_mairie) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);

                // Définir les valeurs des paramètres
                statement.setString(1, numad);
                statement.setString(2, nomep);
                statement.setString(3, prenomep);
                statement.setString(4, datenep);
                statement.setString(5, profep);
                statement.setString(6, domep);
                statement.setString(7, nompep);
                statement.setString(8, nommep);
                statement.setString(9, nomepse);
                statement.setString(10, prenomepse);
                statement.setString(11, datenepse);
                statement.setString(12, profepse);
                statement.setString(13, domepse);
                statement.setString(14, nompepse);
                statement.setString(15, nommepse);
                statement.setString(16, numdiv);
                statement.setString(17, nomav);
                statement.setString(18, tel);
                statement.setString(19, nommaire);

                // Exécuter la requête et enregistrer les données
                statement.executeUpdate();

                // Afficher une alerte de succès
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Enregistrement réussi");
                alert.setContentText("Vous Venez d'ajouter un nouvel acte de divorce!!");
                alert.showAndWait();
                
                connectionManager.closeConnection();

                // Rediriger vers la page de connexion
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
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
	
	public void SwitchToMariage(ActionEvent e) throws IOException {
		
		String numam = numamField.getText().trim();
		String nep = nepField.getText().trim();
		String pep = pepField.getText().trim();
		String dnep = dnepField.getText().trim();
        String prep = prepField.getText().trim();
        String dep = depField.getText().trim();
        String npep = npepField.getText().trim();
        String nmep = nmepField.getText().trim();
        String nepse = nepseField.getText().trim();
        String pepse = pepseField.getText().trim();
        String dnepse = dnepseField.getText().trim();
        String prepse = prepseField.getText().trim();
        String depse = depseField.getText().trim();
        String npepse = npepseField.getText().trim();
        String nmepse = nmepseField.getText().trim();
        String rm = rmField.getText().trim();
        String cfep = cfepField.getText().trim();
        String cfepse = cfepseField.getText().trim();
        String tep = tepField.getText().trim();
        String tepse = tepseField.getText().trim();
        String nof = nofField.getText().trim();
        String as = asField.getText().trim();
        String d = dField.getText().trim();
        
        
        if (nep.isEmpty() || pep.isEmpty() || nepse.isEmpty() || pepse.isEmpty() || npep.isEmpty() || nmep.isEmpty() || npepse.isEmpty() || nmepse.isEmpty() || cfep.isEmpty() || cfepse.isEmpty() || tep.isEmpty() || tepse.isEmpty()) {
            // Afficher une alerte d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur d'enregistrement");
            alert.setContentText("Veuillez remplir les champs importants par rapport aux deux époux.");
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
                String query = "INSERT INTO acte_mariage (num_acte, nom_epoux, prenom_epoux, date_naissance_epoux, profession_epoux, domicile_epoux, nom_pere_epoux, nom_mere_epoux, nom_epouse, prenom_epouse, date_naissance_epouse, profession_epouse, domicile_epouse, nom_pere_epouse, nom_mere_epouse, regime_mat, chef_epoux, chef_epouse, temoin_epoux, temoin_epouse, id_admin2, nom_assistant, date_delivrance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);

                // Définir les valeurs des paramètres
                statement.setString(1, numam);
                statement.setString(2, nep);
                statement.setString(3, pep);
                statement.setString(4, dnep);
                statement.setString(5, prep);
                statement.setString(6, dep);
                statement.setString(7, npep);
                statement.setString(8, nmep);
                statement.setString(9, nepse);
                statement.setString(10, pepse);
                statement.setString(11, dnepse);
                statement.setString(12, prepse);
                statement.setString(13, depse);
                statement.setString(14, npepse);
                statement.setString(15, nmepse);
                statement.setString(16, rm);
                statement.setString(17, cfep);
                statement.setString(18, cfepse);
                statement.setString(19, tep);
                statement.setString(20, tepse);
                statement.setString(21, nof);
                statement.setString(22, as);
                statement.setString(23, d);

                // Exécuter la requête et enregistrer les données
                statement.executeUpdate();

                // Afficher une alerte de succès
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Enregistrement réussi");
                alert.setContentText("Vous Venez d'ajouter un nouvel acte de mariage!!");
                alert.showAndWait();
                
                connectionManager.closeConnection();

                // Rediriger vers la page de connexion
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
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
