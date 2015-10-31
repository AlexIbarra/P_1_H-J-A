package jugadas;

import java.util.ArrayList;
import java.util.HashMap;

import carta.Carta;
import carta.Mano;

public class Poker implements Jugadas {

	private int numPoker;
	private int valorJugada = 8;
	private Mano mano;
	private HashMap<Character, Integer> valores;// = new Hashtable<Integer,String>()
	
	public Poker(int num){
		
		num = numPoker;
		
	}
	
	public Poker(Mano mano, int numPoker) {
		this.mano = mano;
		this.numPoker = numPoker;
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
	public int getValorJugada() {
		// TODO Auto-generated method stub
		return this.valorJugada;
	}

	@Override
	public Carta getKicker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValor() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setKicker() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		String cadena;
		cadena = this.mano.toString();
		return cadena;
	}

	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numPoker;
	}

	
}
