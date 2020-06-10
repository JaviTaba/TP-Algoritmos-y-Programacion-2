import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ArchivoDeCuentas {
	private ArchivoDeClientes clientes;
	private ArchivoDeTarjetas tarjetas;
	public HashMap<String, Cuenta> aliasCuenta;
	
	public ArchivoDeCuentas() {
		clientes = new ArchivoDeClientes();
		tarjetas = new ArchivoDeTarjetas();
		aliasCuenta = new HashMap<>();
		
		
		lectorDeCuentas();
		
	}
	
	public ArchivoDeClientes getClientes() {
		return clientes;
	}

	public ArchivoDeTarjetas getTarjetas() {
		return tarjetas;
	}
	
	public HashMap<String, Cuenta> getAliasCuenta(){
		return aliasCuenta;
	}

	private void lectorDeCuentas() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("cuentas.txt"));
			
			try {
			
				String linea = br.readLine();
				
				
		
		
				while(linea != null) {
					String[] spliteado = linea.split(",");
					int tipo = Integer.parseInt(spliteado[0]);
					switch(tipo) {
						
					case 01:
						Long cuit = clientes.getAliasCuit().get(spliteado[1]);
						Cliente cliente = tarjetas.getCuitCliente().get(cuit);
						cliente.asociarPesos(spliteado[1], Double.parseDouble(spliteado[2]));
						aliasCuenta.put(spliteado[1], cliente.getArs());
						tarjetas.getCuitCliente().put(cuit, cliente);
						break;
						
					case 02:
						Long cuit2 = clientes.getAliasCuit().get(spliteado[1]);
						Cliente cliente2 = tarjetas.getCuitCliente().get(cuit2);
						cliente2.asociarCuentaCorriente(spliteado[1], Double.parseDouble(spliteado[2]), Double.parseDouble(spliteado[3]));
						aliasCuenta.put(spliteado[1], cliente2.getCC());
						tarjetas.getCuitCliente().put(cuit2, cliente2);
						break;
						
					case 03:
						Long cuit3 = clientes.getAliasCuit().get(spliteado[1]);
						Cliente cliente3 = tarjetas.getCuitCliente().get(cuit3);
						cliente3.asociarUSD(spliteado[1], Double.parseDouble(spliteado[2]));
						aliasCuenta.put(spliteado[1], cliente3.getUSD());
						tarjetas.getCuitCliente().put(cuit3, cliente3);
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
