public class CuentaCorriente extends Pesos {

	private double descubierto;

	public CuentaCorriente(String alias, double saldo, double descubierto) throws ExcepcionCuenta {

		super(alias,saldo);
		this.descubierto = descubierto;



	}

	@Override
	public void extraer(int monto) {
		if(verificarMonto(monto) && verificarSaldo(monto) && monto/100 == 0) {
			saldo-= monto;
		}

		//hay que agregar la parte de ticket y modificar el txt
	}

	@Override
	public void transferir(Cliente cliente,double monto) {
		if(verificarMonto(monto) && verificarSaldo(monto)) {
			saldo -= monto;
			cliente.getCC().depositar(monto);
		} 
		//hay que agregar la parte de ticket y modificar el txt
	}

	@Override
	public void comprarUSD(Cliente cliente, double monto) {
		int sinImpuestos = monto*70;
		int conImpuestos = sinImpuestos+= sinImpuestos*0.3;
		if(verificarMonto(monto) && verificarSaldo(monto)) {
			if(cliente.getUSD()!= null) {
				saldo-= conImpuestos;
				cliente.getUSD().depositar(monto);

			}

		}
		//hay que agregar la parte de ticket y modificar el txt
	}

	@Override
	public void depositar(int monto) {
		if(verificarMonto(monto) && monto/100 == 0) {
			saldo+= monto;
			//hay que agregar la parte de ticket y modificar el txt

		}

	}

	@Override
	protected boolean verificarSaldo(double monto) {
		if (saldo>=(monto-descubierto)) {
			return true;
		}
		return false;
	}





}