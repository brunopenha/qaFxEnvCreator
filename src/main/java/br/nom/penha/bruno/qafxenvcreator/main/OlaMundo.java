package br.nom.penha.bruno.qafxenvcreator.main;


import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class OlaMundo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		// Adicione como parametro da VM
		// --module-path=<CAMINHO_LIB_JAVAFX>\javafx-sdk-11.0.2\lib --add-modules=javafx.controls
		
		String version = System.getProperty("java.version");
		Alert alerta = new Alert(AlertType.INFORMATION,"This is a test first screen " + version, ButtonType.OK);
		alerta.setHeaderText("Test screen");
		alerta.setResizable(true);
		alerta.showAndWait();
	}
}
