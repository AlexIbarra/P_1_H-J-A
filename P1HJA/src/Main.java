import java.io.IOException;
import java.util.ArrayList;

import IO.FileIn;
import carta.Carta;
import carta.Mano;
import jugadas.Jugadas;
import jugadores.Jugador;

public class Main {

	public static void main(String[] args) {

		ParserJugadas parserJ = new ParserJugadas();
		
		
		try {
			long time_start, time_end;
			time_start = System.currentTimeMillis();
			
			
			
			FileIn filein = new FileIn("src/data/entrada4.txt");
			/* Recojo las partidas que se van a ejecutar */
			ArrayList<Partida> partidas = ParserManos.parse(filein.getCartas());

			for(int k=0; k < partidas.size(); k++) {
				for(int i=0; i < partidas.get(k).getNumJugadores(); i++) {
					Jugadas jugada = parserJ.parse(partidas.get(k).getJugador(i).getMano());
					partidas.get(k).getJugador(i).setMejorJugada(jugada);
					System.out.println("La mejor jugada es: " + jugada.toString());
				}			
			}
			
			
			
			time_end = System.currentTimeMillis();
			System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
