public class Tarjeta {
	
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
    
    
    public int getNumeroDeTarjeta() {
    	return numeroDeTarjeta;
    }
    
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
