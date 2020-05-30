public abstract class Cuenta {
	
	
  
    public String alias;
    public double saldo;
    public double descubierto;
    
    
    public Cuenta( String alias, double saldo) {
    	
      
       this.alias = alias;
       this.saldo = saldo;
       
    }
    
    
    public String obtenerAlias() {
    	return alias;
    }
    
    public double obtenerSaldo() {
    	return saldo;
    }
    
    
    
}