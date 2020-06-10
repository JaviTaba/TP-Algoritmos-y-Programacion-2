public class Cliente {

        private long cuit;
        private Tarjeta tarjeta;
        private CajaAhorroPesos ars = null;
        private CajaAhorroUSD usd = null;
        private CuentaCorriente cc = null;
        
        

	public Cliente(long cuit, Tarjeta tarjeta) throws ExcepcionCliente {
		
		if (contadorCaracteres(cuit) != 11) {
			throw new ExcepcionCliente("El CUIT es inválido.");
		}
		
				
		this.cuit=cuit;
		this.tarjeta=tarjeta;
        
	}
	
        public void asociarPesos(String alias, Double saldo) throws ExcepcionCuenta{
            this.ars = new CajaAhorroPesos(alias, saldo);          
        }
        
        public CajaAhorroPesos getArs() {
        	return this.ars;
        }
        
        public void asociarUSD(String alias, Double saldo) throws ExcepcionCuenta{
            this.usd = new CajaAhorroUSD(alias, saldo);
        }
        
        public CajaAhorroUSD getUSD() {
        	return this.usd;
        }
        
        public void asociarCuentaCorriente(String alias, Double saldo, Double descubierto) throws ExcepcionCuenta{
            this.cc = new CuentaCorriente(alias, saldo, descubierto);
        }
        
        public CuentaCorriente getCC() {
        	return this.cc;
        }
        
       
	public long getCuit() {
		return cuit;
	}
	
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	
	
	
	/**
     * @POST Cuenta la cantidad de cifras de la variable numero
     * 
     * 
     */
    private long contadorCaracteres(long numero) {
        int cifras = 0;
        
        while (numero != 0){
            numero/=10;
            cifras++;            
        }        
        
        return cifras;
        
    }
}