package mains;
import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.*;
public class Pruebas {

	public static void main(String[] args) {
		ParserTablero2D p = new ParserTablero2D();
		
		try {
			p.leeTablero("***\n***\n - ");	// Este tiene que lanzar ExcepcionLectura
		} catch (ExcepcionLectura e) {
			
			try {
			p.leeTablero("***\n**\n***");	// Este tiene que lanzar ExcepcionLectura
			e.printStackTrace(); 
			} catch(ExcepcionLectura e1) {
				
				try {
					p.leeTablero("***\n* *\n*"); // Este tiene que lanzar ExcepcionLectura
					e1.printStackTrace(); 
				} catch (ExcepcionLectura e2) {
					try {
		// Este lo tiene que pasar.
						p.leeTablero("***\n* *\n***\n");
					} catch (ExcepcionLectura e3) {
						e3.printStackTrace(); // Esto no tiene que salir.
					}	
				}
			}
		}
		
		System.out.println("TODO OK!");
		
	}

}
