/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import ec.edu.ups.modelo.Medicina;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author 59398
 */
public class ControladorMedicina {

    private Set<Medicina> lista;
    private int codigo;

    public ControladorMedicina (){
        lista = new HashSet<>();
        codigo = 1;
    }

    public int getCodigo() {
        return codigo;
    }

    public void create(Medicina objeto) {
        objeto.setCodigo(codigo);
        lista.add(objeto);
        codigo++;
    }

    public Medicina read(int codigo) {
        for (Medicina medicina : lista) {
            if(medicina.getCodigo() == codigo){
                return medicina;
            }
        }        
        return null;
    }

    public void update(Medicina objeto) {
        if(lista.contains(objeto)){
            lista.remove(objeto);
            lista.add(objeto);
        }
    }

    public void delete(int codigo) {
       for (Medicina medicina : lista) {
            if(medicina.getCodigo() == codigo){
                lista.remove(medicina);
                break;
            }
        }  
    }

    public Set<Medicina> getLista() {

        return lista;

    }

   
          
}
