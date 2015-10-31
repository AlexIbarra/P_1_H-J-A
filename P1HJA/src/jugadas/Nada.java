package jugadas;

import java.util.ArrayList;

import carta.Carta;

public class Nada implements Jugadas {
	
	private int valorJugada = 1;
	private int numNada;
	
	public Nada(int n) {
		this.numNada = n;
	}
	

	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getValorJugada() {
		// TODO Auto-generated method stub
		return this.valorJugada;
	}

	@Override
	public void setKicker() {
		// TODO Auto-generated method stub
		
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
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numNada;
	}

}
