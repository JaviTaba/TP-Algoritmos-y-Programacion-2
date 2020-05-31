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
	
        public void asociarPesos(CajaAhorroPesos cuenta){
            this.ars = cuenta;            
        }
        
        public CajaAhorroPesos getArs() {
        	return this.ars;
        }
        
        public void asociarUSD(CajaAhorroUSD cuenta){
            this.usd = cuenta;
        }
        
        public CajaAhorroUSD getUSD() {
        	return this.usd;
        }
        public void asociarCuentaCorriente(CuentaCorriente cuenta){
            this.cc = cuenta;
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