import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ArchivoDeCuentas {
	private HashMap<String, Cliente> clienteConAlias;
	
	public ArchivoDeCuentas() {
		clienteConAlias = new HashMap<String, Cliente>();
		lectorDeCuentas();
	}
	
	private void lectorDeCuentas() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("cuentas.txt"));
			
			try {
			
				String linea = br.readLine();
				ArchivoDeClientes usar2 = new ArchivoDeClientes();
				
		
		
				while(linea != null) {
					String[] spliteado = linea.split(",");
			
					switch(spliteado[0]) {
						
					case"01":
						CajaAhorroPesos cuenta = new CajaAhorroPesos(spliteado[1], Double.parseDouble(spliteado[2]));
						clienteConAlias.get(spliteado[1]).asociarPesos(cuenta);
						break;
						
					case"02":
						CuentaCorriente cuenta2 = new CuentaCorriente(spliteado[1],Double.parseDouble(spliteado[2]), Double.parseDouble(spliteado[3]));
						clienteConAlias.get(spliteado[1]).asociarCuentaCorriente(cuenta2);
						break;
						
					case"03":
						CajaAhorroUSD cuenta3 = new CajaAhorroUSD(spliteado[1], Double.parseDouble(spliteado[2]));
						clienteConAlias.get(spliteado[1]).asociarUSD(cuenta3);
						break;
				    } 
					
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

}
