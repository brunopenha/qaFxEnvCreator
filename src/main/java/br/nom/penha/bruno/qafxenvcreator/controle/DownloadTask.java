package br.nom.penha.bruno.qafxenvcreator.controle;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.concurrent.Task;

public class DownloadTask extends Task<Object> {

	private String caminho;
	
	public DownloadTask(String endereco) {
		caminho = endereco;
	}
	
	@Override
	protected Object call() throws Exception {
		
		
		String extensao = caminho.substring(caminho.lastIndexOf('.'), caminho.length());
		
		URLConnection conexao = new URL(caminho).openConnection();
		
		long tamanhoArq = conexao.getContentLengthLong();
		
		try(InputStream is = conexao.getInputStream();
			OutputStream os = Files.newOutputStream(Paths.get("temp" + extensao)) // Nome do arquivo que sera salvo
			//OutputStream os = Files.newOutputStream(Paths.get("https://storage.googleapis.com/minikube/releases/v1.5.2/minikube-windows-amd64.exe"))
			){
			
			long nread = 0L;
			 byte[] buf = new byte[8192];
             int n;
             while ((n = is.read(buf)) > 0) {
                 os.write(buf, 0, n);
                 nread += n;
                 updateProgress(nread, tamanhoArq);
             }
		}
		
		return true;		
		
	}

	@Override
    protected void failed() {
        System.out.println("failed");
        this.cancel();
    }

    @Override
    protected void succeeded() {
        System.out.println("downloaded");        
    }
}
