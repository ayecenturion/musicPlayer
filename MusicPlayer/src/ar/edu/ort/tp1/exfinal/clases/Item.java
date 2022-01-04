package ar.edu.ort.tp1.exfinal.clases;

public abstract class Item {

	private String nombre;
	private String artista;
	private int anioLanzamiento;
	
	public Item (String nombre, String artista, int anioLanzamiento) {
		this.setNombre(nombre);
		this.setArtista(artista);
		this.setAnioLanzamiento(anioLanzamiento);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArtista() {
		return artista;
	}

	private void setArtista(String artista) {
		this.artista = artista;
	}

	public int getAnioLanzamiento() {
		return anioLanzamiento;
	}

	private void setAnioLanzamiento(int anioLanzamiento) {
		this.anioLanzamiento = anioLanzamiento;
	}

	@Override
	public String toString() {
		return "Item [nombre=" + nombre + ", artista=" + artista + ", anioLanzamiento=" + anioLanzamiento + "]";
	}
	

	//TODO A implementar 
}
