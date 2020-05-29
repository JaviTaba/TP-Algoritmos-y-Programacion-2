public class Cliente {
        private long cuil;
        private Tarjeta tarjeta;
	private CajaAhorroPesos ars = null;
        private CajaAhorroUSD usd = null;
        private CuentaCorriente cc = null;
        
	public Cliente(long cuil, Tarjeta tarjeta) throws ExcepcionCliente {
	this.cuil=cuil;
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