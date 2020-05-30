public class CuentaCorriente extends Pesos {
	
    private double descubierto;
 
    public CuentaCorriente(String alias, double saldo, double descubierto) {
    	
        super(alias,saldo);
        this.descubierto = descubierto;
                
        
    }
    
    
    
}