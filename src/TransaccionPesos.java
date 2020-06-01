public abstract interface TransaccionPesos {      

	
	abstract void extraer(double monto);
	abstract void transferir(Cliente cliente, double monto);
	abstract void comprarUSD(Cliente cliente, double monto);
	abstract void depositar(double monto);
        
       
       
	
	
}