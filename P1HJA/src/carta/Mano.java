package carta;

import java.util.ArrayList;

public class Mano {
	
	private ArrayList<Carta> mano;
	
	public Mano(){
		this.mano = new ArrayList<Carta>();
	}
	
	public void setMano(Carta carta) {
		this.mano.add(carta);
	}
	
	public ArrayList<Carta> getMano() {
		return this.mano;
	}
	
	public Carta getCarta(int n) {
		return this.mano.get(n);
	}
	
	public void setUsada(int i, boolean b) {
		mano.get(i).setUsada(b);
	}
	
	
	public int getKicker() {
		return 0;
	}
	
	public boolean getUsada() {
		return true;
	}
	
	public void setKicker(int n) {
		int i= this.mano.size()-1;
		int j=1;
		while(n != 0) {
			/* Las cartas que no esten usadas las marco como kicker */
			if(this.mano.get(i).getUsada() != true) {
				n--;
				this.mano.get(i).setKicker(j);
				this.mano.get(i).setUsada(true);
				j++;
			}
			i--;
		}
	}
	
	public String toString() {
		String cadena = new String();
		for(int i=0; i < this.mano.size(); i++) {
			/* Concateno Numero + Palo de cada carta de la mano */
			if(this.mano.get(i).getUsada() == true)
				cadena += this.mano.get(i).toString();			
		}
		return cadena;
	}
	
	public void ordenaMano(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = this.mano.get(lowerIndex+(higherIndex-lowerIndex)/2).getCodigo();
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (this.mano.get(i).getCodigo() < pivot) {
                i++;
            }
            while (this.mano.get(j).getCodigo() > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call ordenaMano() method recursively
        if (lowerIndex < j)
        	ordenaMano(lowerIndex, j);
        if (i < higherIndex)
        	ordenaMano(i, higherIndex);
	}
	
	private void exchangeNumbers(int i, int j) {
        Carta temp = this.mano.get(i);
        this.mano.set(i, this.mano.get(j));
        this.mano.set(j, temp);
    }

}
