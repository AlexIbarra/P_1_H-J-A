package jugadas;

import java.util.ArrayList;

import carta.Carta;
import carta.Mano;

public class DoblePareja implements Jugadas {

	private int numDoble1, numDoble2; // numDoble1 es la pareja alta
	private int valorJugada = 3;
	private Mano mano;
	private Carta kicker;
	
	public DoblePareja(int num1,int num2) {
		// TODO Auto-generated constructor stub
		num1 = numDoble1;
		num2 = numDoble2;
	}
	
	public DoblePareja(Mano mano, int d1, int d2) {
		this.mano = mano;
		this.numDoble1 = d1;
		this.numDoble2 = d2;
	}
	
	
	@Override
	public int getValorJugada() {
		
		return this.valorJugada;
	}

	@Override
	public int getKicker(int n) {
		// TODO Auto-generated method stub
		return this.kicker.getKicker();
	}

	@Override
	public void setValor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		int i=0;
		boolean encontrado2 = false;
		boolean encontrado1 = false;
		numDoble1 = 0;
		numDoble2 = 0;
		
		while (i < mano.size() - 3 && !encontrado2){
			
			if ((mano.get(i).getCodigo() == mano.get(i+1).getCodigo()) && !encontrado1){
				/*Con esta asigancion sabes de que numero es la pareja*/
				numDoble1 = mano.get(i).getNumero();
				encontrado1 = true;
			}
			if ((mano.get(i+2).getCodigo() == mano.get(i+3).getCodigo()) && encontrado1){
				numDoble2 = mano.get(i).getNumero();
				encontrado2 = true;
			}
			
			i++;
		}
		
		if ( encontrado1 && encontrado2)
			return new DoblePareja(numDoble1, numDoble2);
		else 
			return new DoblePareja(0, 0);
	}

	@Override
	public void setKicker(int carta) {
		int i= this.mano.getMano().size()-1;
		while(carta != 0) {
			
			if(this.mano.getCarta(i).getKicker() != -1) {
				carta--;
				this.kicker = this.mano.getCarta(i);
			}
			i--;
		}
		
	}
	
	public String toString() {
		String cadena;
		cadena = "Dobles Parejas " + this.mano.toString();
		return cadena;
	}

	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numDoble1*100 + this.numDoble2;
	}

	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 1;
	}

}
