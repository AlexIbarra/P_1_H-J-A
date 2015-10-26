import java.util.ArrayList;

import carta.Carta;
import carta.Mano;

public class ParserManos {
	
	
	public static ArrayList <Mano> parse(String s) {
		
		ArrayList <Mano> arrayManos = new ArrayList<Mano>();
		int i=0, j=0;
//		char[] token = s.toCharArray();
		String[] array = s.split("\n");	
		char[] token;
		
		
		do {
			
			token = array[i].toCharArray();
			
			arrayManos.add(new Mano());
					
			arrayManos.get(i).setMano(new Carta(token[0], token[1]));
			arrayManos.get(i).setMano(new Carta(token[2], token[3]));
			arrayManos.get(i).setMano(new Carta(token[4], token[5]));
			arrayManos.get(i).setMano(new Carta(token[6], token[7]));
			arrayManos.get(i).setMano(new Carta(token[8], token[9]));
			
			/* Ordenamos la mano pasandole los rangos del array de manos */
			arrayManos.get(i).ordenaMano(0, 4);
			i++;
			j+=11;
			 
		} while(i < array.length);
		
		return arrayManos;
		
	}

}
