package ar.edu.ort.tp1.exfinal.clases;

import edu.ort.tp1.u5.tda.Cola;
import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.ColaNodos;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public class PlayList {
	private Cola<Item> itemReproducibles;
	private Pila<Item> ultimosReproducidos;
	private static final String ITEM_YA_EXISTENTE = "El item ingresado ya existe en el historico";
	
	
	public PlayList() {
		this.itemReproducibles = new ColaNodos<>();
		this.ultimosReproducidos = new PilaNodos<>();
	}

	public Cola<Item> getItemReproducibles() {
		return itemReproducibles;
	}

	private void setItemReproducibles(Cola<Item> itemReproducibles) {
		this.itemReproducibles = itemReproducibles;
	}

	public Pila<Item> getUltimosReproducidos() {
		return ultimosReproducidos;
	}

	private void setUltimosReproducidos(Pila<Item> ultimosReproducidos) {
		this.ultimosReproducidos = ultimosReproducidos;
	}
	
	public void agregarItemReproducible(Item i) {
		this.itemReproducibles.add(i);
	}
	
	public void agregarUltimosReproducidos(Item i) {
		boolean existe = false;
		Item buscado = buscarUltimosReproducidos(i);
		
		if(this.ultimosReproducidos.isEmpty() || buscado == null) {
			this.ultimosReproducidos.push(i);
			System.out.println("Item agregado correctamente");
		}else {
			existe = true;
			throw new IllegalArgumentException(ITEM_YA_EXISTENTE);
			
		}
		
	}

	private Item buscarUltimosReproducidos(Item i) {
		Pila<Item> pilaAux = new PilaNodos<>();
		Item item = null;
		
		while(!this.ultimosReproducidos.isEmpty()) {
			item = this.ultimosReproducidos.pop();
			pilaAux.push(item);
			if(i==item) {
				item = i;
			}
		}
		pasarElementos(this.ultimosReproducidos,pilaAux);
		return item;
	}
	
	private void pasarElementos(Pila<Item> ultimosReproducidos, Pila<Item> pilaAux) {
		while(!pilaAux.isEmpty()) {
			this.ultimosReproducidos.push(pilaAux.pop());
		}
	}

	public void mostrar() {
		/*Pila<Item> pilaAux = new PilaNodos<>();
		Item i = null; 
		
		while(!this.ultimosReproducidos.isEmpty()) {
			i = this.ultimosReproducidos.pop();
			pilaAux.push(i);
			System.out.println(i.toString());
		}*/
		
		//TODO A implementar 
		// Manejo de pila
		Pila<Item> aux = new PilaNodos<Item>();
		Item item = null;
		while (!this.ultimosReproducidos.isEmpty()) {
			item = this.ultimosReproducidos.pop();
			aux.push(item);
			System.out.println("- " + item);
		}
		while (!aux.isEmpty()) {
			this.ultimosReproducidos.push(aux.pop());
		}
		this.ultimosReproducidos.push(item);

	}
	
}
