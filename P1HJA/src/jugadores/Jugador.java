package jugadores;

import carta.Mano;
import jugadas.Jugadas;

public class Jugador {
	
	private Mano mano;
	private Jugadas mejorJugada;
	private int puesto;
	
	
	public Jugador(Mano mano) {
		this.mano = mano;
	}
	
	public Jugador() {}
	
	
	public Mano getMano() {
		return this.mano;
	}
	
	public void setMejorJugada(Jugadas jugada) {
		this.mejorJugada = jugada;
	}
	
	public void setPuesto(int p) {
		this.puesto = p;
	}
	
	public int getPuesto() {
		return this.puesto;
	}
	
	public void setMano(Mano mano) {
		this.mano = mano;
	}

}
