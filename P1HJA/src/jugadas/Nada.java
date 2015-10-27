package jugadas;

import java.util.ArrayList;

import carta.Carta;

public class Nada implements Jugadas {
	
	private int valorJugada = 0;
	
	public Nada() {}
	

	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPuntos() {
		// TODO Auto-generated method stub
		return 0;
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
	public void setValor(int m) {
		// TODO Auto-generated method stub
		
	}

}
