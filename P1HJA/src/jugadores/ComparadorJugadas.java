package jugadores;

import java.util.ArrayList;

public class ComparadorJugadas {
	
	private static ArrayList<Jugador> jugadores;
	
	
	public ComparadorJugadas() {
		
	}
	
	public static String clasificacion(ArrayList<Jugador> jug, int n) {
		jugadores = jug;
		
		if(n>1)
			burbuja(n);
		
		String cadena = "";
		for(int i=n-1; i >= 0; i--) 
			cadena += jugadores.get(i).toString() + "\n";

		return cadena;		
	}

	
	private static void burbuja(int n) {
		
		Jugador jugtmp;
		
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-i-1;j++)            	  
				if(jugadores.get(j+1).getValorJugador() < jugadores.get(j).getValorJugador()){
					jugtmp = jugadores.get(j+1);
					jugadores.set(j+1, jugadores.get(j));
					jugadores.set(j, jugtmp);
				}
				else if(jugadores.get(j+1).getValorJugador() == jugadores.get(j).getValorJugador() &&
				jugadores.get(j+1).getNumJugador() == jugadores.get(j).getNumJugador()) {
					jugtmp = jugadores.get(j+1);
					jugadores.set(j+1, jugadores.get(j));
					jugadores.set(j, jugtmp);
				}
         			
	}

}
