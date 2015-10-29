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
	
	private Jugadas mejorJugada;
	private  boolean encontradoPareja = false;
	private boolean encontrdoTrio = false;
	private int Pareja;
	private int Trio;
	private int[] codigo;
	private char[] palo;

	
	public ParserJugadas() {
		
	}
	
	private void initMano(Mano mano) {
		int n = mano.getMano().size();
		this.codigo = new int[n];
		this.palo = new char[n];
		
		for(int i=0; i < n; i++) {
			this.codigo[i] = mano.getMano().get(i).getCodigo();
			this.palo[i] = mano.getMano().get(i).getPalo();
		}
	}
	
	
	
	
	public Jugadas parse(Mano mano) {
		
		initMano(mano);
		
		boolean encontrado = false;
		this.encontradoPareja = false;
		this.encontrdoTrio = false;
		
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		
		
		/* Comprobamos el poker */
		if(!esPoker(mano)) { // si no es poker
//			esTrio(mano);
			esParejasTrio(mano);
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
	
	
	
	
	
	private boolean esParejasTrio(Mano mano) {

		int i = mano.getMano().size()-1;
		boolean encontrado = false;
		
		while (i > 0) {
			
			if(this.codigo[i] == this.codigo[i-1] && this.Trio != this.codigo[i]) {
				if((i-2 >= 0) && this.codigo[i] ==  this.codigo[i-2]){
					encontrado = true;
					this.encontrdoTrio = true;
					this.Trio = this.codigo[i];
					i--;
				}else{
					encontrado = true;;
					this.encontradoPareja = true;
					this.Pareja = this.codigo[i];
				}
			}			
			i--;
			
		}
		return encontrado;
	}
	
	
	
	private boolean esDoblesParejas(Mano mano) {
		
		int i= mano.getMano().size()-1;
		boolean encontrado = false;
		boolean encontrado2 = false;
		int pareja = 0;
		
		while (i > 2 && !encontrado2){
			
			if(this.codigo[i] == this.codigo[i-1] && !encontrado){
				encontrado = true;
				pareja = this.codigo[i];
				
			}
			i--;
			if((this.codigo[i-1] == this.codigo[i-2]) && encontrado){
				encontrado2 = true;
				this.mejorJugada= new DoblePareja(mano, pareja, this.codigo[i-1]);
			}

		}	
		return encontrado2;
	}

	
	
	private boolean esTrio(Mano mano) {
			
		int i = mano.getMano().size()-1;
		boolean encontrado = false;
		
		while (i > 1 && !encontrado){
			
			if(this.codigo[i] == this.codigo[i-2]) {
				
				encontrado = true;
				this.encontrdoTrio = true;
				this.Trio = this.codigo[i];

			}	
			i--;
			
		}
		return encontrado;
	}
	
	
	
	
	private boolean esEscalera(Mano mano) {
		boolean encontrado = false;
		int i = mano.getMano().size()-1;
		while ( i > 3 && !encontrado){
			if(this.codigo[i] == this.codigo[i-1]+1 && 
					this.codigo[i-1] == this.codigo[i-2]+1 &&
							this.codigo[i-2] == this.codigo[i-3]+1 &&
									this.codigo[i-3] == this.codigo[i-4]+1) {
				
				encontrado = true;
				this.mejorJugada = new Escalera(mano, this.codigo[i]);
			}
			i--;
		}
		return encontrado;
	}
	
	
	
	private boolean esEscaleraColor(Mano mano) {
			
		 int i = mano.getMano().size() -1; 
		 boolean encontrado = false; 
		
		while ( i >= 4 && !encontrado){
		
			 if (this.codigo[i] == this.codigo[i-1] -1 && 
					 this.palo[i] == this.palo[i-1] && 
					 this.codigo[i] == this.codigo[i-2] -2 && 
							 this.palo[i] == this.palo[i-2] && 
					 this.codigo[i] == this.codigo[i-3] -3 && 
							 this.palo[i] == this.palo[i-3] && 
					 this.codigo[i] == this.codigo[i-4] -4 && 
							 this.palo[i] == this.palo[i-4]) {
				
				encontrado = true;
				this.mejorJugada = new EscaleraColor(mano, this.codigo[i]);
			}
			 i--;
		}
		return encontrado;
	}
	
	
	private boolean esPoker(Mano mano) {
		
		int i = mano.getMano().size()-1;
		boolean encontrado = false;
		
		while (i >= 3 && !encontrado) {
			
			if(this.codigo[i] == this.codigo[i-3] ){
				
				encontrado = true;
				this.mejorJugada = new Poker(mano, this.codigo[i]);
			}			
			i--;
			
		}
		return encontrado;
	}
	
	
	
	private boolean esColor(Mano mano) {
		
		boolean encontrado = false;
		int i = mano.getMano().size()-1;
		while (i >3 && !encontrado){
			if(this.palo[i] == this.palo[i-1] && 
					this.palo[i-1] == this.palo[i-2] &&
							this.palo[i-2] == this.palo[i-3] &&
									this.palo[i-3] == this.palo[i-4]) {
				
				encontrado = true;
				this.mejorJugada = new Color(mano, this.codigo[i]);
			}
			i--;
		}
		/*tenemos que ver bien como hacer la codificacion del valor de las jugadas*/
		return encontrado;
	}




}
