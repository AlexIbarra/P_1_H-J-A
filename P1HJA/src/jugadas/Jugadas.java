package jugadas;

import java.util.ArrayList;

import carta.Carta;

public interface Jugadas {

		
		
		/* obtienes el valor de la jugada*/
		public Jugadas getJugada(ArrayList<Carta> mano);
		
		/*Obtiene la suma de puntos de la jugada*/
		public int getPuntos();
		
		public void setKicker();		
		
		public Carta getKicker();
		
		public void setValor(int m);
		
}
