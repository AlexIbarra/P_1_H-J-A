package jugadas;

import java.util.ArrayList;

import carta.Carta;

public class Poker implements Jugadas {

	private int numPoker;
	private int valorJugada;
	
	public Poker(int num){
		
		num = numPoker;
		
	}
	
	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		int i = 0;
		boolean encontrado = false;
		
		while (i < mano.size() -3 && !encontrado){
			
			if(mano.get(i).getNumero() == mano.get(i+1).getCodigo()
					&& mano.get(i+1).getNumero() == mano.get(i+2).getCodigo()
					&& mano.get(i+2).getNumero() == mano.get(i+3).getCodigo()){
				encontrado = true;
				numPoker = mano.get(i).getNumero();
			}
			else 
				numPoker = 0;
			
			i++;
			
		}
		/*En caso de que numPoker  return 0, es que no hay poker.*/ 
		return new Poker(numPoker);
	
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
