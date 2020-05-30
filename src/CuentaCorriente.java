public class CuentaCorriente extends Pesos {
	
    private double descubierto;
 
    public CuentaCorriente(String alias, double saldo, double descubierto) throws ExcepcionCuenta {
    	
        super(alias,saldo);
        this.descubierto = descubierto;
                
        
    }
    
    public double getDescubierto() {
    	return descubierto;
    }
    
}