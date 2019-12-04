package br.nom.penha.bruno.qafxenvcreator.controle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class ArquivosFXMLController implements Initializable {

	static JFrame fileDialog;
	
	private FileChooser fil_chooser;
	
	public void initialize(URL location, ResourceBundle resources) {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Repositorios.fxml"));
//		loader.setController(this);
//		try {
//			loader.load();
//		} catch (Exception e) {
//			System.out.println(e.getMessage() + "ArquivosFXMLController failed");
//			e.printStackTrace();
//		}
	}

	@FXML
	Button okBtn;
	
	@FXML
	AnchorPane arquivosAnchor;

	@FXML
	TextField repLocationTextField;
	

	public TextField getRepLocationTextField() {
		return repLocationTextField;
	}

	public void setRepLocationTextField(TextField repLocationTextField) {
		this.repLocationTextField = repLocationTextField;
	}

	@FXML
	private void buscaArquivosAction(ActionEvent event) {

		fil_chooser = new FileChooser();
		
		// get the file selected 
        File file = fil_chooser.showOpenDialog(arquivosAnchor.getScene().getWindow()); 

        if (file != null) { 
              
        	repLocationTextField.setText(file.getAbsolutePath() + "  selected"); 
        } 
	}

	@FXML
	private void cancelCreatePersonAction(ActionEvent event) {
		System.out.println("Hello World");
	}

	@FXML
	public void setArquivosAnchor(AnchorPane fxmlCreatePerson) {
		arquivosAnchor = fxmlCreatePerson;
	}

	@FXML
	public AnchorPane getArquivosAnchor() {
		return arquivosAnchor;
	}

	@FXML
	public Button getOkBtn() {
		return okBtn;
	}

	@FXML
	public void setOkBtn(Button okBtn) {
		this.okBtn = okBtn;
	}
	
	
}
