import carta.Mano;
import jugadas.Color;
import jugadas.DoblePareja;
import jugadas.Escalera;
import jugadas.EscaleraColor;
import jugadas.FullHouse;
import jugadas.Jugadas;
import jugadas.Nada;
import jugadas.Pareja;
import jugadas.Poker;
import jugadas.Trio;

public class ParserJugadas {
	
	//private HashMap<Jugadas, Boolean> arrayJugadas;
	private Jugadas[] arrayJugadas = new Jugadas[9];
	private boolean[] arrayEstado = new boolean[9];

	
	public ParserJugadas() {
		//arrayJugadas = new HashMap<Jugadas, Boolean>();
		
		initArray();
	}
	
	
	
	
	public  Jugadas parse(Mano mano) {
		
		Jugadas mejorJugada = null;
		int i=0;
		boolean encontrado = false;
		initArray();
		
		
		/* Comprobamos si la jugada es Pareja */
		esParejas(mano);
		/* Comprobamos si la jugada es Doble Pareja */
		esDoblesParejas(mano);
		
		esPoker(mano);
		
		esTrio(mano);
		
		esEscalera(mano);
		
		esEscaleraColor(mano);
		
		esFullHouse(mano);
		
		esColor(mano);
		
		
		
		

		/* Recorremos en array en busca de la mejor jugada */
		while(i < arrayEstado.length && !encontrado) {
			if(arrayEstado[i] == true) {
				mejorJugada = arrayJugadas[i];
				encontrado = true;
			}
			i++;	
		}
		
		return mejorJugada;
	}
	
	
	
	
	private void initArray() {
	
		
		this.arrayJugadas[0] = new Nada(); // Escalera de color
		this.arrayEstado[0] = false;
		this.arrayJugadas[1] = new Nada(); // Poker
		this.arrayEstado[1] = false;
		this.arrayJugadas[2] = new Nada(); // Full
		this.arrayEstado[2] = false;
		this.arrayJugadas[3] = new Nada(); // Color
		this.arrayEstado[3] = false;
		this.arrayJugadas[4] = new Nada(); // Escalera
		this.arrayEstado[4] = false;
		this.arrayJugadas[5] = new Nada(); // Trio
		this.arrayEstado[5] = false;
		this.arrayJugadas[6] = new Nada(); // Doble pareja
		this.arrayEstado[6] = false;
		this.arrayJugadas[7] = new Nada(); // Pareja
		this.arrayEstado[7] = false;
		this.arrayJugadas[8] = new Nada(); // Carta mas alta
		this.arrayEstado[8] = false;
	}
	
	
	
	private void addArray(int pos, Jugadas jugada) {
		this.arrayJugadas[pos] = jugada;
		this.arrayEstado[pos] = true;
	}
	
	
	
	private void esParejas(Mano mano) {

		int i=0;
		boolean encontrado = false;
		
		while (i < mano.getMano().size() - 1 && !encontrado){
			if (mano.getMano().get(i).getNumero() == mano.getMano().get(i+1).getNumero()){
				/*Con esta asigancion sabes de que numero es la pareja*/
//				jugada = new Pareja(mano);
				encontrado = true;
				addArray(7, new Pareja(mano));
			}
			i++;
		}
		
		/*tenemos que ver bien como hacer la codificacion del valor de las jugadas*/
//		return jugada;
	}
	
	
	
	private void esDoblesParejas(Mano mano) {
		
		int i=0;
		boolean encontrado = false;
		
		while (i < mano.getMano().size() - 1 && !encontrado){
			
			if (mano.getMano().get(i).getCodigo() == mano.getMano().get(i+1).getCodigo()){
				
				if ((i+4 <= mano.getMano().size() - 1) && mano.getMano().get(i+3).getCodigo() == mano.getMano().get(i+4).getCodigo() &&
				mano.getMano().get(i+3).getCodigo() != mano.getMano().get(i).getCodigo()){

					encontrado = true;
					addArray(6, new DoblePareja(mano));
					
				} else if ((i+3 <= mano.getMano().size() - 1) && mano.getMano().get(i+2).getCodigo() == mano.getMano().get(i+3).getCodigo() &&
				mano.getMano().get(i+2).getCodigo() != mano.getMano().get(i).getCodigo()){

					encontrado = true;
					addArray(6, new DoblePareja(mano));
				}
			}
			
			i++;
		}	
	}

	
	
	private void esTrio(Mano mano) {
			
		int i = 0;
		boolean encontrado = false;
		
		while (i < mano.getMano().size() - 2 && !encontrado){
			
			if(mano.getMano().get(i).getNumero() == mano.getMano().get(i+1).getNumero() &&
			mano.getMano().get(i+1).getNumero() == mano.getMano().get(i+2).getNumero()) {
				
				encontrado = true;
//				jugada = new Trio(mano);
				addArray(5, new Trio(mano));
			}	
			i++;
			
		}
//		return encontrado;
	}
	
	
	
	private void esFullHouse(Mano mano) {
		
		if(arrayEstado[5] == true && arrayEstado[7] == true && arrayEstado[1] == false) {
			addArray(2, new FullHouse(mano));
		}
	}
	
	
	
	private void esEscalera(Mano mano) {
		
		if(mano.getMano().get(0).getCodigo() < mano.getMano().get(1).getCodigo() && 
		mano.getMano().get(1).getCodigo() < mano.getMano().get(2).getCodigo() &&
		mano.getMano().get(2).getCodigo() < mano.getMano().get(3).getCodigo() &&
		mano.getMano().get(3).getCodigo() < mano.getMano().get(4).getCodigo()) {
			
			addArray(4, new Escalera(mano));
		}	
		
	}
	
	
	
	private void esEscaleraColor(Mano mano) {
			
		if(mano.getMano().get(0).getCodigo() < mano.getMano().get(1).getCodigo() && 
		mano.getMano().get(1).getCodigo() < mano.getMano().get(2).getCodigo() &&
		mano.getMano().get(2).getCodigo() < mano.getMano().get(3).getCodigo() &&
		mano.getMano().get(3).getCodigo() < mano.getMano().get(4).getCodigo() && esColor(mano)) {
			
			addArray(0, new EscaleraColor(mano));
		}	

	}
	
	
	private void esPoker(Mano mano) {
		
		int i=0;
		boolean encontrado = false;
		
		while (i < mano.getMano().size() - 3 && !encontrado){
			
			if(mano.getMano().get(i).getCodigo() == mano.getMano().get(i+1).getCodigo() &&
			mano.getMano().get(i+1).getCodigo() == mano.getMano().get(i+2).getCodigo() &&
			mano.getMano().get(i+2).getCodigo() == mano.getMano().get(i+3).getCodigo()){
				encontrado = true;
				addArray(1, new Poker(mano));
			}			
			i++;
			
		}
	}
	
	
	
	private boolean esColor(Mano mano) {
		
		boolean encontrado = false;
		
		if(mano.getMano().get(0).getPalo() <= mano.getMano().get(1).getPalo() && 
		mano.getMano().get(1).getPalo() <= mano.getMano().get(2).getPalo() &&
		mano.getMano().get(2).getPalo() <= mano.getMano().get(3).getPalo() &&
		mano.getMano().get(3).getPalo() <= mano.getMano().get(4).getPalo()) {
				
			encontrado = true;
			addArray(3, new Color(mano));
		}
		
		/*tenemos que ver bien como hacer la codificacion del valor de las jugadas*/
		return encontrado;
	}




}
