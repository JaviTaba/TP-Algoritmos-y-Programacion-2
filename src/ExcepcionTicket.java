import java.io.IOException;

public class ExcepcionTicket extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4439509831628952698L;
	
	public ExcepcionTicket (String mensaje) {
		super(mensaje);
	}
}