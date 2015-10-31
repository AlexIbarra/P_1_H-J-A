package jugadas;

import java.util.ArrayList;

import carta.Carta;
import carta.Mano;

public class Escalera implements Jugadas{

	private int numEscalera;
	private int valorJugada = 5;
	private Mano mano;
	
	public Escalera(Mano mano, int num){
		this.numEscalera = num;
		this.mano = mano;
	}
	
	public Escalera (int num){
		this.numEscalera = num;
	}
	
	
	
	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		int i = 0;
		boolean encontrado = false;
		
		while (i < mano.size() -4 && !encontrado){
			
			if(mano.get(i).getCodigo() == mano.get(i+1).getCodigo() + 1
					&& mano.get(i+1).getCodigo() == mano.get(i+2).getCodigo() +1
					&& mano.get(i+2).getCodigo() == mano.get(i+3).getCodigo() +1
					&& mano.get(i+3).getCodigo() == mano.get(i+4).getCodigo() +1){
				
				encontrado = true;
				numEscalera = mano.get(i).getCodigo();
			}
			else 
				numEscalera = 0;
			
			i++;
			
		}
		/*En caso de que numPoker  return 0, es que no hay poker.*/ 
		return new Escalera(numEscalera);
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

	@Override
	public int getNumJugada() {
		// TODO Auto-generated method stub
		return this.numEscalera;
	}

}
