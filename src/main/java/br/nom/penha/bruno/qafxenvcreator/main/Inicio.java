package br.nom.penha.bruno.qafxenvcreator.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Inicio extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		// Adicione como parametro da VM
		// --module-path "C:\your\path\javafx-sdk-12.0.1\lib" --add-modules javafx.controls,javafx.fxml
		AnchorPane base = FXMLLoader.load(getClass().getClassLoader().getResource("Repositorios.fxml"));
		Scene scene = new Scene(base);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
