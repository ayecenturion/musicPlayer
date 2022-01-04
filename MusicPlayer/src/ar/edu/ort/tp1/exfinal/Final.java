package ar.edu.ort.tp1.exfinal;

import ar.edu.ort.tp1.exfinal.clases.Cancion;
import ar.edu.ort.tp1.exfinal.clases.Item;
import ar.edu.ort.tp1.exfinal.clases.MusicPlayer;
import ar.edu.ort.tp1.exfinal.clases.Podcast;

public class Final {

	public static void main(String[] args) {
		MusicPlayer mp = new MusicPlayer("ORT Music Player");
		
		crearItems(mp);

		agregarItemsAPlaylist(mp);
		System.out.println();
		mp.reproducir();
		System.out.println();
		mp.mostrar();
	}

	private static void crearItems(MusicPlayer mp) {
		
		System.out.println("-----------Creando elementos a la playlist ----------");
		
		agregarItem(mp, null);
		agregarItem(mp, new Cancion("Nombre 1", "Artista 1", 2000));
		agregarItem(mp, new Cancion("Nombre 2", "Artista 2", 2002));
		agregarItem(mp, new Podcast("Podcast 2", "Podcaster 1", 2020));
		agregarItem(mp, new Cancion("Nombre 3", "Artista 3", 2018));
		agregarItem(mp, new Podcast("Podcast 1", "Podcaster 1", 2020));
		agregarItem(mp, new Cancion("Nombre 1", "Artista 1", 2021));
		agregarItem(mp, new Podcast("Podcast 8", "Podcaster 1", 2020));
		agregarItem(mp, new Cancion("Nombre 4", "Artista 5", 2007));
		agregarItem(mp, new Cancion("Nombre 5", "Artista 2", 2006));
		agregarItem(mp, new Podcast("Podcast 2", "Podcaster 1", 2020));
		agregarItem(mp, new Podcast("Podcast 6", "Podcaster 1", 2020));
		
	}

	private static void agregarItem(MusicPlayer mp, Item it) {
		try {
			mp.agregarItemDisponible(it);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void agregarItemsAPlaylist(MusicPlayer mp) {

		System.out.println();
		System.out.println("-----------Agregando elementos a la playlist ----------");
		agregarItemAPlayList(mp, "Nombre 5");
		agregarItemAPlayList(mp, "Nombre 3");
		agregarItemAPlayList(mp, null);
		agregarItemAPlayList(mp, "Podcast 2");
		agregarItemAPlayList(mp, "nombre que no está");
		
	}

	private static void agregarItemAPlayList(MusicPlayer mp, String nombre) {
		try {
			//System.out.println(nombre);
			Item i = mp.buscarItemPorNombre(nombre);
			//System.out.println(i.getNombre());
			mp.agregarPlaylist(i);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
