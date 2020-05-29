
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author javi1
 */
public class LectorTarjeta {
    
    
    public LectorTarjeta(String tarjeta){
        
    }
    
    private boolean validadorDeExistenciaDeTarjeta(String tarjeta) throws IOException {
		
		try {
			BufferedReader lector = new BufferedReader(new FileReader("tarjetas/tarjetas.txt"));
			
			
			
			try {
				String linea = lector.readLine();
				
				boolean verificador = false;
				
				
				while (linea != null && verificador == false) {
					
					String[] campos = linea.split(",");
					
					if(tarjeta.equalsIgnoreCase(campos[0]) ) {
						verificador = true;
						
					} else {
						linea = lector.readLine();
					}
					
				}
				
				return verificador;
					
				
				
			} finally {
				lector.close();
			}
			
			
			
			
		} catch(FileNotFoundException file) {
			throw new Error(file);
		}
	}
        
}