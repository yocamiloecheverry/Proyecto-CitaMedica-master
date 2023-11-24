package ec.edu.ups.modelo;

public class Paciente extends Persona {

private String sintomas;

    public Paciente() {
    }

    public Paciente(String sintomas) {
        this.sintomas = sintomas;
    }

    public Paciente(String sintomas, int codigo, String cedula, String nombre, String telefono, String direccion) {
        super(codigo, cedula, nombre, telefono, direccion);
        this.sintomas = sintomas;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    @Override
    public String toString() {
       return  "Paciente{" + "sintomas=" + sintomas + '}';
    }

   
}
