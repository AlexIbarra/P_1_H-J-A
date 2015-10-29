import java.io.IOException;
import java.util.ArrayList;

import IO.FileIn;
import IO.FileOut;
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
			FileOut fileout = new FileOut("src/data/salida4.txt");
			String partidaLeida;
			
			while((partidaLeida=filein.readPartida()) != null){
				
				Partida partidaJugar = ParserManos.parse(partidaLeida, filein.getNumJugadores());
				for(int i=0; i < filein.getNumJugadores(); i++) {
					Jugadas mejorJugada = parserJ.parse(partidaJugar.getJugador(i).getMano());
					partidaJugar.getJugador(i).setMejorJugada(mejorJugada);
//					System.out.println("La mejor jugada es: " + mejorJugada.toString());
					fileout.writePartida(mejorJugada.toString());
				}
			}
			
			
			
			
			time_end = System.currentTimeMillis();
			System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}