public abstract class Cuenta {
	
	
    public int tipo;
    public String alias;
    public double saldo;
    public double descubierto;
    
    
    public Cuenta(int tipo, String alias, double saldo) {
    	
       this.tipo = tipo;
       this.alias = alias;
       this.saldo = saldo;
       
    }
    
    
    public int obtenerTipo() {
    	return tipo;
    }
    
    public String obtenerAlias() {
    	return alias;
    }
    
    public double obtenerSaldo() {
    	return saldo;
    }
    
    
    
}