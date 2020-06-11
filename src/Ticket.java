import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
	File ticket;
	private Date date;
	private SimpleDateFormat dateFormat;
	private SimpleDateFormat dateTicket;
	FileWriter writer;
	String aImprimir;
	
	
	public Ticket() throws IOException {
		date = new Date();
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		dateTicket = new SimpleDateFormat("dd-MM-yyyy--HH-mm-ss");
		aImprimir = "";
			
		
		
	}
	public void crearTicket() {
		ticket = new File("ticket"+dateTicket.format(date)+".txt");
	}
	
	public void imprimirTicket() throws IOException {
		writer = new FileWriter(ticket);
		writer.write(aImprimir);
		writer.flush();
	    writer.close();
	}


	public String getFecha() {
		return dateFormat.format(date);
	}
	
	public String toString() {
		return ticket.toString();
	}
	
	public void extraer(Cuenta cuenta, double monto) throws IOException{
			
			aImprimir += ("-------------------------------------------------------"
					+ "\n Has realizado una EXTRACCIÓN"
					+ "\n FECHA: "+getFecha()
					+ "\n IMPORTE: $"+monto
					+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
					+ "\n-------------------------------------------------------"
					+ "\n");
			
			
				
	}
	
	public void transferir(Cuenta cuenta, double monto) throws IOException {
	
		
		aImprimir+=("-------------------------------------------------------"
				+ "\n Has realizado una TRANSFERENCIA"
				+ "\n FECHA: "+getFecha()
				+ "\n IMPORTE: $"+monto
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------"
				+ "\n");
		
	}
	
	public void depositar(Cuenta cuenta, double monto) throws IOException {
		
		
		aImprimir+=("-------------------------------------------------------"
				+ "\n Has realizado un DEPOSITO"
				+ "\n FECHA: "+getFecha()
				+ "\n IMPORTE: $"+monto
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------"
				+ "\n");
	} 
	
	public void comprarUSD(Cuenta cuenta, double monto) throws IOException {
		DecimalFormat df = new DecimalFormat("#.00");
	
		aImprimir+=("-------------------------------------------------------"
				+ "\n Has realizado una COMPRA DE DOLARES"
				+ "\n FECHA: "+getFecha()
				+ "\n IMPORTE: $"+df.format(monto/cuenta.dolar)
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------"
				+ "\n");
		
	} 
		
}
