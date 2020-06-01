import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
	
	private Date date;
	private SimpleDateFormat dateFormat;
	
	
	public Ticket() {
		date = new Date();
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
	}


	public String toString() {
		return dateFormat.format(date);
	}
	
	public String extraer(Cuenta cuenta, double monto){
		return "-------------------------------------------------------"
				+ "\n Has realizado una EXTRACCIÓN"
				+ "\n FECHA: "+toString()
				+ "\n IMPORTE: $"+monto
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------";
	}
	
	public String transferir(Cuenta cuenta, double monto) {
		return "-------------------------------------------------------"
				+ "\n Has realizado una TRANSFERENCIA"
				+ "\n FECHA: "+toString()
				+ "\n IMPORTE: $"+monto
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------";
	}
	
	public String depositar(Cuenta cuenta, double monto) {
		return "-------------------------------------------------------"
				+ "\n Has realizado un DEPOSITO"
				+ "\n FECHA: "+toString()
				+ "\n IMPORTE: $"+monto
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------";
	} 
	
	public String comprarUSD(Cuenta cuenta, double monto) {
		DecimalFormat df = new DecimalFormat("#.00");
		
		return "-------------------------------------------------------"
				+ "\n Has realizado una COMPRA DE DOLARES"
				+ "\n FECHA: "+toString()
				+ "\n IMPORTE: $"+df.format(monto/cuenta.dolar)
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------";
	} 
	
	public String saldo(Cuenta cuenta) {
		return "-------------------------------------------------------"
				+ "\n Has realizado una consulta de SALDO"
				+ "\n FECHA: "+toString()
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------";
	} 
	
	public String alias(Cuenta cuenta) {
		return "-------------------------------------------------------"
				+ "\n Has realizado una consulta de ALIAS"
				+ "\n FECHA: "+toString()
				+ "\n ALIAS: "+cuenta.getAlias()
				+ "\n-------------------------------------------------------";
	} 
	
	
	
}
