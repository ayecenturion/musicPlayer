package ar.edu.ort.tp1.exfinal.clases;

import edu.ort.tp1.u5.tda.nodos.ListaOrdenadaNodos;

public class ListaPorNombre extends ListaOrdenadaNodos<String, Item>{

	@Override
	public double compare(Item i1, Item i2) {
		return i1.getNombre().compareTo(i2.getNombre());
	}

	@Override
	public int compareByKey(String clave, Item i) {
		return clave.compareTo(i.getNombre());
	}
	
}
