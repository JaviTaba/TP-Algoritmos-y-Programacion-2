import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArchivoDeTarjetas {
	    
    private HashMap<Long, Tarjeta> mapaTarjeta;
    
    public ArchivoDeTarjetas() {
    	mapaTarjeta = new HashMap<Long, Tarjeta>();      
    }

	public void lectorDeTarjetas(){
        try {
        	  			
        			
        	FileReader fr = new FileReader("tarjetas.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String linea = br.readLine();
            
            while(linea != null) {
            	String[] spliteado = linea.split(",");
            	br.readLine();
            	
            long cuitDelUsuario = Long.parseLong(spliteado[2]);
            
            
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
