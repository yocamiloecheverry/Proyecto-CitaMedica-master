/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import ec.edu.ups.modelo.Factura;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tians
 */
public class ControladorFactura {
    //Declaracion de variables
    private Set<Factura> Facturas;
    private int codigo;
    /**
     * Constructor inicializa variables
     */
    public ControladorFactura(){
        Facturas = new HashSet<>();
        codigo = 0;
    }
    /**
     * Metodo que te obtiene el codigo
     * @return 
     */
    public int getCodigo() {
        return codigo;
    }
    /**
     * Metodo que crea un objeto
     * @param objeto 
     */ 
    public void cread(Factura objeto) {
        codigo++;
        objeto.setCodigo(codigo);
        Facturas.add(objeto);
    }
     /**
    * Metodo que lee un objeto por el codigo
    * @param codigo
    * @return 
    */
    public Factura read(int codigo) {
        for (Factura factura : Facturas) {
            if(factura.getCodigo()== codigo){
                return factura;
            }
        }        
        return null;
    }
    /**
     * Metodo Actualiza Objeto
     * @param objeto 
     */
    public void update(Factura objeto) {
        if(Facturas.contains(objeto)){
            Facturas.remove(objeto);
            Facturas.add(objeto);
        }
    }
    /**
     * Metodo que elimina un objeto por el codigo
     * @param codigo 
     */
    public void delete(int codigo) {
       for (Factura factura : Facturas) {
            if(factura.getCodigo()== codigo){
                Facturas.remove(factura);
                break;
            }
        }  
    }
    /**
     * Metodo que retorna la Facturas del objeto
     * @return 
     */
    public Set<Factura> getFacturas() {

        return Facturas;

    }
}
