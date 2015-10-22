import carta.Carta;
import carta.Mano;

public class Parser {
	
	
	public static Mano parse(String s) {

		char[] token = s.toCharArray();
		
		Mano mano = new Mano();
		
		mano.setMano(new Carta(token[0], token[1]));
		mano.setMano(new Carta(token[2], token[3]));
		mano.setMano(new Carta(token[4], token[5]));
		mano.setMano(new Carta(token[6], token[7]));
		mano.setMano(new Carta(token[8], token[9]));
		
		/* Ordenamos la mano pasandole los rangos del array de manos */
		mano.ordenaMano(0, 4);
		
		return mano;
		
	}

}
