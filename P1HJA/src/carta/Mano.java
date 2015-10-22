package carta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	
	public String toString() {
		String cadena = new String();
		for(int i=0; i < 5; i++) {
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
        if (0 < j)
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
