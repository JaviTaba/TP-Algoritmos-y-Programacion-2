import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoDeCuentas {
	private ArchivoDeClientes clientes;
	private ArchivoDeTarjetas tarjetas;
	private BufferedReader br;
	
	
	public ArchivoDeCuentas() {
		clientes = new ArchivoDeClientes();
		tarjetas = new ArchivoDeTarjetas();
	
		
		
		lectorDeCuentas();
		
	}
	
	public ArchivoDeClientes getClientes() {
		return clientes;
	}

	public ArchivoDeTarjetas getTarjetas() {
		return tarjetas;
	}
	
	
	
	public Cuenta encontrarCuenta(String alias) throws ExcepcionCuenta {
		if(clientes.getAliasCuit().containsKey(alias)) {
			long cuit = clientes.getAliasCuit().get(alias);
			if(tarjetas.getCuitCliente().get(cuit).getArs() != null 
					&& tarjetas.getCuitCliente().get(cuit).getArs().getAlias().equalsIgnoreCase(alias)) {
				return tarjetas.getCuitCliente().get(cuit).getArs();
				
			}
			else if(tarjetas.getCuitCliente().get(cuit).getCC() != null 
					&& tarjetas.getCuitCliente().get(cuit).getCC().getAlias().equalsIgnoreCase(alias)) {
				return tarjetas.getCuitCliente().get(cuit).getCC();
				
			}else {
				return null;
			}
		}
		else {
			throw new ExcepcionCuenta("No se encontro la cuenta destinataria");
			
		}
	}
	
	

	private void lectorDeCuentas() {
		
		try {
			br = new BufferedReader(new FileReader("cuentas.txt"));
			
			
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
						
						tarjetas.getCuitCliente().put(cuit, cliente);
						break;
						
					case 02:
						Long cuit2 = clientes.getAliasCuit().get(spliteado[1]);
						Cliente cliente2 = tarjetas.getCuitCliente().get(cuit2);
						cliente2.asociarCuentaCorriente(spliteado[1], Double.parseDouble(spliteado[2]), Double.parseDouble(spliteado[3]));
						
						tarjetas.getCuitCliente().put(cuit2, cliente2);
						break;
						
					case 03:
						Long cuit3 = clientes.getAliasCuit().get(spliteado[1]);
						Cliente cliente3 = tarjetas.getCuitCliente().get(cuit3);
						cliente3.asociarUSD(spliteado[1], Double.parseDouble(spliteado[2]));
						
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
