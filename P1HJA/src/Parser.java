import carta.Carta;
import carta.Mano;

public class Parser {
	
//	private static char numero[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
//	private static char palo[] = {'h', 'd', 'c','s'};
	
	
	public static Mano parse(String s) {

		char[] token = s.toCharArray();
		
		Mano mano = new Mano();
		
		mano.setMano(new Carta(token[0], token[1]));
		mano.setMano(new Carta(token[2], token[3]));
		mano.setMano(new Carta(token[4], token[5]));
		mano.setMano(new Carta(token[6], token[7]));
		mano.setMano(new Carta(token[8], token[9]));
		
		return mano;
		
	}

}
