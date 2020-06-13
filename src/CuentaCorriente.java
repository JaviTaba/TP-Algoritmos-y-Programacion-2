public class CuentaCorriente extends Pesos {

	private double descubierto;

	public CuentaCorriente(String alias, double saldo, double descubierto) throws ExcepcionCuenta {

		super(alias,saldo);
		this.descubierto = descubierto;



	}
	
	@Override
    protected String getTipoDeCuenta() {
    	return "02";
    }
	
	
	@Override
	public double getDescubierto() {
		return descubierto;
	}
	
	@Override
	protected boolean verificarSaldo(double monto) {
		if (saldo>=(monto-descubierto)) {
			return true;
		}
		return false;
	}





}