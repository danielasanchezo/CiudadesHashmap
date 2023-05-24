package ciudadesHashMap;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import java.util.Iterator;

public class ModeloDatos {
	
	HashMap<String, ArrayList<String>> mapPais;
	
	public ModeloDatos() {
		mapPais=new HashMap<String, ArrayList<String>>();
		
	}
	
	public void consultarPais(String pais) {
		
		if (mapPais.containsKey(pais)) {
			
			System.out.println(mapPais.get(pais));
			
		}else {

			JOptionPane.showMessageDialog(null, "Pais no existe",
					"Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public void consultarCiudad(String ciudad) {
		
		Iterator<String> itera = mapPais.keySet().iterator();
		String llave;
		while (itera.hasNext()) {
			llave =itera.next();
			ArrayList<String> valor = mapPais.get(llave);
			
			if (valor.contains(ciudad)) {
				System.out.println("Se encontro la ciudad en el pais: " + llave);
			}
		}
	}
	
	public HashMap<String, ArrayList<String>> getMapaPais(){
		return mapPais;
	}
	
	public void guardarPaisCiudad(String pais ,ArrayList<String> listaPaisCiudad) {
		mapPais.put(pais, listaPaisCiudad);
		JOptionPane.showMessageDialog(null, "Registro existoso!");
	}
	
	public void imprimirMapa() {
		Iterator<String> itera=mapPais.keySet().iterator();
		String llave;
		while (itera.hasNext()) {
			llave =itera.next();
			System.out.println(llave + " - "+mapPais.get(llave));
		}
	}
}
