package br.nom.penha.bruno.qafxenvcreator.controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SegundoController implements Initializable {
	@FXML
	private Label label;

	@FXML // fx:id="retorno"
	private Button retorno; // Value injected by FXMLLoader

	@FXML
	void voltaPaginaAnterior(ActionEvent event) throws IOException {
		
		Stage stage = (Stage) retorno.getScene().getWindow();
		stage.hide();
		
		AnchorPane base =  FXMLLoader.load(getClass().getClassLoader().getResource("Primeiro.fxml"));

		Stage segundo = new Stage(StageStyle.UNIFIED);
		segundo.setScene(new Scene(base));
		segundo.show();

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		System.out.println("Second Stage is being loaded.");
	}
}
