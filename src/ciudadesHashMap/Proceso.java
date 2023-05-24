package ciudadesHashMap;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Proceso {
	
	ArrayList<String> listCiudadesTot = new ArrayList<String>();
	ModeloDatos datos = new ModeloDatos();
	
	public Proceso() {
		iniciar();
	}
	
	private void iniciar() {
		String menu="Informacion del sistema Daniela\n";
		menu+="1. Ingresar un pais con sus ciudades\n";
		menu+="2. Imprimir HashMap\n";
		menu+="3. Consultar pais\n";
		menu+="4. Consultar ciudad\n";
		menu+="5. Salir\n";
		menu+="Ingrese una opción:\n";
		int opc=0;
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			validarDatos(opc);
			
		} while (opc!=5);
	}
		
	public void validarDatos(int opc) {
		switch (opc) {
		case 1:
			ingresarDatos();
			break;
		case 2:
			imprimirDatos();
			break;
		case 3:
			BuscarPais();
			break;
		case 4:
			String ciudad = JOptionPane.showInputDialog("Ingrese la ciudad que desea buscar");
			buscarCiudades(ciudad);
			break;

		default:
			break;
		}
	}
	private void BuscarPais() {
		String pais=JOptionPane.showInputDialog("Ingrese el pais que desea buscar");
		if (datos.getMapaPais().containsKey(pais)) {
				System.out.println("El pais si fue registrado: "+pais);
		}
	}
	public void buscarCiudades(String ciudad) {
		datos.consultarCiudad(ciudad);
	}
	public void imprimirDatos() {	
		//System.out.println(datos.getMapaPais());
		datos.imprimirMapa();
	}
	private void ingresarDatos() {
		String pais, ciudades,preg;
		ArrayList<String> listCiudades = new ArrayList<String>();
		pais=JOptionPane.showInputDialog("Ingrese el pais");
		
		do {
			ciudades=JOptionPane.showInputDialog("Ingrese las ciudades del pais correspondiente");
			listCiudades.add(ciudades);
			preg=JOptionPane.showInputDialog("¿Desea ingresar otra ciudad?");
		} while (preg.equalsIgnoreCase("si"));
		
		datos.guardarPaisCiudad(pais, listCiudades);
		System.out.println(listCiudades);
	}
	
}
