/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.ups.modelo;

/**
 *
 * @author José Quinde
 */
public class CitaMedicaDetallada {
    //Declaracion variable
    private int codigo;
    private String diagnostico;

    /*
    Constructor vacio
     */
    public CitaMedicaDetallada() {
    }

    /*
    Constructor con todos los datos
     */
    public CitaMedicaDetallada(int codigo, String diagnostico) {
        this.codigo = codigo;
        this.diagnostico = diagnostico;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        return "CitaMedicaDetallada{" + "codigo=" + codigo + ", diagnostico=" + diagnostico + '}';
    }
    
    
    
}

