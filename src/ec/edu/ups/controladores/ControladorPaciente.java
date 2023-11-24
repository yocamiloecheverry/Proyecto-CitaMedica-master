package ec.edu.ups.controladores;

import ec.edu.ups.modelo.Paciente;
import java.util.HashSet;
import java.util.Set;

public class ControladorPaciente {

    private Set<Paciente> lista;
    private int codigo;

    public ControladorPaciente() {
        lista = new HashSet<>();
        codigo = 1;
    }

    public int getCodigo() {
        return codigo;
    }

    public void crear(Paciente objeto) {
        objeto.setCodigo(codigo);
        lista.add(objeto);
        codigo++;
    }

    public Paciente read(int codigo) {
        for (Paciente paciente : lista) {
            if (paciente.getCodigo() == codigo) {
                return paciente;
            }
        }
        return null;
    }

    public Paciente readCedula(String cedula) {
        for (Paciente paciente : lista) {
            if (paciente.getCedula().equals(cedula)) {
                return paciente;
            }
        }
        return null;
    }

    public void update(Paciente objeto) {
        if (lista.contains(objeto)) {
            lista.remove(objeto);
            lista.add(objeto);
        }
    }

    public void delete(int codigo) {
        for (Paciente paciente : lista) {
            if (paciente.getCodigo() == codigo) {
                lista.remove(paciente);
                break;
            }
        }
    }

    public Set<Paciente> getLista() {

        return lista;

    }

}
