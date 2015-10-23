package jugadas;

import java.util.ArrayList;

import carta.Carta;

public class Color implements Jugadas {

	private int numColor;
	private int valorJugada;
	
	public Color(int num){
		num = numColor;
	}
	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		int i;
		boolean encontrado = false;
		int iguales = 1;
		
		for(i = 0; i < mano.size() -1; i++){
			
			if(mano.get(i).getPalo() == mano.get(i+1).getPalo()){
				iguales++;
			}
			if (iguales == 5){
				/*Cogemos la mayor carta del color*/
				numColor = mano.get(0).getNumero();
			}
			else
				numColor = 0;
		}	
			
		return new Color(numColor);
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