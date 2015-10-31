package jugadas;

import java.util.ArrayList;

import carta.Carta;
import carta.Mano;

public class EscaleraColor implements Jugadas{
	
	private Mano mano;
	private int numEscaleraColor;
	private int valorJugada = 9;
	
	public EscaleraColor(Mano mano, int numEscalera) {
		this.mano = mano;
		this.numEscaleraColor = numEscalera;
	}
	
	

	
	
	
	
	private void setCodigo() {
		
		this.numEscaleraColor = 0;
		
		for(int i=0; i < mano.getMano().size() - 1; i++) {
			this.numEscaleraColor += this.mano.getMano().get(i).getNumero();
		}
	}
	
	
	
	
	@Override
	public Jugadas getJugada(ArrayList<Carta> mano) {
		// TODO Auto-generated method stub
		return null;
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
		return this.numEscaleraColor;
	}

}
