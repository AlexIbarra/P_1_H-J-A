package jugadas;

import java.util.ArrayList;

import carta.Carta;

public class Escalera implements Jugadas{

	private int numEscalera;
	private int valorJugada;
	
	public Escalera(int num){
		num = numEscalera;
	}
	
	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		int i = 0;
		boolean encontrado = false;
		
		while (i < mano.size() -4 && !encontrado){
			
			if(mano.get(i).getNumero() == mano.get(i+1).getCodigo() -1
					&& mano.get(i+1).getNumero() == mano.get(i+2).getCodigo() -1
					&& mano.get(i+2).getNumero() == mano.get(i+3).getCodigo() -1
					&& mano.get(i+3).getNumero() == mano.get(i+4).getCodigo() -1){
				
				encontrado = true;
				numEscalera = mano.get(i).getNumero();
			}
			else 
				numEscalera = 0;
			
			i++;
			
		}
		/*En caso de que numPoker  return 0, es que no hay poker.*/ 
		return new Escalera(numEscalera);
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
