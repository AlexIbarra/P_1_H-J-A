package jugadas;

import java.util.ArrayList;

import carta.Carta;
import carta.Mano;

public class Pareja implements Jugadas {
		
	private Mano mano;
	private int valorJugada = 2;
	private int numPareja;
	private Carta[] kicker;
	
//	public Pareja(int num){
//		num = numPareja;
//	}
	
	public Pareja(Mano mano, int numPareja) {
		this.mano = mano;
		this.numPareja = numPareja;
		this.kicker = new Carta[3];
	}
	
	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		
		int i=0;
		boolean encontrado = false;
		while (i < mano.size() - 1 && !encontrado){
			if (mano.get(i).getNumero() == mano.get(i+1).getNumero()){
				/*Con esta asigancion sabes de que numero es la pareja*/
				numPareja = mano.get(i).getNumero();
				encontrado = true;
			}
			else
				numPareja =0;
			
			i++;
		}
		
		/*tenemos que ver bien como hacer la codificacion del valor de las jugadas*/
		valorJugada = numPareja-1 ; //En este caso de la pareja son iguales-1
		return null;
	}
	
	@Override
	public int getValorJugada() {
		return valorJugada;
	}
	
	@Override
	public int getKicker(int n) {
		/*Mirar la carta mas alta de la mano y si no pertenece a la pareja devolverla?*/
		return this.kicker[n].getKicker();
	}

	@Override
	public void setValor() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString(){
		return "Pareja " + this.mano.toString();	
	}

	/* Metodo encargado de buscar y asignar el kicker */
	@Override
	public void setKicker(int carta) {
		int i= this.mano.getMano().size()-1;
		while(carta != 0) {
			
			if(this.mano.getCarta(i).getKicker() != -1) {
				carta--;
				this.kicker[carta] = this.mano.getCarta(i);
			}
			i--;
		}
		
	}
	

	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numPareja;
	}

	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 3;
	}
}
