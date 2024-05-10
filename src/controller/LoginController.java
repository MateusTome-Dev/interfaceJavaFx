package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField usuario;
	
	@FXML
	private TextField senha;
	
	public Stage primaryStage;
	
	public void entrar() {
		System.out.println("Tentativa de login...");
		if(usuario.getText().equals("admin")&&senha.getText().equals("admin")){
			try {
				FXMLLoader loader=new FXMLLoader(getClass().getResource("/views/projetoDashboard.fxml"));
				
				StackPane root = loader.load();

	
				
				Scene scene=new Scene(root,723,498);
				
				Stage currentStage=(Stage) usuario.getScene().getWindow();
				currentStage.setScene(scene);
				currentStage.setTitle("projetoDashboard");
				currentStage.show();
				System.out.println("Logado com sucesso!");
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			mensagemDeErro();
		}
	}
	public void mensagemDeErro() {
		Alert alert = new Alert (Alert.AlertType.ERROR);
		alert.setTitle("sua senha esta correta!");
		alert.setContentText("senha ou nome incorreto!");
		alert.setHeaderText(null);
		alert.showAndWait();
	}
}
