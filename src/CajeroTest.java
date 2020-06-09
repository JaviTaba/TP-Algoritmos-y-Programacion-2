import java.io.IOException;

import org.junit.*;


public class CajeroTest {
	Cajero cajero;
	
	@Before
	public void creando() throws IOException {
		cajero = new Cajero();
	}
	
	@Test
	public void dispensa1BilleteDe500() {
		cajero.dispensar(500);
		Assert.assertEquals(499, cajero.getBilletesDeQuinientos(), 0.01 );
	}
	
	@Test
	public void dispensa3BilletesDe100() {
		cajero.dispensar(300);
		Assert.assertEquals(497,cajero.getBilletesDeCien(), 0.01 );
	}
	
	@Test
	public void dispensa2BilletesDeMilY1De500() {
		cajero.dispensar(2500);
		Assert.assertEquals(498, cajero.getBilletesDeMil(), 0.01);
		Assert.assertEquals(499, cajero.getBilletesDeQuinientos(), 0.01);
		}
	
	@Test
	public void dispensaBilletesMultiples() {
		cajero.dispensar(7800);
		Assert.assertEquals(493, cajero.getBilletesDeMil(), 0.01);
		Assert.assertEquals(499, cajero.getBilletesDeQuinientos(), 0.01);
		Assert.assertEquals(497, cajero.getBilletesDeCien(), 0.01);
	}

}
