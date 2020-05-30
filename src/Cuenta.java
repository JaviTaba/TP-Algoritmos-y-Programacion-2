public abstract class Cuenta {
	
	
  
    public String alias;
    public double saldo;
    public double descubierto;
    
    
    public Cuenta (String alias, double saldo) {
    	
      
       this.alias = alias;
       this.saldo = saldo;
       
    }
    
    
    public String getAlias() {
    	return alias;
    }
    
    public double getSaldo() {
    	return saldo;
    }
    
    
    
}