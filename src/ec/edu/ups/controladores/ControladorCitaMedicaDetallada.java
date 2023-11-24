/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.ups.controladores;

import ec.edu.ups.modelo.CitaMedicaDetallada;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author José Quinde
 */
public class ControladorCitaMedicaDetallada {
   //Declaracion de variables
    private Set<CitaMedicaDetallada> lista;
    private int codigo;
    /**
     * Constructor inicializa variables
     */
    public ControladorCitaMedicaDetallada(){
        lista = new HashSet<>();
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
    public void cread(CitaMedicaDetallada objeto) {
        objeto.setCodigo(codigo);
        lista.add(objeto);
        codigo++;
    }
     /**
    * Metodo que lee un objeto por el codigo
    * @param codigo
    * @return 
    */
    public CitaMedicaDetallada read(int codigo) {
        for (CitaMedicaDetallada citaMedica : lista) {
            if(citaMedica.getCodigo()== codigo){
                return citaMedica;
            }
        }        
        return null;
    }
    /**
     * Metodo Actualiza Objeto
     * @param objeto 
     */
    public void update(CitaMedicaDetallada objeto) {
        if(lista.contains(objeto)){
            lista.remove(objeto);
            lista.add(objeto);
        }
    }
    /**
     * Metodo que elimina un objeto por el codigo
     * @param codigo 
     */
    public void delete(int codigo) {
       for (CitaMedicaDetallada citaMedica : lista) {
            if(citaMedica.getCodigo()== codigo){
                lista.remove(citaMedica);
                break;
            }
        }  
    }
    /**
     * Metodo que retorna la lista del objeto
     * @return 
     */
    public Set<CitaMedicaDetallada> getLista() {

        return lista;

    }

}
