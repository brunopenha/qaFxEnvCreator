/**
 * 
 */
package br.nom.penha.bruno.qafxenvcreator.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author bruno
 *
 */
public class Paginado extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			AnchorPane base = FXMLLoader.load(getClass().getClassLoader().getResource("Primeiro.fxml"));
			Scene scene = new Scene(base);
			scene.getStylesheets().add(getClass().getClassLoader().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
