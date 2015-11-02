package jugadas;

import java.util.ArrayList;

import carta.Carta;

public interface Jugadas {

		
		
		/* obtienes el valor de la jugada*/
		public Jugadas getJugada(ArrayList<Carta> mano);
		
		/*Obtiene la suma de puntos de la jugada*/
		public int getValorJugada();
		
		public void setKicker(int carta);		
		
		public int getKicker(int n);
		
		public int numKickers();
		
		public void setValor();
		
		public int getNumJugada();
		
}
