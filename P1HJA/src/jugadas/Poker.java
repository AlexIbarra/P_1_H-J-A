package jugadas;

import java.util.ArrayList;
import java.util.HashMap;

import carta.Carta;
import carta.Mano;

public class Poker implements Jugadas {

	private int numPoker;
	private int valorJugada = 8;
	private Mano mano;
	private char[] cartas;
	private Carta kicker;
	
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
	public int getKicker(int n) {
		// TODO Auto-generated method stub
		return this.kicker.getKicker();
	}

	@Override
	public void setValor() {
		// TODO Auto-generated method stub
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
		cadena = "Poker " + this.mano.toString();
		return cadena;
	}

	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numPoker;
	}

	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 1;
	}

	
}
