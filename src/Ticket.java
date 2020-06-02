import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
	
	private Date date;
	private SimpleDateFormat dateFormat;
	private Cuenta cuenta;
	
	public Ticket() {
		date = new Date();
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
	}


	public String toString() {
		return dateFormat.format(date);
	}
	
	public String extraer(double saldo, double monto){
		return "-------------------------------------------------------"
				+ "\n Has realizado una EXTRACCIÓN"
				+ "\n FECHA: "+toString()
				+ "\n IMPORTE: $"+monto
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------";
	}
	
	public String transferir(double saldo, double monto) {
		return "-------------------------------------------------------"
				+ "\n Has realizado una TRANSFERENCIA"
				+ "\n FECHA: "+toString()
				+ "\n IMPORTE: $"+monto
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------";
	}
	
	public String depositar(double saldo, double monto) {
		return "-------------------------------------------------------"
				+ "\n Has realizado un DEPOSITO"
				+ "\n FECHA: "+toString()
				+ "\n IMPORTE: $"+monto
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------";
	} 
	
	public String comprarUSD(double saldo, double monto) {
		DecimalFormat df = new DecimalFormat("#.00");
		
		return "-------------------------------------------------------"
				+ "\n Has realizado una COMPRA DE DOLARES"
				+ "\n FECHA: "+toString()
				+ "\n IMPORTE: $"+df.format(monto/cuenta.dolar)
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------";
	} 
	
	public String saldo(double saldo) {
		return "-------------------------------------------------------"
				+ "\n Has realizado una consulta de SALDO"
				+ "\n FECHA: "+toString()
				+ "\n SALDO ACTUAL: $"+cuenta.getSaldo()
				+ "\n-------------------------------------------------------";
	} 
	
	public String alias(String alias) {
		return "-------------------------------------------------------"
				+ "\n Has realizado una consulta de ALIAS"
				+ "\n FECHA: "+toString()
				+ "\n ALIAS: "+cuenta.getAlias()
				+ "\n-------------------------------------------------------";
	} 
	
	
	
}
