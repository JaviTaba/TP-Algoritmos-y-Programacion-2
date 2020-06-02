import org.junit.*;

public class TestCuenta {
	private Cuenta cuenta;
	
	@Test
	public void creaTicket() throws ExcepcionCuenta {
		cuenta = new CajaAhorroPesos("asd.asd.asd", 500.00);
		
	}
}
