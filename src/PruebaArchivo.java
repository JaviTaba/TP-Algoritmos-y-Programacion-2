import java.io.IOException;

import org.junit.Test;

public class PruebaArchivo {
	
	private ArchivoDeTarjetas tarjetas;
	private ArchivoDeCuentas cuentas;
	private ArchivoDeClientes clientes;
	
	
	@Test
	public void validoCreacionDeArchivoDeCuentas() throws IOException {
		cuentas = new ArchivoDeCuentas();
		System.out.println(cuentas.getClienteAlias());
	}
	
	@Test
	public void validoCreacionDeArchivoDeClientes() throws IOException {
		clientes = new ArchivoDeClientes();
		System.out.println(clientes.getAliasCliente());
	}
	
}
