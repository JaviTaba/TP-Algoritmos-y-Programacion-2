public abstract interface TransaccionPesos {      

	
	abstract void extraer(int monto);
	abstract void transferir(Cliente cliente, int monto);
	abstract void comprarUSD(Cliente cliente, int monto);
	abstract void depositar(int monto);
        
       
       
	
	
}