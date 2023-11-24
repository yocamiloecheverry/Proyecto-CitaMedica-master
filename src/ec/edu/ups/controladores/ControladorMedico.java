package ec.edu.ups.controladores;
import ec.edu.ups.modelo.Medico;
import java.util.HashSet;
import java.util.Set;
public class ControladorMedico {
    private Set<Medico> lista;
    private int codigo;

    public ControladorMedico() {
        lista = new HashSet<>();
        codigo = 1;
    }

    public int getCodigo() {
        return codigo;
    }

    public void crear(Medico objeto) {
        objeto.setCodigo(codigo);
        lista.add(objeto);
        codigo++;
    }

    public Medico read(int codigo) {
        for (Medico medico : lista) {
            if (medico.getCodigo() == codigo) {
                return medico;
            }
        }
        return null;
    }

    public Medico readCedula(String cedula) {
        for (Medico medico : lista) {
            if (medico.getCedula().equals(cedula)) {
                return medico;
            }
        }
        return null;
    }

    public void update(Medico objeto) {
        if (lista.contains(objeto)) {
            lista.remove(objeto);
            lista.add(objeto);
        }
    }

    public void delete(int codigo) {
        for (Medico medico : lista) {
            if (medico.getCodigo() == codigo) {
                lista.remove(medico);
                break;
            }
        }
    }

    public Set<Medico> getLista() {

        return lista;

    }

}

    

