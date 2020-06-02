public class CuentaCorriente extends Pesos {

	private double descubierto;

	public CuentaCorriente(String alias, double saldo, double descubierto) throws ExcepcionCuenta {

		super(alias,saldo);
		this.descubierto = descubierto;



	}

	@Override
	public void extraer(double monto) {
		if(verificarMonto(monto) && verificarSaldo(monto) && monto/100 == 0) {
			saldo-= monto;
			ticket.extraer(saldo, monto);	
		}

		//hay que agregar la parte de ticket y modificar el txt
	}

	@Override
	public void transferir(Cliente cliente,double monto) {
		if(verificarMonto(monto) && verificarSaldo(monto) && cliente.getArs() != null) {
			saldo -= monto;
			cliente.getArs().saldo += monto;
			ticket.transferir(getSaldo(), monto);
		} 
		//hay que agregar la parte de ticket y modificar el txt
	}

	@Override
	public void comprarUSD(Cliente cliente, double monto) {
		double sinImpuestos = monto*70;
		double conImpuestos = sinImpuestos+= sinImpuestos*0.3;
		if(verificarMonto(monto) && verificarSaldo(monto) && cliente.getUSD()!= null) {
			
			saldo-= conImpuestos;
			cliente.getUSD().depositar(monto);
			ticket.comprarUSD(cliente.getUSD().getSaldo(), monto);

			

		}
		//hay que agregar la parte de ticket y modificar el txt
	}

	@Override
	public void depositar(double monto) {
		if(verificarMonto(monto) && monto/100 == 0) {
			saldo += monto;
			ticket.depositar(saldo, monto);
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