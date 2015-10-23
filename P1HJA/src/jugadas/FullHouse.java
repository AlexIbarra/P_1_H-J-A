package jugadas;

import java.util.ArrayList;

import carta.Carta;

public class FullHouse implements Jugadas {
	
	private int trio, pareja;
	
	public FullHouse(int num, int num1) {
		// TODO Auto-generated constructor stub
		num = trio;
		num1 = pareja;
		
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
				trio = mano.get(i).getCodigo();
			}
			i++;
			
		}
		i = 0;
		while (i < mano.size() -1 && encontradoTrio && !encontradoPareja){
			
			if(mano.get(i).getNumero() == mano.get(i+1).getCodigo()
					&& !encontradoPareja){
				encontradoPareja = true;
				trio = mano.get(i).getCodigo();
			}
			i++;
			
		}
		
		
		if (encontradoTrio && encontradoPareja)
			return new FullHouse(trio, pareja);
		else
			return new FullHouse(0,0);
		
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

}
