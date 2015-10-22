package jugadas;

import java.util.ArrayList;

import carta.Carta;

public class Pareja implements Jugadas {
		
	
	private int valorJugada;
	private int numPareja;
	
	public Pareja(int num){
		num = numPareja;
	}
	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		
		int i=0;
		while (i < mano.size() - 1){
			if (mano.get(i).getNumero() == mano.get(i+1).getNumero()){
				/*Con esta asigancion sabes de que numero es la pareja*/
				numPareja = mano.get(i).getNumero();
			}
			else
				numPareja =0;
		}
		
		return new Pareja(numPareja);
	}

	@Override
	public int getPuntos() {
		// TODO Auto-generated method stub
		return valorJugada;
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

}
