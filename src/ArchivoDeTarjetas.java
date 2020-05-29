import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArchivoDeTarjetas {
	    
    private HashMap<Tarjeta, Long> cuitTarjeta;
    private HashMap<Long, Cliente> cuitCliente;
  
    
    public ArchivoDeTarjetas() {
    	cuitTarjeta = new HashMap<Tarjeta, Long>();      
    	cuitCliente = new HashMap<Long,Cliente>();
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
            int tarjetaDelUsuario = Integer.parseInt(spliteado[0]);
            int pinDeLaTarjeta = Integer.parseInt(spliteado[1]);
            
            Tarjeta tarjeta = new Tarjeta(tarjetaDelUsuario, pinDeLaTarjeta);
            Cliente cliente = new Cliente(cuitDelUsuario, tarjeta);
            
            cuitTarjeta.put(tarjeta, cuitDelUsuario);
            cuitCliente.put(cuitDelUsuario, cliente);	
            
            br.readLine();
            
            
            
            
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
    
}
