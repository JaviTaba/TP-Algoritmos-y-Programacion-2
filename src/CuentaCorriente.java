public class CuentaCorriente extends Pesos {
	
    private double descubierto;
 
    public CuentaCorriente(int tipo, String alias, double saldo, double descubierto) {
    	
        super(tipo,alias,saldo);
        this.descubierto = descubierto;
                
        
    }
    
    
    
}