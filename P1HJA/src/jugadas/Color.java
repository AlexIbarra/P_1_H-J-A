package jugadas;

import java.util.ArrayList;

import carta.Carta;
import carta.Mano;

public class Color implements Jugadas {

	private int numColor;
	private int valorJugada = 6;
	private Mano mano;
	
	public Color(int num){
		num = numColor;
	}
	
	
	public Color(Mano mano, int numColor) {
		this.mano = mano;
		this.numColor = numColor;
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
		this.valorJugada *= this.numColor;
	}


	@Override
	public void setKicker() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numColor;
	}

}
