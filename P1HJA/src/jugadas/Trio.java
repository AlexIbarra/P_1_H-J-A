package jugadas;

import java.util.ArrayList;

import carta.Carta;
import carta.Mano;

public class Trio implements Jugadas {
	
	private int numTrio;
	private int valorJugada = 3;
	private Mano mano;
	
	public Trio(int num){
		
		num = numTrio;
	}
	
	public Trio(Mano mano, int numTrio) {
		this.numTrio = numTrio;
		this.mano = mano;
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

	@Override
	public void setKicker() {
		// TODO Auto-generated method stub
		
	}

}
