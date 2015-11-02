package jugadas;

import java.util.ArrayList;

import carta.Carta;
import carta.Mano;

public class Trio implements Jugadas {
	
	private int numTrio;
	private int valorJugada = 4;
	private Mano mano;
	private Carta[] kicker;
	
	public Trio(int num){
		
		num = numTrio;
	}
	
	public Trio(Mano mano, int numTrio) {
		this.numTrio = numTrio;
		this.mano = mano;
		this.kicker = new Carta[2];
	}
	
	

	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		int i = 0;
		boolean encontrado = false;
		
		while (i < mano.size() -2 && !encontrado){
			
			if(mano.get(i).getNumero() == mano.get(i+1).getCodigo()
					&& mano.get(i+1).getNumero() == mano.get(i+2).getCodigo()){
				encontrado = true;
				numTrio = mano.get(i).getNumero();
			}
			else 
				numTrio = 0;
			
			i++;
			
		}
		return new Trio(numTrio);
	}

	@Override
	public int getValorJugada() {
		// TODO Auto-generated method stub
		return valorJugada;
	}

	@Override
	public int getKicker(int n) {
		// TODO Auto-generated method stub
		return this.kicker[n].getKicker();
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
				this.kicker[carta] = this.mano.getCarta(i);
			}
			i--;
		}
		
	}
	
	public String toString() {
		String cadena;
		cadena = "Trio " + this.mano.toString();
		return cadena;
	}

	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numTrio;
	}

	@Override
	public int numKickers() {
		// TODO Auto-generated method stub
		return 2;
	}

}
