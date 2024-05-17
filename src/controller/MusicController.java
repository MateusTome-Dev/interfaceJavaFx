package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Music;
import repository.MusicRepository;

public class MusicController {
	
	@FXML
	private TableView<Music> list;
	
	@FXML
	private TableColumn<Music, String> colun1;
	
	@FXML
	private TableColumn<Music, String> colun2;
	
	@FXML
	private TableColumn<Music, String> colun3;

	@FXML
	private TextField nomeMusica;
	
	@FXML
	private TextField generoo;
	
	@FXML
	private TextField autorr;
	
	private MusicRepository repoMusic;
	
	@FXML
	public void initialize() {
		repoMusic = new MusicRepository();
	}
	
	public void adicionar() {
		Music musics =new Music();
		musics.setMusica(nomeMusica.getText());
		musics.setGenero(generoo.getText());
		musics.setAutor(autorr.getText());
		repoMusic.addMusic(musics);
	}
	
	public void limparFields() {
		nomeMusica.clear();
		generoo.clear();
		autorr.clear();
	}
	
	public void limpar() {
		limparFields();
	}
	
}
