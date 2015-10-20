package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileIn {

private File finStr;
private FileInputStream file;
	
	
	public FileIn(String param) throws IOException{
		
		try {			
			this.finStr = new File(param);
			this.file = new FileInputStream(this.finStr);
			
			int content; 
			
					
			while ((content = file.read()) != -1) {
				// convert to char and display it
				System.out.print((char) content);
			}
		} catch(FileNotFoundException exc) {
			throw new IOException("Error al acceder al fichero de entrada ("+ param + ")");
		} catch (IOException e) {
			throw new IOException("Error al acceder al fichero de entrada ("+ param + ")");
		}

	}
	
	
//	public int read() throws IOException {
//		
//		int caract = file.read();
//		if(caract  == '\r')
//			caract = -1;
//
//		return caract;
//	}

}
