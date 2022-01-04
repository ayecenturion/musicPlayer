package ar.edu.ort.tp1.exfinal.clases;

public class Podcast extends Item{

	public Podcast(String nombre, String artista, int anioLanzamiento) {
		super(nombre, artista, anioLanzamiento);
	}
	
	public String toString() {
		return "Podcast " + super.getNombre() + " " + super.getArtista() + " " + super.getAnioLanzamiento();
	}

}
