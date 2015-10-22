package carta;

import java.util.HashMap;

public class Carta {
	
	private char numero;
	private char palo;
	private int codigo;
	private HashMap<Character, Integer> valores;// = new Hashtable<Integer,String>()
	
	public Carta (char num, char p){
		
		this.numero = num;
		this.palo = p;
		this.valores = new HashMap<Character, Integer>();
		setHashMap();
		this.codigo = this.valores.get(this.numero);
	}
	
	public char getNumero() {
		return this.numero;
	}
	
	public char getPalo() {
		return this.palo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(byte c) {
		this.codigo = c;
	}
	
	public String toString() {
		return String.valueOf(this.numero)+String.valueOf(this.palo);
	}
	
	
	private void setHashMap() {
		this.valores.put(new Character('A'), new Integer(14));
		this.valores.put(new Character('K'), new Integer(13));
		this.valores.put(new Character('Q'), new Integer(12));
		this.valores.put(new Character('J'), new Integer(11));
		this.valores.put(new Character('T'), new Integer(10));
		this.valores.put(new Character('9'), new Integer(9));
		this.valores.put(new Character('8'), new Integer(8));
		this.valores.put(new Character('7'), new Integer(7));
		this.valores.put(new Character('6'), new Integer(6));
		this.valores.put(new Character('5'), new Integer(5));
		this.valores.put(new Character('4'), new Integer(4));
		this.valores.put(new Character('3'), new Integer(3));
		this.valores.put(new Character('2'), new Integer(2));
	}
	
	
	
	
}
