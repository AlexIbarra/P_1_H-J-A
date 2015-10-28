package jugadas;

import java.util.ArrayList;

import carta.Carta;
import carta.Mano;

public class EscaleraColor implements Jugadas{
	
	private Mano mano;
	private int codigo;
	private int valorJugada = 8;
	
	public EscaleraColor(Mano mano, int numEscalera) {
		this.mano = mano;
		this.codigo = numEscalera;
	}
	
	

	
	
	
	
	private void setCodigo() {
		
		this.codigo = 0;
		
		for(int i=0; i < mano.getMano().size() - 1; i++) {
			this.codigo += this.mano.getMano().get(i).getNumero();
		}
	}
	
	
	
	
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
	public Carta getKicker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValor(int m) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setKicker() {
		// TODO Auto-generated method stub
		
	}

}
