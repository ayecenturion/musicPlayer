package ar.edu.ort.tp1.exfinal.clases;

public class Cancion extends Item{

	public Cancion(String nombre, String artista, int anioLanzamiento) {
		super(nombre, artista, anioLanzamiento);
		
	}

	@Override
	public String toString() {
		return "Cancion " + super.getNombre() + " " + super.getArtista() + " " + super.getAnioLanzamiento();
	}
	
	

}
