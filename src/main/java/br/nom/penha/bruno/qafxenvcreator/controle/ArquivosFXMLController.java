package br.nom.penha.bruno.qafxenvcreator.controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ArquivosFXMLController implements Initializable {

	static JFrame fileDialog;

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
	Button arquivoBtn;

	@FXML
	Button diretorioBtn;

	@FXML
	AnchorPane arquivosAnchor;

	@FXML
	TextField repLocationTextField;
	
	@FXML
	TextField campoURL = new TextField();

	@FXML
	TextArea saidaTextArea;

	@FXML 
	ProgressBar progressBar;

	public TextField getRepLocationTextField() {
		return repLocationTextField;
	}

	public void setRepLocationTextField(TextField repLocationTextField) {
		this.repLocationTextField = repLocationTextField;
	}
	
	@FXML
	private void buscaArquivosAction(ActionEvent event) {

		FileChooser arquivoEscolhido = new FileChooser();

		File file = arquivoEscolhido.showOpenDialog(arquivosAnchor.getScene().getWindow());

		if (file != null) {

			repLocationTextField.setText(file.getAbsolutePath());
			repLocationTextField.setEditable(false);

			String result = null;
			try {
				Runtime r = Runtime.getRuntime();

				Process p = r.exec(file.getCanonicalPath());

				BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					System.out.println(inputLine);
					saidaTextArea.setText(inputLine);
					result += inputLine;
				}
				in.close();

			} //catch (IOException e) {
				catch (Exception e) { // TODO Remove me
				System.out.println(e);
				saidaTextArea.setText(e.getMessage());
			}
		}
	}

	@FXML
	private void buscaDiretorioAction(ActionEvent event) {

		DirectoryChooser diretorioEscolhido = new DirectoryChooser();
		File caminho = diretorioEscolhido.showDialog(arquivosAnchor.getScene().getWindow());

		if (caminho != null) {

			repLocationTextField.setText(caminho.getAbsolutePath());
			repLocationTextField.setEditable(false);

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
	public Button getArquivoBtn() {
		return arquivoBtn;
	}

	@FXML
	public void setArquivoBtn(Button okBtn) {
		this.arquivoBtn = okBtn;
	}
	
    @FXML // fx:id="anteriorButton"
    private Button anteriorButton; // Value injected by FXMLLoader

    @FXML // fx:id="proximoButton"
    private Button proximoButton; // Value injected by FXMLLoader



	public Button getDiretorioBtn() {
		return diretorioBtn;
	}

	public void setDiretorioBtn(Button diretorioBtn) {
		this.diretorioBtn = diretorioBtn;
	}

	@FXML 
	public void onBaixarArquivoClick(ActionEvent event) {
		
		arquivoBtn.setDisable(true);
		
		campoURL.setText("https://storage.googleapis.com/minikube/releases/v1.5.2/minikube-windows-amd64.exe"); //FIXME
		
		Task<Object> task = new DownloadTask(campoURL.getText());
        		
        progressBar.setProgress(0);
		progressBar.setPrefWidth(350);
		progressBar.progressProperty().unbind();
        progressBar.progressProperty().bind(task.progressProperty());
        
//        arquivosAnchor.getChildren().add(progressBar);

        campoURL.clear();

        
        
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
		
			
	}
	
    @FXML
    void acaoPaginaAnterior(ActionEvent event) throws IOException {

    	Stage stage = (Stage) anteriorButton.getScene().getWindow();
		stage.hide();
		
		AnchorPane base =  FXMLLoader.load(getClass().getClassLoader().getResource("Primeiro.fxml"));

		Stage segundo = new Stage(StageStyle.UNIFIED);
		segundo.setScene(new Scene(base));
		segundo.show();

    }

    @FXML
    void acaoProximaPagina(ActionEvent event) throws IOException {

    	Stage stage = (Stage) proximoButton.getScene().getWindow();
		stage.hide();
		
		AnchorPane base =  FXMLLoader.load(getClass().getClassLoader().getResource("Segunda.fxml"));

		Stage segundo = new Stage(StageStyle.UNIFIED);
		segundo.setScene(new Scene(base));
		segundo.show();

    }

}
