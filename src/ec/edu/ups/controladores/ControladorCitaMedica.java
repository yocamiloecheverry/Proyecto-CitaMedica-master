/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.ups.controladores;

import ec.edu.ups.modelo.CitaMedica;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author José Quinde
 */
public class ControladorCitaMedica {
   //Declaracion de variables
    private Set<CitaMedica> lista;
    private int codigo;
    /**
     * Constructor inicializa variables
     */
    public ControladorCitaMedica(){
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
    public void cread(CitaMedica objeto) {
        objeto.setNumeroCita(codigo);
        lista.add(objeto);
        codigo++;
    }
     /**
    * Metodo que lee un objeto por el codigo
    * @param codigo
    * @return 
    */
    public CitaMedica read(int codigo) {
        for (CitaMedica citaMedica : lista) {
            if(citaMedica.getNumeroCita()== codigo){
                return citaMedica;
            }
        }        
        return null;
    }
    /**
     * Metodo Actualiza Objeto
     * @param objeto 
     */
    public void update(CitaMedica objeto) {
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
       for (CitaMedica citaMedica : lista) {
            if(citaMedica.getNumeroCita()== codigo){
                lista.remove(citaMedica);
                break;
            }
        }  
    }
    /**
     * Metodo que retorna la lista del objeto
     * @return 
     */
    public Set<CitaMedica> getLista() {

        return lista;

    }

}
