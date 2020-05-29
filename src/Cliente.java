public class Cliente {
<<<<<<< HEAD
	
	
        private long cuil;
=======
        private long cuit;
>>>>>>> branch 'master' of https://github.com/JaviTaba/TPAYP2.git
        private Tarjeta tarjeta;
        private CajaAhorroPesos ars = null;
        private CajaAhorroUSD usd = null;
        private CuentaCorriente cc = null;
        
<<<<<<< HEAD
        
        
	public Cliente(long cuil, Tarjeta tarjeta) throws ExcepcionCliente {
				
		this.cuil=cuil;
=======
	public Cliente(long cuit, Tarjeta tarjeta) throws ExcepcionCliente {
	this.cuit=cuit;
>>>>>>> branch 'master' of https://github.com/JaviTaba/TPAYP2.git
        this.tarjeta=tarjeta;
        
        }
        
	
	
        public void asociarPesos(CajaAhorroPesos cuenta){
            this.ars = cuenta;            
        }
        
        public void asociarUSD(CajaAhorroUSD cuenta){
            this.usd = cuenta;
        }
        
        public void asociarCuentaCorriente(CuentaCorriente cuenta){
            this.cc = cuenta;
        }
	
	
}