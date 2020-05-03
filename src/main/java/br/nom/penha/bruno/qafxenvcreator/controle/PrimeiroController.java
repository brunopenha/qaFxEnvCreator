package br.nom.penha.bruno.qafxenvcreator.controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PrimeiroController implements Initializable {

	@FXML
	private Label labelOlaMundo;

	@FXML // fx:id="txtNome"
	private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="proximo"
    private Button proximo; // Value injected by FXMLLoader
    
    @FXML // fx:id="botaoRepositorios"
    private Button botaoRepositorios; // Value injected by FXMLLoader

    @FXML
    void abreRepositorios() throws IOException {

    	Stage stage = (Stage) botaoRepositorios.getScene().getWindow();
		
		System.out.println("Abrindo repositorios");
		
		AnchorPane base = FXMLLoader.load(getClass().getClassLoader().getResource("Repositorios.fxml"));
	
		Stage repositorios = new Stage(StageStyle.UTILITY);
		repositorios.setScene(new Scene(base));
		repositorios.show();
		stage.hide();
    }


	@FXML
	public void acaoDoBotao() throws IOException {
		
		Stage stage = (Stage) proximo.getScene().getWindow();
		
		System.out.println("Clicou no botao");
		labelOlaMundo.setText("Ola  " + txtNome.getText() + " !");
		
		AnchorPane base = FXMLLoader.load(getClass().getClassLoader().getResource("Segunda.fxml"));
	
		Stage segundo = new Stage(StageStyle.UTILITY);
		segundo.setScene(new Scene(base));
		segundo.show();
		stage.hide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
