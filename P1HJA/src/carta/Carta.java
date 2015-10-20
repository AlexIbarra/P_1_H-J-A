package carta;

public class Carta {
	
	private char numero;
	private char palo;
	private byte codigo;
	
	public Carta (char num, char p){
		
		num = this.numero;
		p = this.palo;
	}
	
	public char getNumero() {
		return this.numero;
	}
	
	public char getPalo() {
		return this.palo;
	}
	
	public byte getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(byte c) {
		this.codigo = c;
	}
	
	
	
	
}
