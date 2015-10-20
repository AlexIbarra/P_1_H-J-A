import java.io.IOException;

import IO.FileIn;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			FileIn filein = new FileIn("data/entrada1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
