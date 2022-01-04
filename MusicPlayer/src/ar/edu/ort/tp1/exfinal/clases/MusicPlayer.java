package ar.edu.ort.tp1.exfinal.clases;

import edu.ort.tp1.u5.tda.Cola;
import edu.ort.tp1.u5.tda.ListaOrdenada;
import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.ColaNodos;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public class MusicPlayer implements Reproducible, Mostrable {

	private static final String ITEM_NO_PUEDE_SER_NULO = "El Item no puede ser nulo.";
	private static final String ITEM_YA_EXISTENTE = "El item ingresado ya existe en el reproductor";
	private static final String NOMBRE_NO_PUEDE_SER_NULO = "El  nombre no puede ser nulo";
	private static final String ITEM_NO_ENCONTRADO = "El item no fue encontrado";
	private String nombre;
	private ListaPorNombre listaItems;
	private PlayList playList;

	public MusicPlayer(String nombre) {
		 this.setNombre(nombre);
		 this.listaItems = new ListaPorNombre();
		 this.playList = new PlayList();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Agrega un item al listado de disponibles. este item, que se identifica con un
	 * nombre, no podrá estar repetido en la lista y tampoco podrá ser nulo.
	 * 
	 * @param item el Item a agregar.
	 */
	public void agregarItemDisponible(Item item) throws IllegalArgumentException {
		 if(item == null) {
			 throw new IllegalArgumentException(ITEM_NO_PUEDE_SER_NULO);
		 }else {
			 Item buscado = buscarItemPorNombre(item.getNombre());
			 if(buscado == null) {
				 this.listaItems.add(item);
				 System.out.println("Item agregado correctamente");
			 }else {
				 throw new IllegalArgumentException(ITEM_YA_EXISTENTE);
			 }
		 }

	}

	public Item buscarItemPorNombre(String nombre)  throws IllegalArgumentException  {
		Item buscado = this.listaItems.search(nombre);
		//Item act;
		//int i = 0;
		
		if(nombre == null) {
			throw new IllegalArgumentException(NOMBRE_NO_PUEDE_SER_NULO);
		}
		
		/*while(i<this.listaItems.size() && buscado == null) {
			act = this.listaItems.search(nombre);
			if(act != null) {
				buscado = act;
			}else {
				i++;
			}
			
		}*/
		
		return buscado; 
	}

	public void agregarPlaylist(Item item)   throws IllegalArgumentException {
		
		if(item == null) {
			throw new IllegalArgumentException(ITEM_NO_PUEDE_SER_NULO);
		}
	
	
		if(this.listaItems.isEmpty() || !this.listaItems.exists(item.getNombre())) {
			throw new IllegalArgumentException(ITEM_NO_ENCONTRADO);	
		}else {
			try {
				this.playList.agregarItemReproducible(item);
				this.playList.agregarUltimosReproducidos(item);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

		}
		
	}

	@Override
	public void detener() {
		//TODO A implementar 
		System.out.println("No implementado, se detendrá la reproducción en curso.");
	}

	@Override
	public void mostrar() {
		
		for (Item item : listaItems) {
			System.out.println(item.toString());
		}
		
		System.out.println("Ultimos escuchados");
		
		this.playList.mostrar();
		
	}

	@Override
	public void reproducir() {
		Cola<Item> reprod = this.playList.getItemReproducibles();
		Item act;
		Item cent = new Cancion("@","@",-1);
		
		reprod.add(cent);
		act = reprod.remove();
		System.out.println("Reproduciendo playlist");
		while(act!=cent) {
			System.out.println(act.getNombre() + " " + act.getArtista());
			reprod.add(act);
			act = reprod.remove();
		}
		
		
		
	}

	//TODO Afregar métodos faltantes
}
