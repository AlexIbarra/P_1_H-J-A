import java.util.HashMap;

import carta.Carta;
import carta.Mano;
import jugadas.Color;
import jugadas.DoblePareja;
import jugadas.Escalera;
import jugadas.EscaleraColor;
import jugadas.FullHouse;
import jugadas.Jugadas;
import jugadas.Pareja;
import jugadas.Poker;
import jugadas.Trio;

public class ParserJugadas {
	
	private HashMap<Jugadas, Boolean> jugadas;
	
	
	
	
	public static Jugadas parse(Mano mano) {
		
		Jugadas jugada = null;
		
		
		/* Comprobamos si la jugada es Parejas o Dobleas Parejas */

		
		
		

		
		
		return (Jugadas) new Object();
		
	}
	
	
	private static boolean esParejas(Mano mano, Jugadas jugada) {

		int i=0;
		boolean encontrado = false;
		
		while (i < mano.getMano().size() - 1 && !encontrado){
			if (mano.getMano().get(i).getNumero() == mano.getMano().get(i+1).getNumero()){
				/*Con esta asigancion sabes de que numero es la pareja*/
				jugada = new Pareja(mano);
				encontrado = true;
			}
			i++;
		}
		
		/*tenemos que ver bien como hacer la codificacion del valor de las jugadas*/
		return encontrado;
	}
	
	
	
	private boolean esDoblesParejas(Mano mano, Jugadas jugada) {
		
		int i=0;
		boolean encontrado = false;
		
		while (i < mano.getMano().size() - 1 && !encontrado){
			
			if (mano.getMano().get(i).getNumero() == mano.getMano().get(i+1).getNumero() && 
				mano.getMano().get(i+1).getNumero() == mano.getMano().get(i+2).getNumero()){
				/*Con esta asigancion sabes de que numero es la pareja*/
				jugada = new DoblePareja(mano);
				encontrado = true;
			}
			i++;
		}
		return encontrado;		
	}

	
	
	private boolean esTrio(Mano mano, Jugadas jugada) {
			
		int i = 0;
		boolean encontrado = false;
		
		while (i < mano.getMano().size() - 2 && !encontrado){
			
			if(mano.getMano().get(i).getNumero() == mano.getMano().get(i+1).getNumero() &&
			mano.getMano().get(i+1).getNumero() == mano.getMano().get(i+2).getNumero()){
				encontrado = true;
				jugada = new Trio(mano);
			}	
			i++;
			
		}
		return encontrado;
	}
	
	
	
	private boolean esFullHouse(Mano mano, Jugadas jugada) {
		
		boolean encontrado = false;
		
		if(esParejas(mano, jugada) && esTrio(mano, jugada)) {
			encontrado = true;
			jugada = new FullHouse(mano);
		}
		return encontrado;
	}
	
	
	
	private boolean esEscalera(Mano mano, Jugadas jugada) {
		
		boolean encontrado = false;
		int i=0;
		
		while (i < mano.getMano().size() - 1 && !encontrado){
			
			if(mano.getMano().get(i).getNumero() >= mano.getMano().get(i+1).getNumero()){
				encontrado = true;
				if(esColor(mano, jugada))
					jugada = new EscaleraColor(mano);
				else
					jugada = new Escalera(mano);
			}	
			i++;
			
		}
		
		return encontrado;
	}
	
	
	
	private boolean esPoker(Mano mano, Jugadas jugada) {
		
		int i = 0;
		boolean encontrado = false;
		
		while (i < mano.getMano().size() - 3 && !encontrado){
			
			if(mano.getMano().get(i).getNumero() == mano.getMano().get(i+1).getNumero() && 
			mano.getMano().get(i+1).getNumero() == mano.getMano().get(i+2).getNumero() &&
			mano.getMano().get(i+2).getNumero() == mano.getMano().get(i+3).getNumero()) {
				
				encontrado = true;
				jugada = new Poker(mano);
			}
			
			i++;
			
		}
		/*En caso de que numPoker  return 0, es que no hay poker.*/ 
		return encontrado;
	}
	
	
	
	private boolean esColor(Mano mano, Jugadas jugada) {
		
		int i=0;
		boolean encontrado = false;
		
		while (i < mano.getMano().size() - 1 && !encontrado){
			if (mano.getMano().get(i).getPalo() == mano.getMano().get(i+1).getPalo()){
				/*Con esta asigancion sabes de que numero es la pareja*/
				jugada = new Color(mano);
				encontrado = true;
			}
			i++;
		}
		
		/*tenemos que ver bien como hacer la codificacion del valor de las jugadas*/
		return encontrado;
	}




}
