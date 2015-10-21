package carta;

import java.util.ArrayList;

public class Mano {
	
	private ArrayList<Carta> mano;
	
	public Mano(){}
	
	public void setMano(Carta carta) {
		this.mano.add(carta);
	}
	
	public ArrayList<Carta> getMano() {
		return this.mano;
	}
	
	public String toString() {
		String cadena = new String();
		for(int i=0; i < 5; i++) {
			cadena += this.mano.get(i).getNumero()+this.mano.get(i).getPalo();			
		}
		return cadena;
	}

}
