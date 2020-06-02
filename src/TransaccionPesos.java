import java.io.IOException;

public abstract interface TransaccionPesos {      

	
	abstract void extraer(double monto) throws IOException;
	abstract void transferir(Cliente cliente, double monto) throws IOException;
	abstract void comprarUSD(Cliente cliente, double monto) throws IOException;
	abstract void depositar(double monto) throws IOException;
        
       
       
	
	
}