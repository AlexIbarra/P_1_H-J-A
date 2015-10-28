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
	private Jugadas mejorJugada;
	private  boolean encontradoPareja = false;
	private boolean encontrdoTrio = false;
	private int Pareja;
	private int Trio;

	
	public ParserJugadas() {
		//arrayJugadas = new HashMap<Jugadas, Boolean>();
		
		initArray();
	}
	
	
	
	
	public Jugadas parse(Mano mano) {
		
		boolean encontrado = false;
		
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		
		
		/* Comprobamos el poker */
		if(!esPoker(mano)) { // si no es poker
			esParejas(mano);
			esTrio(mano);
			if(this.encontradoPareja && this.encontrdoTrio && (this.Trio != this.Pareja)){
				this.mejorJugada = new FullHouse(mano, this.Trio, this.Pareja);
			}else if(!esEscaleraColor(mano)){
				if(!esColor(mano)){
					
					if(!esEscalera(mano)){
						if(encontrdoTrio){
							this.mejorJugada = new Trio(mano, this.Trio);
						}else if(!esDoblesParejas(mano)){
							if(encontradoPareja){
								this.mejorJugada = new Pareja(mano, this.Pareja);
							}else{
								this.mejorJugada = new Nada();
							}
						}
							
					}
				}
			}
			
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
	
	
	
	private boolean esParejas(Mano mano) {

		int i = mano.getMano().size()-1;
		boolean encontrado = false;
		
		while (i > 0 && !encontrado) {
			
			if(mano.getMano().get(i).getCodigo() == mano.getMano().get(i-1).getCodigo() ){
				
				encontrado = true;
				//this.mejorJugada = new Pareja(mano, mano.getMano().get(i).getCodigo());
				this.encontradoPareja = true;
				this.Pareja = mano.getMano().get(i).getCodigo();
			}			
			i--;
			
		}
		return encontrado;
	}
	
	
	
	private boolean esDoblesParejas(Mano mano) {
		
		int i=mano.getMano().size()-1;
		boolean encontrado = false;
		boolean encontrado2 = false;
		int pareja = 0;
		
		while (i >0 && !encontrado2){
			
			if(mano.getMano().get(i).getCodigo() == mano.getMano().get(i-1).getCodigo() && !encontrado){
				encontrado = true;
				pareja = mano.getMano().get(i).getCodigo();
				
			}
			i--;
			if((mano.getMano().get(i-1).getCodigo() == mano.getMano().get(i-2).getCodigo()) && encontrado){
				encontrado2 = true;
				this.mejorJugada= new DoblePareja(mano, pareja, mano.getMano().get(i-1).getCodigo());
			}

		}	
		return encontrado2;
	}

	
	
	private boolean esTrio(Mano mano) {
			
		int i = mano.getMano().size()-1;
		boolean encontrado = false;
		
		while (i > 1 && !encontrado){
			
			if(mano.getMano().get(i).getNumero() == mano.getMano().get(i-2).getNumero()) {
				
				encontrado = true;
				//this.mejorJugada = new Trio(mano, mano.getMano().get(i).getNumero());
				this.encontrdoTrio = true;
				this.Trio = mano.getMano().get(i).getNumero();

			}	
			i--;
			
		}
		return encontrado;
	}
	
	
	
	private boolean esFullHouse(Mano mano) {
		
		boolean full = false;
		boolean pareja = false;
		boolean trio = false;
		boolean doblesparejas = false;		
		boolean encontrado = full || pareja || trio || doblesparejas;
		int i=0;
		
		while (i < mano.getMano().size() && !encontrado){
			
			
			/* Comprobamos PAREJAS */
			if ((i+1 < mano.getMano().size()) && mano.getMano().get(i).getNumero() == mano.getMano().get(i+1).getNumero()){
				
				/* Comprobamos TRIO (pertenece a la pareja) */
				if((i+2 < mano.getMano().size()) && mano.getMano().get(i).getNumero() == mano.getMano().get(i+1).getNumero() &&
				mano.getMano().get(i+1).getNumero() == mano.getMano().get(i+2).getNumero()) {
					
					/* Comprobamos FULLHOUSE (otra pareja mas)*/
					if((i+4 < mano.getMano().size()) && mano.getMano().get(i+3).getNumero() == mano.getMano().get(i+4).getNumero()) {
						full = true;
						this.mejorJugada = new FullHouse(mano, mano.getMano().get(i).getNumero(), mano.getMano().get(i+3).getNumero());
					}
					
					trio = true;
					this.mejorJugada = new Trio(mano, mano.getMano().get(i).getNumero());
				}
				/* Comprobamos TRIO (no pertenece a la pareja) = FULLHOUSE */
				else if((i+4 < mano.getMano().size()) && mano.getMano().get(i+2).getNumero() == mano.getMano().get(i+3).getNumero() &&
				mano.getMano().get(i+3).getNumero() == mano.getMano().get(i+4).getNumero()) {
					
					full = true;
					this.mejorJugada = new FullHouse(mano, mano.getMano().get(i).getNumero(), mano.getMano().get(i+3).getNumero());
				}
				/* Comprobamos las DOBLES PAREJAS*/
				else if((i+4 < mano.getMano().size()) && mano.getMano().get(i+2).getNumero() == mano.getMano().get(i+3).getNumero() ||
				mano.getMano().get(i+3).getNumero() == mano.getMano().get(i+4).getNumero()) {
					
					doblesparejas = true;
					this.mejorJugada = new DoblePareja(mano, mano.getMano().get(i+3).getNumero(), mano.getMano().get(i).getNumero());
				}
				/* Si no se cumple nada de lo anterior, son PAREJAS */
				else {
					pareja = true;
					this.mejorJugada = new Pareja(mano, mano.getMano().get(i).getNumero());
				}
			}
			i++;
		}
		
		return encontrado = full || pareja || trio || doblesparejas;

	}
	
	
	
	private boolean esEscalera(Mano mano) {
		boolean encontrado = false;
		int i = mano.getMano().size();
		while ( i > 3 && !encontrado){
			if(mano.getMano().get(i).getCodigo() == mano.getMano().get(i-1).getCodigo() && 
			mano.getMano().get(i-1).getCodigo() == mano.getMano().get(i-2).getCodigo() &&
			mano.getMano().get(i-2).getCodigo() == mano.getMano().get(i-3).getCodigo() &&
			mano.getMano().get(i-3).getCodigo() == mano.getMano().get(i-4).getCodigo()) {
				
				encontrado = true;
				this.mejorJugada = new Escalera(mano, mano.getMano().get(i).getCodigo());
			}	
		}
		return encontrado;
	}
	
	
	
	private boolean esEscaleraColor(Mano mano) {
			
//		if(mano.getMano().get(0).getCodigo() < mano.getMano().get(1).getCodigo() && 
//		mano.getMano().get(1).getCodigo() < mano.getMano().get(2).getCodigo() &&
//		mano.getMano().get(2).getCodigo() < mano.getMano().get(3).getCodigo() &&
//		mano.getMano().get(3).getCodigo() < mano.getMano().get(4).getCodigo() && esColor(mano)) {
		 int i = mano.getMano().size() -1; 
		 boolean encontrado = false; 
		
		while ( i >= 4 && !encontrado){
		
			 if (mano.getMano().get(i).getCodigo() == mano.getMano().get(i-1).getCodigo() -1 && 
			 mano.getMano().get(i).getPalo() == mano.getMano().get(i-1).getPalo() && 
			 mano.getMano().get(i).getCodigo() == mano.getMano().get(i-2).getCodigo() -2 && 
			 mano.getMano().get(i).getPalo() == mano.getMano().get(i-2).getPalo() && 
			 mano.getMano().get(i).getCodigo() == mano.getMano().get(i-3).getCodigo() -3 && 
			 mano.getMano().get(i).getPalo() == mano.getMano().get(i-3).getPalo() && 
			 mano.getMano().get(i).getCodigo() == mano.getMano().get(i-4).getCodigo() -4 && 
			 mano.getMano().get(i).getPalo() == mano.getMano().get(i-4).getPalo()) {
				
				encontrado = true;
				this.mejorJugada = new EscaleraColor(mano, mano.getMano().get(i).getCodigo());
			}
			 i--;
		}
		return encontrado;
	}
	
	
	private boolean esPoker(Mano mano) {
		
		int i = mano.getMano().size()-1;
		boolean encontrado = false;
		
		while (i >= 3 && !encontrado) {
			
			if(mano.getMano().get(i).getCodigo() == mano.getMano().get(i-3).getCodigo() ){
				
				encontrado = true;
				this.mejorJugada = new Poker(mano, mano.getMano().get(i).getCodigo());
			}			
			i--;
			
		}
		return encontrado;
	}
	
	
	
	private boolean esColor(Mano mano) {
		
		boolean encontrado = false;
		int i = mano.getMano().size()-1;
		while (i >3 && !encontrado){
			if(mano.getMano().get(i).getPalo() == mano.getMano().get(i-1).getPalo() && 
			mano.getMano().get(i-1).getPalo() == mano.getMano().get(i-2).getPalo() &&
			mano.getMano().get(i -2).getPalo() == mano.getMano().get(i-3).getPalo() &&
			mano.getMano().get(i-3).getPalo() == mano.getMano().get(i-4).getPalo()) {
				
				encontrado = true;
				this.mejorJugada = new Color(mano, mano.getMano().get(i).getCodigo());
			}
			i--;
		}
		/*tenemos que ver bien como hacer la codificacion del valor de las jugadas*/
		return encontrado;
	}




}
