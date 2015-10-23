package jugadas;

import java.util.ArrayList;

import carta.Carta;

public class DoblePareja implements Jugadas {

	private int numDoble1, numDoble2;
	private int valorJugada;
	
	public DoblePareja(int num1,int num2) {
		// TODO Auto-generated constructor stub
		num1 = numDoble1;
		num2 = numDoble2;
	}
	@Override
	public int getPuntos() {
		
		return 0;
	}

	@Override
	public Carta getKicker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValor(int m) {
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

}
