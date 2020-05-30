import org.junit.Test;

import junit.framework.Assert;



public class PruebaClienteTarjeta {
	private Cliente cliente;
	private Tarjeta tarjeta;
	
	@Test
	public void creacionDeCliente() throws ExcepcionTarjeta, ExcepcionCliente {
		tarjeta = new Tarjeta(12345678,1234);
		cliente = new Cliente(20123456781L, tarjeta);
		
		Assert.assertEquals(12345678, tarjeta.getNumeroDeTarjeta());
		Assert.assertEquals(1234, tarjeta.getPin());
		Assert.assertEquals(20123456781L, cliente.getCuit());
		Assert.assertEquals(tarjeta, cliente.getTarjeta());
		
	}
	
	
	
	@Test (expected = ExcepcionCliente.class)
	public void creacionErroneaDeCliente() throws ExcepcionCliente {
		cliente = new Cliente(1234567, tarjeta);
	}
	
	
	@Test (expected = ExcepcionTarjeta.class)
	public void creacionErroneaDeTarjeta() throws ExcepcionTarjeta {
		tarjeta = new Tarjeta(12345, 12);
	}
	
	
	
}
