package jugadas;

import java.util.ArrayList;

import carta.Carta;

public class Trio implements Jugadas {
	
	private int numTrio;
	private int valorJugada;
	
	public Trio(int num){
		
		num = numTrio;
	}

	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		int i = 0;
		boolean encontrado = false;
		
		while (i < mano.size() -2 && !encontrado){
			
			if(mano.get(i).getNumero() == mano.get(i+1).getCodigo()
					&& mano.get(i+1).getNumero() == mano.get(i+2).getCodigo()){
				encontrado = true;
				numTrio = mano.get(i).getNumero();
			}
			else 
				numTrio = 0;
			
			i++;
			
		}
		return new Trio(numTrio);
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
