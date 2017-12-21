package mains;
 
import entradasalida.excepciones.ExcepcionLectura;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.Patron;
import modelo.d1.Coordenada1D;
import modelo.d1.Regla30;
import modelo.d1.Tablero1D;
public class Main3 {

	/**
	 * @param args
	 * @throws ExcepcionJuegoVida 
	 * @throws ExcepcionExportacion 
	 * @throws ExcepcionLectura 
	 */
	public static void main(String[] args)  {
		try {
			Tablero1D tablero = new Tablero1D(43);
			Regla30 regla = new Regla30();
			Tablero1D tableroPatrong = new Tablero1D(1);
			tableroPatrong.setCelda(new Coordenada1D(0), EstadoCelda.VIVA);
			Patron<Coordenada1D> p = new Patron<Coordenada1D>("Simple", tableroPatrong);
			
			Juego<Coordenada1D> juego = new Juego<Coordenada1D>(tablero, regla);
			juego.cargaPatron(p, new Coordenada1D(22));
			for (int i=0; i<22; i++) {
				System.out.print(juego.getTablero().toString());
				juego.actualiza();
			}
		} catch (Exception e) {
			e.printStackTrace(); //NO DEBERIA DAR NUNCA
		}
	}

}
