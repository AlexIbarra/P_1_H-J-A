package jugadas;

import java.util.ArrayList;

import carta.Carta;
import carta.Mano;

public class FullHouse implements Jugadas {
	
	private int numTrio, numPareja;
	private Mano mano;
	private int valorJugada = 7;
	
	public FullHouse(int num, int num1) {
		// TODO Auto-generated constructor stub
//		num = trio;
//		num1 = pareja;
		
	}
	
	public FullHouse(Mano mano, int numTrio, int numPareja) {
		this.mano = mano;
		this.numTrio = numTrio;
		this.numPareja = numPareja;
	}
	
	
	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		
		int i = 0;
		boolean encontradoTrio = false;
		boolean encontradoPareja = false;
		
		while (i < mano.size() -1 && !encontradoTrio){
			
			if(mano.get(i).getNumero() == mano.get(i+1).getCodigo()
					&& mano.get(i+1).getNumero() == mano.get(i+2).getCodigo()
					&& !encontradoTrio){
				encontradoTrio = true;
				numTrio = mano.get(i).getCodigo();
			}
			i++;
			
		}
		i = 0;
		while (i < mano.size() -1 && encontradoTrio && !encontradoPareja){
			
			if(mano.get(i).getNumero() == mano.get(i+1).getCodigo()
					&& !encontradoPareja){
				encontradoPareja = true;
				numTrio = mano.get(i).getCodigo();
			}
			i++;
			
		}
		
		
		if (encontradoTrio && encontradoPareja)
			return new FullHouse(numTrio, numPareja);
		else
			return new FullHouse(0,0);
		
	}

	@Override
	public int getValorJugada() {
		// TODO Auto-generated method stub
		return this.valorJugada;
	}

	@Override
	public int getKicker(int n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setValor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setKicker(int carta) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		String cadena;
		cadena = "Full House " + this.mano.toString();
		return cadena;
	}

	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numPareja + this.numTrio*100;
	}

	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 0;
	}

}
