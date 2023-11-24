package ec.edu.ups.vista.receta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ec.edu.ups.controladores.ControladorCitaMedica;
import ec.edu.ups.controladores.ControladorCitaMedicaDetallada;
import ec.edu.ups.controladores.ControladorMedicina;
import ec.edu.ups.controladores.ControladorPaciente;
import ec.edu.ups.controladores.ControladorReceta;
import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.CitaMedicaDetallada;
import ec.edu.ups.modelo.Medicina;
import ec.edu.ups.modelo.Paciente;
import ec.edu.ups.modelo.Receta;
import static ec.edu.ups.vista.citaMedica.VentanaBuscarCitaMedica.modelo;
import static ec.edu.ups.vista.medicina.VentanaActualizarMedicina.txtNombre;
import ec.edu.ups.vista.paciente.VentanaCrearPaciente;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 59398
 */
public class VentanaCrearReceta extends javax.swing.JInternalFrame {
    private ControladorReceta controladorReceta;
    private Paciente paciente;
    private CitaMedica citaMedica;
    private ControladorMedicina controladorMedicina;
    private ControladorPaciente controladorPaciente;
    private ControladorCitaMedica controladorCitaMedica;
    private ControladorCitaMedicaDetallada controladorCitaMedicaDetallada;
    private Set<Paciente> listaPacientes;
    private Set<Medicina> listaMedicina;
    private Set<CitaMedica> listaCitaMedicas;
    private Set<CitaMedicaDetallada> citaMedicaDetalladas;
    private CitaMedicaDetallada detalle;
    private VentanaCrearPaciente ventanaCrearPaciente;
    private VentanaCrearReceta ventanaCrearReceta;
    public static NuevoModelo modelo;
    Receta receta;
    Paciente paciente1;
    String nombrePaciente;
    private Locale localizacion;
    private static ResourceBundle mensajes;
 
    /**
     * Creates new form VentanaCrearReceta
     */
    public VentanaCrearReceta(ControladorReceta controladorReceta, ControladorPaciente controladorPaciente, ControladorMedicina controladorMedicina, ControladorCitaMedica controladorCitaMedica,ControladorCitaMedicaDetallada controladorCitaMedicaDetallada) {
        initComponents();
        this.controladorReceta = controladorReceta;
        this.controladorPaciente =  controladorPaciente;
        this.controladorMedicina = controladorMedicina;
        this.controladorCitaMedica=controladorCitaMedica;
        this.controladorCitaMedicaDetallada=controladorCitaMedicaDetallada;
        txtCodigo.setText(String.valueOf(this.controladorReceta.getCodigo()));
        //receta = new HashSet<>(); 
        txtFecha.setText(fechaActual());
        listaPacientes= controladorPaciente.getLista();
         for (Paciente paciente : listaPacientes) {
            cbxPaciente.addItem(paciente.getNombre());            
        }
        listaMedicina= controladorMedicina.getLista();
        for (Medicina medicina : listaMedicina) {
            cbxMedicina.addItem(medicina.getNombre());            
        }
        pacienteBuscado();
        medicinaBuscada();
    }
    public static void cambiarIdioma(Locale localizacion) {
        mensajes = ResourceBundle.getBundle("ec.edu.ups.idiomas.mensajes", Locale.getDefault());
        lblMenuCrearP.setText(mensajes.getString("crear.receta"));
        lblcodigo.setText(mensajes.getString("codigo"));
        lblPaciente.setText(mensajes.getString("paciente"));
        lblCedula.setText(mensajes.getString("cedula"));
        lblDireccion.setText(mensajes.getString("direccion"));
        lblNumCitaMedica.setText(mensajes.getString("num.cita.medica"));
        lblmedico.setText(mensajes.getString("medico"));
        lblFecha.setText(mensajes.getString("fecha"));
        lblTelefono.setText(mensajes.getString("telefono"));
        lblSintomas.setText(mensajes.getString("sintomas"));
        lblespecialidad.setText(mensajes.getString("especialidad"));
        lblMedicina.setText(mensajes.getString("medicina"));
        lblDescripcion.setText(mensajes.getString("descripcion"));
        lblIndicaciones.setText(mensajes.getString("indicaciones"));
        lblMarca.setText(mensajes.getString("marca"));
        lblPrecio.setText(mensajes.getString("precio"));
        lblguardar.setText(mensajes.getString("guardar"));
        lblcancelar.setText(mensajes.getString("cancelar"));
        Object[] columnas = {mensajes.getString("codigo"), mensajes.getString("diagnostico")};
        //modelo.setColumnIdentifiers(columnas);
    }
    
     public static String fechaActual() {
        Date fecha1 = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        return formato.format(fecha1);
    }

     public void pacienteBuscado(){
        Paciente paciente = buscarPaciente();
        txtMedico.setText(paciente.getCedula());
        txtDireccion.setText(paciente.getDireccion());
        txtCedula1.setText(paciente.getCedula());
        txtTelefono.setText(paciente.getTelefono());
        txtSintomas.setText(paciente.getSintomas());
        nombrePaciente=paciente.getNombre();
        
    }
      public Paciente buscarPaciente() {
        Paciente p = new Paciente();
        for (Paciente paciente : listaPacientes) {
            if (cbxPaciente.getSelectedItem().toString().equalsIgnoreCase(paciente.getNombre())) {
                p = paciente;
            }
        }
        return p;
    }
       public void medicinaBuscada(){
        Medicina medicina = buscarMedicina();
        txtMarca.setText(medicina.getMarca());
        txtDescripcion.setText(medicina.getDescripcion());
        txtPrecio.setText(String.valueOf(medicina.getPrecio()));
    }
       public void citaMedicaBuscada(){
        CitaMedica citaMedica=buscarCitaMedica();
        txtMedico.setText(citaMedica.getMedico().getNombre());
        txtEspecialidad.setText(citaMedica.getMedico().getEspecialidad());
        citaMedicaDetalladas = citaMedica.getListaDetallada();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(citaMedica.getFechaCita());
        txtFecha.setText(fecha);
        modelo = new NuevoModelo();
        Object[] columnas = {"Codigo ", "Diagnostico"};
        modelo.setColumnIdentifiers(columnas);
        for (CitaMedicaDetallada citaMedicaDetallada : citaMedicaDetalladas) {
            Object[] fila = {citaMedicaDetallada.getCodigo(), citaMedicaDetallada.getDiagnostico()};
            modelo.addRow(fila);
        }
        tblDetalle2.setModel(modelo);
    }
    
      public Medicina buscarMedicina() {
        Medicina m = new Medicina();
        for (Medicina medicina : listaMedicina) {
            if (cbxMedicina.getSelectedItem().toString().equalsIgnoreCase(medicina.getNombre())) {
                m = medicina;
            }
        }
        return m;
    }
     public CitaMedica buscarCitaMedica() {
        CitaMedica cm=new CitaMedica();
        for (CitaMedica citaMedica : listaCitaMedicas) {                
            if (cbxCitaMedica.getSelectedItem().toString().equalsIgnoreCase(String.valueOf(citaMedica.getNumeroCita()))) {
                cm = citaMedica;
            }
            
        }
        return cm;
    }  
     public void llenarComboCita(){
       listaCitaMedicas= controladorCitaMedica.getLista();
       cbxCitaMedica.removeAllItems();
        for (CitaMedica citaMedica : listaCitaMedicas) {
            if(citaMedica.getPaciente().getNombre()==nombrePaciente){ 
            cbxCitaMedica.addItem(String.valueOf(citaMedica.getNumeroCita()));  
            }
        }   
     }
     /**
    *Metodo que hereda los datos del DefaulTableModel sirva para poder hacer editables o no las columnas
    */
    public class NuevoModelo extends DefaultTableModel{
    /**
     * Define la posibilidad de editar las columnas
     */    
    public final boolean [] TblColums= {false,false};

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

        lblMenuCrearP = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblPaciente = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtMedico = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        lblSintomas = new javax.swing.JLabel();
        txtSintomas = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        cbxPaciente = new javax.swing.JComboBox();
        lblcodigo = new javax.swing.JLabel();
        cbxCitaMedica = new javax.swing.JComboBox();
        lblmedico = new javax.swing.JLabel();
        lblespecialidad = new javax.swing.JLabel();
        txtCedula1 = new javax.swing.JTextField();
        txtEspecialidad = new javax.swing.JTextField();
        lblNumCitaMedica = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDetalle2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtPrecio = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        cbxMedicina = new javax.swing.JComboBox();
        txtDescripcion = new javax.swing.JTextField();
        txtIndicaciones = new javax.swing.JTextField();
        lblMedicina = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblIndicaciones = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        lblcancelar = new javax.swing.JLabel();
        lblguardar = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        lblMenuCrearP.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblMenuCrearP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuCrearP.setText("CREAR RECETA");
        lblMenuCrearP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setToolTipText("");

        lblPaciente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPaciente.setText("PACIENTE");
        lblPaciente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTelefono.setText("TELEFONO");
        lblTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setEnabled(false);

        lblCedula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCedula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula.setText("CEDULA");
        lblCedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtMedico.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtMedico.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDireccion.setText("DIRECCION");
        lblDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setToolTipText("");

        lblSintomas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSintomas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSintomas.setText("SINTOMAS");
        lblSintomas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblFecha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("FECHA");
        lblFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtFecha.setEditable(false);

        cbxPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPacienteActionPerformed(evt);
            }
        });

        lblcodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblcodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcodigo.setText("CODIGO");
        lblcodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbxCitaMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCitaMedicaActionPerformed(evt);
            }
        });

        lblmedico.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblmedico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblmedico.setText("MÉDICO");
        lblmedico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblespecialidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblespecialidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblespecialidad.setText("ESPECIALIDAD");
        lblespecialidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtCedula1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtCedula1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtEspecialidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblNumCitaMedica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNumCitaMedica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumCitaMedica.setText("NUMERO CITA  MEDICA");
        lblNumCitaMedica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblmedico, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCedula1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSintomas)))))
                        .addGap(119, 119, 119))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblNumCitaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxCitaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCedula1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cbxPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumCitaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxCitaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblmedico, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        tblDetalle2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "CÓDIGO", "DIAGNOSTICO"
            }
        ));
        tblDetalle2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDetalle2KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblDetalle2);

        lblMarca.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMarca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMarca.setText("MARCA");
        lblMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecio.setText("PRECIO");
        lblPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbxMedicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedicinaActionPerformed(evt);
            }
        });

        txtIndicaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIndicacionesActionPerformed(evt);
            }
        });

        lblMedicina.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMedicina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMedicina.setText("MEDICINA");
        lblMedicina.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescripcion.setText("DESCRIPCION");
        lblDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblIndicaciones.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIndicaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIndicaciones.setText("INDICACIONES");
        lblIndicaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/guardar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/cancelar.png"))); // NOI18N
        btncancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        lblcancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblcancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcancelar.setText("CANCELAR");
        lblcancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblguardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblguardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblguardar.setText("GUARDAR");
        lblguardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMedicina, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIndicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMedicina, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(txtIndicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMedicina, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMedicina, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIndicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtIndicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(181, 181, 181))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(292, 292, 292)
                            .addComponent(lblMenuCrearP, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblMenuCrearP, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void cbxPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPacienteActionPerformed
        //Selecciona el producto dependiendo la opcion escojida en el jcomboBox
        pacienteBuscado();
        llenarComboCita();
        citaMedicaBuscada();
    }//GEN-LAST:event_cbxPacienteActionPerformed

    private void cbxMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMedicinaActionPerformed
        //Selecciona el producto dependiendo la opcion escojida en el jcomboBox
        medicinaBuscada();
    }//GEN-LAST:event_cbxMedicinaActionPerformed

    private void txtIndicacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndicacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndicacionesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Receta receta=new Receta();
        Paciente paciente = buscarPaciente();
        Medicina medicina = buscarMedicina();
        CitaMedica citaMedica=buscarCitaMedica();
        receta.setIndicaciones(txtIndicaciones.getText());
        receta.setPaciente(paciente);
        receta.setMedicina(medicina);
        receta.setCitaMedica(citaMedica);
        controladorReceta.cread(receta);
        JOptionPane.showMessageDialog(this, "LA CITA MEDICA SE A CREADO");
        txtCodigo.setText(String.valueOf(this.controladorReceta.getCodigo()));
        txtIndicaciones.setText("");
         
        /*
        Receta receta  = new Receta();
        Paciente paciente = buscarPaciente();
        Medicina medicina = buscarMedicina();
        receta.setCedula(txtCedula.getText());
        receta.setNombre(txtNombre.getText());
        receta.setSintomas(txtSintomas.getText());
        receta.setDireccion(txtDireccion.getText());
        receta.setTelefono(txtTelefono.getText());
        receta.setIndicaciones(txtIndicaciones.getText());
        receta.setPrecio(Double.parseDouble(txtPrecio.getText()));
        receta.setDescripcion(txtDescripcion.getText());
        receta.setMarca(txtMarca.getText());
        String fecha1 = txtFecha.getText();
        DateFormat format = new SimpleDateFormat("DD/MM/YYYY"); 
        Date fecha=null;
        receta.setFecha(fecha);
        receta.setMedicina(medicina);
        receta.setPaciente(paciente); 
        controladorReceta.cread(receta);
        JOptionPane.showMessageDialog(this, "LA RECETA SE A CREADO");
        txtCodigo.setText(String.valueOf(this.controladorReceta.getCodigo()));
        txtCedula.setText("");
        txtNombre.setText("");
        txtSintomas.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtMarca.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtIndicaciones.setText("");
                */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxCitaMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCitaMedicaActionPerformed
        // TODO add your handling code here:
        llenarComboCita();
        citaMedicaBuscada();
    }//GEN-LAST:event_cbxCitaMedicaActionPerformed

    private void tblDetalle2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDetalle2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDetalle2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JComboBox cbxCitaMedica;
    private javax.swing.JComboBox cbxMedicina;
    private javax.swing.JComboBox cbxPaciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel lblCedula;
    public static javax.swing.JLabel lblDescripcion;
    public static javax.swing.JLabel lblDireccion;
    public static javax.swing.JLabel lblFecha;
    public static javax.swing.JLabel lblIndicaciones;
    public static javax.swing.JLabel lblMarca;
    public static javax.swing.JLabel lblMedicina;
    public static javax.swing.JLabel lblMenuCrearP;
    public static javax.swing.JLabel lblNumCitaMedica;
    public static javax.swing.JLabel lblPaciente;
    public static javax.swing.JLabel lblPrecio;
    public static javax.swing.JLabel lblSintomas;
    public static javax.swing.JLabel lblTelefono;
    public static javax.swing.JLabel lblcancelar;
    public static javax.swing.JLabel lblcodigo;
    public static javax.swing.JLabel lblespecialidad;
    public static javax.swing.JLabel lblguardar;
    public static javax.swing.JLabel lblmedico;
    private javax.swing.JTable tblDetalle2;
    public static javax.swing.JTextField txtCedula1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIndicaciones;
    private javax.swing.JTextField txtMarca;
    public static javax.swing.JTextField txtMedico;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSintomas;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
