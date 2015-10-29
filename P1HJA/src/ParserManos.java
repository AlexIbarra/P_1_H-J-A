import java.util.ArrayList;

import carta.Carta;
import carta.Mano;
import jugadores.Jugador;

public class ParserManos {
	
	
	public static ArrayList <Partida> parse(String s) {
		
		ArrayList <Partida> arrayPartidas = new ArrayList<Partida>();
		int i=0, j=-2;
		String[] array = s.split("\n");	
		char[] token;
		String[] arrayAux;
		String cadena=null;
		int limit, numjugadores=0, numcartas=0;
		boolean caso2 = false, caso3 = false;
		
		do {
			
			/* Creo una nueva partida */
			arrayPartidas.add(new Partida());
			
			/* Tipo entrada3 */
			if(array[0].length() == 40) {
				j=0;
				arrayAux = array[i].split(";");
				numjugadores = Integer.parseInt(arrayAux[0]); // numero de jugadores de la mano
				cadena = arrayAux[1] + arrayAux[2] + arrayAux[3] + arrayAux[4] + arrayAux[5];
				caso3 = true;
				token = cadena.toCharArray();
			}
			/* Tipo entrada2 */
			else if(array[0].length() >= 13 && array[0].length() < 18) {
				j=-2;
				arrayAux = array[i].split(";");
				numcartas = Integer.parseInt(arrayAux[1]); // numero de cartas de la mano
				if(numcartas > 3)
					caso2 = true;
				cadena = arrayAux[0] + arrayAux[2];
				numjugadores = 1;
				token = cadena.toCharArray();
			}
			else {
				j=-2;
				token = array[0].toCharArray();
				numjugadores = 1;
			}
				
			
			for(int k=0; k < numjugadores; k++) {
				
				limit = token.length;
			
				Jugador jugador = new Jugador(new Mano());
				
				jugador.getMano().setMano(new Carta(token[j+2], token[j+3]));
				jugador.getMano().setMano(new Carta(token[j+4], token[j+5]));
				jugador.getMano().setMano(new Carta(token[limit-2], token[limit-1]));
				jugador.getMano().setMano(new Carta(token[limit-4], token[limit-3]));
				jugador.getMano().setMano(new Carta(token[limit-6], token[limit-5]));
				
				if(caso2 || caso3) {
					jugador.getMano().setMano(new Carta(token[limit-10], token[limit-9]));
					jugador.getMano().setMano(new Carta(token[limit-8], token[limit-7]));
				}
				
				
				limit = jugador.getMano().getMano().size()-1;
				
				/* Ordenamos la mano pasandole los rangos del array de manos */
				jugador.getMano().ordenaMano(0, limit);
				
				if(caso3)
					j+=6;
				
				/* Añado los jugadores de cada partida */
				arrayPartidas.get(i).addJugador(jugador);
			}			
			i++;
			
			 
		} while(i < array.length);
		
		return arrayPartidas;
		
	}

}
