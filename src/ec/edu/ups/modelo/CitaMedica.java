/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author José Quinde
 */
public class CitaMedica {
    //Declaracion variable
    private int numeroCita;
    private Date fechaCita;
    private double precio;
    private Paciente paciente;
    private Medico medico;
    private Set <CitaMedicaDetallada> listaDetallada;
    /*
    Constructor vacio
    */
    public CitaMedica() {
    }

    /*
    Constructor con todos los datos
     */
    public CitaMedica(int numeroCita, Date fechaCita, double precio, Paciente paciente, Medico medico, Set<CitaMedicaDetallada> listaDetallada) {
        this.numeroCita = numeroCita;
        this.fechaCita = fechaCita;
        this.precio = precio;
        this.paciente = paciente;
        this.medico = medico;
        this.listaDetallada = listaDetallada;
    }
    

    public int getNumeroCita() {
        return numeroCita;
    }

    public void setNumeroCita(int numeroCita) {
        this.numeroCita = numeroCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Set<CitaMedicaDetallada> getListaDetallada() {
        return listaDetallada;
    }

    public void setListaDetallada(Set<CitaMedicaDetallada> listaDetallada) {
        this.listaDetallada = listaDetallada;
    }
    
    /*
    devuelve el toString
     */
    @Override
    public String toString() {
        return "CitaMedica{" + "numeroCita=" + numeroCita + ", fechaCita=" + fechaCita + ", precio=" + precio + ", paciente=" + paciente + ", medico=" + medico + ", listaDetallada=" + listaDetallada + '}';
    }
   
    
    
 
}
