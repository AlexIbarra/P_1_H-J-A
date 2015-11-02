package jugadas;

import java.util.ArrayList;

import carta.Carta;
import carta.Mano;

public class Color implements Jugadas {

	private int numColor;
	private int valorJugada = 6;
	private Mano mano;
	private Carta[] kicker;
	
	public Color(int num){
		num = numColor;
	}
	
	
	public Color(Mano mano, int numColor) {
		this.mano = mano;
		this.numColor = numColor;
		this.kicker = new Carta[5];
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
	public int getKicker(int n) {
		// TODO Auto-generated method stub
		return this.kicker[n].getKicker();
	}

	@Override
	public void setValor() {
		// TODO Auto-generated method stub
		this.valorJugada *= this.numColor;
	}


	@Override
	public void setKicker(int carta) {
		
		int i= this.mano.getMano().size()-1;
		while(carta != 0) {
			
			if(this.mano.getCarta(i).getKicker() != -1) {
				carta--;
				this.kicker[carta] = this.mano.getCarta(i);
			}
			i--;
		}
		
	}
	
	public String toString() {
		String cadena;
		cadena = "Color " + this.mano.toString();
		return cadena;
	}


	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numColor;
	}


	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 5;
	}

}
