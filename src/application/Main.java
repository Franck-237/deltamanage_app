package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws IOException {
		try {
			 Parent root = FXMLLoader.load(getClass().getResource("PageAcceuil.fxml"));
			 Scene scene = new Scene(root);
			 scene.getStylesheets().add("application.css");
			 stage.setScene(scene);
			 stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	 }
	 public static void main(String[] args) {
	 Application.launch(Main.class, args);
	 }
	

}
