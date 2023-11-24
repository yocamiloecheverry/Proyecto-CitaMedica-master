/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import ec.edu.ups.modelo.FacturaDetallada;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tians
 */
public class ControladorFacturaDetallada {
    //Declaracion de variables
    private Set<FacturaDetallada> detalles;
    private int codigo;
    /**
     * Constructor inicializa variables
     */
    public ControladorFacturaDetallada(){
        detalles = new HashSet<>();
        codigo = 1;
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
    public void cread(FacturaDetallada objeto) {
        objeto.setCodigo(codigo);
        detalles.add(objeto);
        codigo++;
    }
     /**
    * Metodo que lee un objeto por el codigo
    * @param codigo
    * @return 
    */
    public FacturaDetallada read(int codigo) {
        for (FacturaDetallada facturaDetallada : detalles) {
            if(facturaDetallada.getCodigo()== codigo){
                return facturaDetallada;
            }
        }        
        return null;
    }
    /**
     * Metodo Actualiza Objeto
     * @param objeto 
     */
    public void update(FacturaDetallada objeto) {
        if(detalles.contains(objeto)){
            detalles.remove(objeto);
            detalles.add(objeto);
        }
    }
    /**
     * Metodo que elimina un objeto por el codigo
     * @param codigo 
     */
    public void delete(int codigo) {
       for (FacturaDetallada facturaDetallada : detalles) {
            if(facturaDetallada.getCodigo()== codigo){
                detalles.remove(facturaDetallada);
                break;
            }
        }  
    }
    /**
     * Metodo que retorna la detalles del objeto
     * @return 
     */
    public Set<FacturaDetallada> getDetalles() {
        return detalles;
    }
}
