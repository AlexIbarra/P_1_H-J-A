package jugadas;

import java.util.ArrayList;

import carta.Carta;

public class Pareja implements Jugadas {
		
	
	private int valorJugada;
	private int numPareja;
	
	public Pareja(int num){
		num = numPareja;
	}
	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		
		int i=0;
		boolean encontrado = false;
		while (i < mano.size() - 1 && !encontrado){
			if (mano.get(i).getNumero() == mano.get(i+1).getNumero()){
				/*Con esta asigancion sabes de que numero es la pareja*/
				numPareja = mano.get(i).getNumero();
				encontrado = true;
			}
			else
				numPareja =0;
			
			i++;
		}
		
		/*tenemos que ver bien como hacer la codificacion del valor de las jugadas*/
		valorJugada = numPareja-1 ; //En este caso de la pareja son iguales-1
		return new Pareja(numPareja);
	}
	
	@Override
	public int getPuntos() {
		return valorJugada;
	}
	@Override
	public Carta getKicker() {
		/*Mirar la carta mas alta de la mano y si no pertenece a la pareja devolverla?*/
		return null;
	}

	@Override
	public void setValor(int m) {
		// TODO Auto-generated method stub

	}
	public String toString(){
		String t = "Pareja de"+ numPareja;
		return t;
		
	}
}
