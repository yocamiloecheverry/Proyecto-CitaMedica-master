package ec.edu.ups.modelo;

import java.util.Date;

public class Medico extends Persona {
private String especialidad;
private String laboratoio;
private Date fecha;

    public Medico() {
    }

    public Medico(String especialidad, String laboratoio, Date fecha) {
        this.especialidad = especialidad;
        this.laboratoio = laboratoio;
        this.fecha = fecha;
    }

    public Medico(String especialidad, String laboratoio, Date fecha, int codigo, String cedula, String nombre, String telefono, String direccion) {
        super(codigo, cedula, nombre, telefono, direccion);
        this.especialidad = especialidad;
        this.laboratoio = laboratoio;
        this.fecha = fecha;
    }
    

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getLaboratoio() {
        return laboratoio;
    }

    public void setLaboratoio(String laboratoio) {
        this.laboratoio = laboratoio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Medico{" + "especialidad=" + especialidad + ", laboratoio=" + laboratoio + ", fecha=" + fecha + '}';
    }


}
