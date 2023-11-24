/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista.citaMedica;

import ec.edu.ups.controladores.ControladorCitaMedica;
import ec.edu.ups.controladores.ControladorCitaMedicaDetallada;
import ec.edu.ups.controladores.ControladorMedico;
import ec.edu.ups.controladores.ControladorPaciente;
import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.CitaMedicaDetallada;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author José Quinde
 */
public class VentanaListarCitaMedica extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaListarCitaMedica
     */
    private ControladorCitaMedica controladorCitaMedica;
    private ControladorCitaMedicaDetallada controladorCitaMedicaDetallada;
    private ControladorPaciente controladorPaciente;
    private ControladorMedico controladorMedico;
    public static NuevoModelo modelo;
    private Locale localizacion;
    private static ResourceBundle mensajes;
    JComboBox listaDet;

    public VentanaListarCitaMedica(ControladorCitaMedica controladorCitaMedica, ControladorCitaMedicaDetallada controladorCitaMedicaDetallada, ControladorMedico controladorMedico, ControladorPaciente controladorPaciente) {
        initComponents();
        this.controladorCitaMedica = controladorCitaMedica;
        this.controladorCitaMedicaDetallada = controladorCitaMedicaDetallada;
        this.controladorPaciente = controladorPaciente;
        this.controladorMedico = controladorMedico;
        modelo = new NuevoModelo();        
        Object[] columnas = {"Numero Cita", "Paciente", "Cedula", "Direccion", "Telefono", "Médico", "Especialidad", "Laboratorio", "Fecha", "Precio"};
        modelo.setColumnIdentifiers(columnas);
        tabla.setModel(modelo);

        llenarTabla();
    }

    public static void cambiarIdioma(Locale localizacion) {
        mensajes = ResourceBundle.getBundle("ec.edu.ups.idiomas.mensajes", Locale.getDefault());
        Object[] columnas = {mensajes.getString("numerocita"), mensajes.getString("paciente"), mensajes.getString("cedula"), mensajes.getString("direccion"), mensajes.getString("telefono"), mensajes.getString("medico"), mensajes.getString("especialidad"), mensajes.getString("laboratorio"), mensajes.getString("fecha"), mensajes.getString("precio")};
        modelo.setColumnIdentifiers(columnas);
    }

    /**
    Metodo que llena con los datos del objeto a la tabla
     */
    public void llenarTabla() {
        Set<CitaMedica> Lista = controladorCitaMedica.getLista();
       // Set<CitaMedicaDetallada> citaMedicaDetalladas;
        
        for (CitaMedica citaMedica : Lista) {         
           // listaDet=new JComboBox();
            //TableColumn columna = this.tabla.getColumnModel().getColumn(8);
            //citaMedicaDetalladas = citaMedica.getListaDetallada();
            //Ingresa al comboBox los detalles de la cita medica
            /*
            for (CitaMedicaDetallada citaMedicaDetallada : citaMedicaDetalladas) {
                String diag = citaMedicaDetallada.getDiagnostico();
                System.out.println(diag);
                listaDet.addItem(diag);
            }
        */
            Date fecha;
            fecha=citaMedica.getFechaCita();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fechaNueva=formato.format(fecha);          
            //tabla.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(listaDet));
           // columna.setCellEditor(new DefaultCellEditor(listaDet));
           
            Object[] datos = {citaMedica.getNumeroCita(),
                citaMedica.getPaciente().getNombre(),
                citaMedica.getPaciente().getCedula(),
                citaMedica.getPaciente().getDireccion(),
                citaMedica.getPaciente().getTelefono(),
                citaMedica.getMedico().getNombre(),
                citaMedica.getMedico().getEspecialidad(),
                citaMedica.getMedico().getLaboratoio(),
                fechaNueva,
                citaMedica.getPrecio()};

            modelo.addRow(datos);

        }
    }
    /**
    *Metodo que hereda los datos del DefaulTableModel sirva para poder hacer editables o no las columnas
    */
    public class NuevoModelo extends DefaultTableModel{
    /**
     * Define la posibilidad de editar las columnas
     */    
    public final boolean [] TblColums= {false,false,false,false,false,false,false,false,false,false};

        @Override
        public boolean isCellEditable(int row, int column) {
            return this.TblColums[column];
        }
    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Listar Cita Medica");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Cita", "Paciente", "Cedula", "Direccion", "Telefono", "Doctor", "Especialidad", "Laboratorio", "Fecha", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
