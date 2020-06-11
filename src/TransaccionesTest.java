import java.io.IOException;

import org.junit.*;

public class TransaccionesTest {
	private ArchivoDeCuentas adc;

	
	@Before
	public void creando() throws IOException, ExcepcionTarjeta, ExcepcionTransaccion, ExcepcionCuenta {
		adc = new ArchivoDeCuentas();
		
	}
	
	@Test
	public void depo1000Pesos() throws ExcepcionTransaccion {
		long cuit = adc.getClientes().getAliasCuit().get("isla.pez.arbol");
		adc.getTarjetas().getCuitCliente().get(cuit).getArs().extraer(1000.00);
		Assert.assertEquals(11000.03,adc.getTarjetas().getCuitCliente().get(cuit).getArs().getSaldo() , 0.01);
		
	}
}
