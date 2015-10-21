import carta.Carta;

public class Parser {
	
	private static char numero[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
	private static char palo[] = {'h', 'd', 'c','s'};
	
	
	public static Carta parse(String s) {
		
		char a = ' ';
		char b = ' ';
		char[] token = s.toCharArray();
		
		token[0] = a;
		token [1] = b;
		
		return new Carta(a, b);
	}

}
