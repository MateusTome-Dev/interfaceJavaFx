package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;
import model.Music;

public class MusicRepository {
	private List<Music> music;
	private File database;

	private void saveMusic() {
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(database, false))) {
			for (Music musics : music) {
				String data = musics.getId() + ";" + musics.getMusica() + ";" + musics.getGenero() + ";"
						+ musics.getAutor();
				writer.println(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo database não foi encontrado");
		}
	}

	public MusicRepository() {
		this.database = new File("database-files.txt");
		this.music = new ArrayList<>();
		loadFiles();
	}

	public void loadFiles() {
		try (Scanner sc = new Scanner(database)) {
			while (sc.hasNextLine()) {

				String[] data = sc.nextLine().split(";");
				if (data.length >= 4) {
					Music musics = new Music();
					musics.setId(Integer.parseInt(data[0]));
					musics.setMusica(data[1]);
					musics.setGenero(data[2]);
					musics.setAutor(data[3]);
					music.add(musics);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado,criando um novo");
		}
	}
	// CRUD

	// Update-atualizar
	public void updateMusic(Music updateMusic) {
		for (int i = 0; i < music.size(); i++) {
			if (music.get(i).getId() == updateMusic.getId()) {
				music.set(i, updateMusic);
				saveMusic();
				break;
			}
		}
	}

	// Buscar Unico
	public Music getMusicById(int id) {
		for (Music musics : music) {
			if (musics.getId() == id) {
				return musics;
			}
		}
		return null;
	}

	// Buscar Todos
	public List<Music> buscarTodos() {
		return new ArrayList<>(music);
	}

	public void DeleteMusic(int id) {
		music.removeIf(musics -> musics.getId() == id);
	}

	// criar music
	public void addMusic(Music musics) {
		musics.setId(getNextId());
		music.add(musics);
		saveMusic();
	}

	private int getNextId() {
		int maxId = 0;
		for (Music musics : music) {
			if (musics.getId() > maxId) {
				maxId = musics.getId();
			}
		}
		return maxId + 1;
	}

}
