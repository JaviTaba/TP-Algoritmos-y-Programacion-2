import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;



public class ArchivoDeTarjetas {
	    
    private HashMap<Tarjeta, Long> cuitTarjeta;
    private HashMap<Long, Cliente> cuitCliente;
  
    
    public ArchivoDeTarjetas() {
    	cuitTarjeta = new HashMap<Tarjeta, Long>();      
    	cuitCliente = new HashMap<Long,Cliente>();
    	lectorDeTarjetas();
    }


	private void lectorDeTarjetas() {
		
        try {
        	BufferedReader br = new BufferedReader(new FileReader("tarjetas.txt"));
        	
        	try {
        		
	            String linea = br.readLine();
	            
	            while (linea != null) {
	            	
	            	String[] spliteado = linea.split(",");
	            	
	            	
		            long cuitDelUsuario = Long.parseLong(spliteado[2]);
		            int tarjetaDelUsuario = Integer.parseInt(spliteado[0]);
		            int pinDeLaTarjeta = Integer.parseInt(spliteado[1]);
		            
		            Tarjeta tarjeta = new Tarjeta(tarjetaDelUsuario, pinDeLaTarjeta);
		            Cliente cliente = new Cliente(cuitDelUsuario, tarjeta);
		            
		            cuitTarjeta.put(tarjeta, cuitDelUsuario);
		            cuitCliente.put(cuitDelUsuario, cliente);	
		            
		            linea = br.readLine();
	                        
	            } 
	            
        	} finally {
        		br.close();
        	  	}
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
        
        
    }
	
	
	
	public HashMap<Tarjeta, Long> getCuitTarjeta() {
		return cuitTarjeta;
	}

	public HashMap<Long, Cliente> getCuitCliente() {
		return cuitCliente;
	}

	
	
	
}
