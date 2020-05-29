/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author javi1
 */
public abstract class Cuenta {
    public int tipo;
    public String alias;
    public double saldo;
    public double descubierto;
    
    
    
    public Cuenta(int tipo, String alias, double saldo){
       this.tipo = tipo;
       this.alias = alias;
       this.saldo = saldo;
         
    }
        
}