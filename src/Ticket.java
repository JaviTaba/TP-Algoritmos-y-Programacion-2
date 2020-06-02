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
	FileWriter writer;
	
	public Ticket() throws IOException {
		date = new Date();
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		ticket = new File("ticket.txt");
		writer = new FileWriter(ticket);
	}


	public String toString() {
		return dateFormat.format(date);
	}
	
	public void extraer(double saldo, double monto, Cuenta cuenta) throws IOException{
		writer.write("-------------------------------------------------------"
				+ "\n Has realizado una EXTRACCIÓN"
				+ "\n FECHA: "+toString()
				+ "\n IMPORTE: $"+monto
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------");
		 writer.flush();
	     writer.close();
	}
	
	public void transferir(double saldo, double monto, Cuenta cuenta) throws IOException {
		writer.write("-------------------------------------------------------"
				+ "\n Has realizado una TRANSFERENCIA"
				+ "\n FECHA: "+toString()
				+ "\n IMPORTE: $"+monto
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------");
		 writer.flush();
	     writer.close();
	}
	
	public void depositar(double saldo, double monto, Cuenta cuenta) throws IOException {
		writer.write("-------------------------------------------------------"
				+ "\n Has realizado un DEPOSITO"
				+ "\n FECHA: "+toString()
				+ "\n IMPORTE: $"+monto
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------");
		 writer.flush();
	     writer.close();
	} 
	
	public void comprarUSD(double saldo, double monto, Cuenta cuenta) throws IOException {
		DecimalFormat df = new DecimalFormat("#.00");
		
		writer.write("-------------------------------------------------------"
				+ "\n Has realizado una COMPRA DE DOLARES"
				+ "\n FECHA: "+toString()
				+ "\n IMPORTE: $"+df.format(monto/cuenta.dolar)
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------");
		 writer.flush();
	     writer.close();
	} 
		
}
