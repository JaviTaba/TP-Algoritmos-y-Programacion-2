import java.io.IOException;

import org.junit.Test;

public class PruebaArchivo {
	
	private ArchivoDeTarjetas tarjetas;
	private ArchivoDeCuentas cuentas;
	private ArchivoDeClientes clientes;
	
	@Test
	public void validoCreacionDeArchivoDeTarjetas() throws IOException {
		tarjetas = new ArchivoDeTarjetas();
		
	}
	
	@Test
	public void validoCreacionDeArchivoDeCuentas() throws IOException {
		cuentas = new ArchivoDeCuentas();
	}
	
	@Test
	public void validoCreacionDeArchivoDeClientes() throws IOException {
		clientes = new ArchivoDeClientes();
	}
	
}
