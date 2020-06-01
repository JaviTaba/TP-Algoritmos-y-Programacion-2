public class Tarjeta {
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroDeTarjeta;
		result = prime * result + pin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Tarjeta miTarjeta = (Tarjeta) obj;
		
		if(miTarjeta.getPin()==this.pin) {
			return true;
		}else {
			return false;
		}
	}


	public int numeroDeTarjeta ;
    public int pin;
    
    
    
    public Tarjeta (int numero, int pin) throws ExcepcionTarjeta {
        if (contadorCaracteres(numero) == 8 && contadorCaracteres(pin) == 4) {
        	
            this.numeroDeTarjeta = numero;
            this.pin = pin;
            
        } 
        
        else {
            throw new ExcepcionTarjeta("La tarjeta debe tener 8 digitos y el pin 4.");
        }
        
        
    }
    
    /**
     * @POST Devuelve el numero de la tarjeta.
     * 
     */
    public int getNumeroDeTarjeta() {
    	return numeroDeTarjeta;
    }
    
    /**
     * @POST Devuelve el PIN de la tarjeta.
     * 
     */
    public int getPin() {
    	return pin;
    }
    
    
    /**
     * @POST Cuenta la cantidad de cifras de la variable numero
     * 
     * 
     */
    private int contadorCaracteres(int numero) {
        int cifras = 0;
        
        while (numero != 0){
            numero/=10;
            cifras++;            
        }        
        
        return cifras;
        
    }
    
}
