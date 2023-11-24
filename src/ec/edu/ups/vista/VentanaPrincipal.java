/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controladores.ControladorCitaMedica;
import ec.edu.ups.controladores.ControladorCitaMedicaDetallada;
import ec.edu.ups.controladores.ControladorMedicina;
import ec.edu.ups.controladores.ControladorMedico;
import ec.edu.ups.controladores.ControladorPaciente;
import ec.edu.ups.controladores.ControladorReceta;
import ec.edu.ups.controladores.ControladorFacturaDetallada;
import ec.edu.ups.vista.citaMedica.VentanaBuscarCitaMedica;
import ec.edu.ups.vista.citaMedica.VentanaCrearCitaMedica;
import ec.edu.ups.vista.citaMedica.VentanaEliminarCitaMedica;
import ec.edu.ups.vista.citaMedica.VentanaListarCitaMedica;
import ec.edu.ups.vista.medicina.VentanaActualizarMedicina;
import ec.edu.ups.vista.medicina.VentanaBuscarMedicina;
import ec.edu.ups.vista.medicina.VentanaCrearMedicina;
import ec.edu.ups.vista.medicina.VentanaEliminarMedicina;
import ec.edu.ups.vista.medicina.VentanaListarMedicina;
import ec.edu.ups.vista.medico.VentanaActualizarMedico;
import ec.edu.ups.vista.medico.VentanaBuscarMedico;
import ec.edu.ups.vista.medico.VentanaCrearMedico;
import ec.edu.ups.vista.medico.VentanaEliminarMedico;
import ec.edu.ups.vista.medico.VentanaListarMedico;
import ec.edu.ups.vista.paciente.VentanaActualizarPaciente;
import ec.edu.ups.vista.paciente.VentanaBuscaPaciente;
import ec.edu.ups.vista.paciente.VentanaCrearPaciente;
import ec.edu.ups.vista.paciente.VentanaEliminarPaciente;
import ec.edu.ups.vista.paciente.VentanaListarPaciente;
import ec.edu.ups.vista.receta.VentanaCrearReceta;
import ec.edu.ups.vista.factura.VentanaCrearFactura;
import ec.edu.ups.vista.factura.VentanaBuscarFactura;
import ec.edu.ups.vista.factura.VentanaAnularFactura;
import ec.edu.ups.vista.factura.VentanaListarFactura;
import ec.edu.ups.controladores.ControladorFactura;
import ec.edu.ups.vista.receta.VentanaActualizarReceta;
import ec.edu.ups.vista.receta.VentanaBuscarReceta;
import ec.edu.ups.vista.receta.VentanaEliminarReceta;
import ec.edu.ups.vista.receta.VentanaListarRecetas;
import java.util.ResourceBundle;
import java.util.Locale;

/**
 *
 * @author Fernanda
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private VentanaCrearPaciente ventanaCrearPaciente;
    private VentanaBuscaPaciente ventanaBuscarPaciente;
    private VentanaActualizarPaciente ventanaActualizarPaciente;
    private VentanaEliminarPaciente ventanaEliminarPaciente;
    private VentanaListarPaciente ventanaListarPaciente;
    private VentanaCrearMedico ventanaCrearMedico;
    private VentanaBuscarMedico ventanaBuscarMedico;
    private VentanaActualizarMedico ventanaActualizarMedico;
    private VentanaEliminarMedico ventanaEliminarMedico;
    private VentanaListarMedico ventanaListarMedico;
    private ControladorPaciente controladorPaciente;
    private ControladorMedico controladorMedico;
    private ControladorCitaMedica controladorCitaMedica;
    private ControladorCitaMedicaDetallada controladorCitaMedicaDetallada;
    private VentanaCrearCitaMedica ventanaCrearCitaMedica;
    private VentanaBuscarCitaMedica ventanaBuscarCitaMedica;
    private VentanaEliminarCitaMedica ventanaEliminarCitaMedica;
    private VentanaListarCitaMedica ventanaListarCitaMedica;
    private VentanaCrearMedicina ventanaCrearMedicina;
    private VentanaBuscarMedicina ventanaBuscarMedicina;
    private VentanaActualizarMedicina ventanaActualizarMedicina;
    private VentanaEliminarMedicina ventanaEliminarMedicina;
    private VentanaListarMedicina ventanaListarMedicina;
    private ControladorMedicina controladorMedicina;
    private ControladorReceta controladorReceta;
    private VentanaCrearReceta ventanaCrearReceta;
    private VentanaBuscarReceta ventanaBuscarReceta;
    private VentanaActualizarReceta ventanaActualizarReceta;
    private VentanaEliminarReceta ventanaEliminarReceta;
    private VentanaListarRecetas ventanaListarReceta;
    private VentanaCrearFactura ventanaCrearFactura;
    private VentanaBuscarFactura ventanaBuscarFactura;
    private VentanaAnularFactura ventanaAnularFactura;
    private VentanaListarFactura ventanaListarFactura;
    private ControladorFactura controladorFactura;
    private ControladorFacturaDetallada controladorFacturaDetallada;
    private Locale localizacion;
    private ResourceBundle mensajes;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        controladorMedico = new ControladorMedico();
        controladorPaciente = new ControladorPaciente();
        controladorCitaMedica = new ControladorCitaMedica();
        controladorCitaMedicaDetallada = new ControladorCitaMedicaDetallada();
        controladorMedicina = new ControladorMedicina();
        controladorReceta = new ControladorReceta();
        controladorFactura = new ControladorFactura();

        localizacion = new Locale("es", "EC");
        Locale.setDefault(localizacion);
        cambiarIdioma();

    }

    public void cambiarIdioma() {

        mensajes = ResourceBundle.getBundle("ec.edu.ups.idiomas.mensajes", Locale.getDefault());
        //cambia el idioma de los menus Paciente,Medico,Medicina,CitaMedica,Receta y el Idioma
        menuPaciente.setText(mensajes.getString("menu.paciente"));
        menuMedico.setText(mensajes.getString("menu.medico"));
        menuMedicina.setText(mensajes.getString("menu.medicina"));
        menuCitamedica.setText(mensajes.getString("citamedica"));
        menuReceta.setText(mensajes.getString("receta"));
        menuIdioma.setText(mensajes.getString("menu.idioma"));
        menuFactura.setText(mensajes.getString("menu.factura"));
        //cambia el idioma del crear Paciente,Medico,Medicina,CitaMedica,Receta
        crearPaciente.setText(mensajes.getString("menu.crear"));
        crearMedico.setText(mensajes.getString("menu.crear"));
        crearMedicina.setText(mensajes.getString("menu.crear"));
        crearCitaMedica.setText(mensajes.getString("menu.crear"));
        crearReceta.setText(mensajes.getString("menu.crear"));
        crearFactura.setText(mensajes.getString("menu.crear"));
        //cambia el idioma del buscar Paciente,Medico,Medicina,CitaMedica,Receta,Idioma
        buscarPaciente.setText(mensajes.getString("menu.buscar"));
        buscarMedico.setText(mensajes.getString("menu.buscar"));
        buscarMedicina.setText(mensajes.getString("menu.buscar"));
        buscarCitaMedica.setText(mensajes.getString("menu.buscar"));
        buscarReceta.setText(mensajes.getString("menu.buscar"));
        buscarFactura.setText(mensajes.getString("menu.buscar"));
        //cambia el idioma del actualizar Paciente,Medico,Medicina,CitaMedica,Receta,Idioma
        actualizarPaciente.setText(mensajes.getString("menu.actualizar"));
        actualizarMedico.setText(mensajes.getString("menu.actualizar"));
        actualizarMedicina.setText(mensajes.getString("menu.actualizar"));
        actualizarReceta.setText(mensajes.getString("menu.actualizar"));
        //cambia el idioma del listar Paciente,Medico,Medicina,CitaMedica,Receta,Idioma
        listarPaciente.setText(mensajes.getString("menu.listar"));
        listarMedico.setText(mensajes.getString("menu.listar"));
        listarMedicina.setText(mensajes.getString("menu.listar"));
        listarCitaMedica.setText(mensajes.getString("menu.listar"));
        listarFactura.setText(mensajes.getString("menu.listar"));
        listarReceta.setText(mensajes.getString("menu.listar"));
        //cambia el idioma del eliminar Paciente,Medico,Medicina,CitaMedica,Receta,Idioma
        eliminarPaciente.setText(mensajes.getString("menu.eliminar"));
        eliminarMedico.setText(mensajes.getString("menu.eliminar"));
        eliminarMedicina.setText(mensajes.getString("menu.eliminar"));
        eliminarCitaMedica.setText(mensajes.getString("menu.eliminar"));
        eliminarReceta.setText(mensajes.getString("menu.eliminar"));
        eliminarFactura.setText(mensajes.getString("anular.factura"));
        //cambiar idioma menu factura

        espanol.setText(mensajes.getString("menu.idioma.español"));
        ingles.setText(mensajes.getString("menu.idioma.ingles"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuPaciente = new javax.swing.JMenu();
        crearPaciente = new javax.swing.JMenuItem();
        buscarPaciente = new javax.swing.JMenuItem();
        actualizarPaciente = new javax.swing.JMenuItem();
        listarPaciente = new javax.swing.JMenuItem();
        eliminarPaciente = new javax.swing.JMenuItem();
        menuMedico = new javax.swing.JMenu();
        crearMedico = new javax.swing.JMenuItem();
        buscarMedico = new javax.swing.JMenuItem();
        actualizarMedico = new javax.swing.JMenuItem();
        listarMedico = new javax.swing.JMenuItem();
        eliminarMedico = new javax.swing.JMenuItem();
        menuMedicina = new javax.swing.JMenu();
        crearMedicina = new javax.swing.JMenuItem();
        buscarMedicina = new javax.swing.JMenuItem();
        actualizarMedicina = new javax.swing.JMenuItem();
        listarMedicina = new javax.swing.JMenuItem();
        eliminarMedicina = new javax.swing.JMenuItem();
        menuCitamedica = new javax.swing.JMenu();
        crearCitaMedica = new javax.swing.JMenuItem();
        buscarCitaMedica = new javax.swing.JMenuItem();
        listarCitaMedica = new javax.swing.JMenuItem();
        eliminarCitaMedica = new javax.swing.JMenuItem();
        menuReceta = new javax.swing.JMenu();
        crearReceta = new javax.swing.JMenuItem();
        buscarReceta = new javax.swing.JMenuItem();
        actualizarReceta = new javax.swing.JMenuItem();
        listarReceta = new javax.swing.JMenuItem();
        eliminarReceta = new javax.swing.JMenuItem();
        menuFactura = new javax.swing.JMenu();
        crearFactura = new javax.swing.JMenuItem();
        buscarFactura = new javax.swing.JMenuItem();
        listarFactura = new javax.swing.JMenuItem();
        eliminarFactura = new javax.swing.JMenuItem();
        menuIdioma = new javax.swing.JMenu();
        espanol = new javax.swing.JMenuItem();
        ingles = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("jMenu4");

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuBar.setBorder(null);
        menuBar.setForeground(new java.awt.Color(153, 102, 255));

        menuPaciente.setMnemonic('f');
        menuPaciente.setText("PACIENTE");

        crearPaciente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        crearPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuCrear.png"))); // NOI18N
        crearPaciente.setMnemonic('o');
        crearPaciente.setText("CREAR");
        crearPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearPacienteActionPerformed(evt);
            }
        });
        menuPaciente.add(crearPaciente);

        buscarPaciente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        buscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuBuscar.png"))); // NOI18N
        buscarPaciente.setMnemonic('s');
        buscarPaciente.setText("BUSCAR");
        buscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPacienteActionPerformed(evt);
            }
        });
        menuPaciente.add(buscarPaciente);

        actualizarPaciente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        actualizarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuActualizar.png"))); // NOI18N
        actualizarPaciente.setMnemonic('a');
        actualizarPaciente.setText("ACTUALIZAR");
        actualizarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarPacienteActionPerformed(evt);
            }
        });
        menuPaciente.add(actualizarPaciente);

        listarPaciente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        listarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuListar.png"))); // NOI18N
        listarPaciente.setMnemonic('x');
        listarPaciente.setText("LISTAR");
        listarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarPacienteActionPerformed(evt);
            }
        });
        menuPaciente.add(listarPaciente);

        eliminarPaciente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        eliminarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuEliminar.png"))); // NOI18N
        eliminarPaciente.setMnemonic('x');
        eliminarPaciente.setText("ELIMINAR");
        eliminarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPacienteActionPerformed(evt);
            }
        });
        menuPaciente.add(eliminarPaciente);

        menuBar.add(menuPaciente);

        menuMedico.setMnemonic('e');
        menuMedico.setText("MEDICO");

        crearMedico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        crearMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuCrear.png"))); // NOI18N
        crearMedico.setMnemonic('t');
        crearMedico.setText("CREAR");
        crearMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearMedicoActionPerformed(evt);
            }
        });
        menuMedico.add(crearMedico);

        buscarMedico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        buscarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuBuscar.png"))); // NOI18N
        buscarMedico.setMnemonic('y');
        buscarMedico.setText("BUSCAR");
        buscarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarMedicoActionPerformed(evt);
            }
        });
        menuMedico.add(buscarMedico);

        actualizarMedico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        actualizarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuActualizar.png"))); // NOI18N
        actualizarMedico.setMnemonic('p');
        actualizarMedico.setText("ACTUALIZAR");
        actualizarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarMedicoActionPerformed(evt);
            }
        });
        menuMedico.add(actualizarMedico);

        listarMedico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        listarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuListar.png"))); // NOI18N
        listarMedico.setMnemonic('d');
        listarMedico.setText("LISTAR");
        listarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarMedicoActionPerformed(evt);
            }
        });
        menuMedico.add(listarMedico);

        eliminarMedico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        eliminarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuEliminar.png"))); // NOI18N
        eliminarMedico.setMnemonic('d');
        eliminarMedico.setText("ELIMINAR");
        eliminarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarMedicoActionPerformed(evt);
            }
        });
        menuMedico.add(eliminarMedico);

        menuBar.add(menuMedico);

        menuMedicina.setMnemonic('h');
        menuMedicina.setText("MEDICINA");

        crearMedicina.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        crearMedicina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuCrear.png"))); // NOI18N
        crearMedicina.setMnemonic('c');
        crearMedicina.setText("CREAR");
        crearMedicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearMedicinaActionPerformed(evt);
            }
        });
        menuMedicina.add(crearMedicina);

        buscarMedicina.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        buscarMedicina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuBuscar.png"))); // NOI18N
        buscarMedicina.setMnemonic('a');
        buscarMedicina.setText("BUSCAR");
        buscarMedicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarMedicinaActionPerformed(evt);
            }
        });
        menuMedicina.add(buscarMedicina);

        actualizarMedicina.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        actualizarMedicina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuActualizar.png"))); // NOI18N
        actualizarMedicina.setMnemonic('a');
        actualizarMedicina.setText("ACTUALIZAR");
        actualizarMedicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarMedicinaActionPerformed(evt);
            }
        });
        menuMedicina.add(actualizarMedicina);

        listarMedicina.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        listarMedicina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuListar.png"))); // NOI18N
        listarMedicina.setMnemonic('a');
        listarMedicina.setText("LISTAR");
        listarMedicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarMedicinaActionPerformed(evt);
            }
        });
        menuMedicina.add(listarMedicina);

        eliminarMedicina.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        eliminarMedicina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuEliminar.png"))); // NOI18N
        eliminarMedicina.setMnemonic('a');
        eliminarMedicina.setText("ELIMINAR");
        eliminarMedicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarMedicinaActionPerformed(evt);
            }
        });
        menuMedicina.add(eliminarMedicina);

        menuBar.add(menuMedicina);

        menuCitamedica.setText("CITA MEDICA");

        crearCitaMedica.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        crearCitaMedica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuCrear.png"))); // NOI18N
        crearCitaMedica.setText("CREAR");
        crearCitaMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCitaMedicaActionPerformed(evt);
            }
        });
        menuCitamedica.add(crearCitaMedica);

        buscarCitaMedica.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        buscarCitaMedica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuBuscar.png"))); // NOI18N
        buscarCitaMedica.setText("BUSCAR");
        buscarCitaMedica.setToolTipText("");
        buscarCitaMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCitaMedicaActionPerformed(evt);
            }
        });
        menuCitamedica.add(buscarCitaMedica);

        listarCitaMedica.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        listarCitaMedica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuListar.png"))); // NOI18N
        listarCitaMedica.setText("LISTAR");
        listarCitaMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarCitaMedicaActionPerformed(evt);
            }
        });
        menuCitamedica.add(listarCitaMedica);

        eliminarCitaMedica.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        eliminarCitaMedica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuEliminar.png"))); // NOI18N
        eliminarCitaMedica.setText("ELIMINAR");
        eliminarCitaMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCitaMedicaActionPerformed(evt);
            }
        });
        menuCitamedica.add(eliminarCitaMedica);

        menuBar.add(menuCitamedica);

        menuReceta.setText("RECETA");

        crearReceta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        crearReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuCrear.png"))); // NOI18N
        crearReceta.setText("CREAR");
        crearReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearRecetaActionPerformed(evt);
            }
        });
        menuReceta.add(crearReceta);

        buscarReceta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        buscarReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuBuscar.png"))); // NOI18N
        buscarReceta.setText("BUSCAR");
        buscarReceta.setToolTipText("");
        buscarReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarRecetaActionPerformed(evt);
            }
        });
        menuReceta.add(buscarReceta);

        actualizarReceta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        actualizarReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuActualizar.png"))); // NOI18N
        actualizarReceta.setText("ACTUALIZAR");
        actualizarReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarRecetaActionPerformed(evt);
            }
        });
        menuReceta.add(actualizarReceta);

        listarReceta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        listarReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuListar.png"))); // NOI18N
        listarReceta.setMnemonic('a');
        listarReceta.setText("LISTAR");
        listarReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarRecetaActionPerformed(evt);
            }
        });
        menuReceta.add(listarReceta);

        eliminarReceta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        eliminarReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuEliminar.png"))); // NOI18N
        eliminarReceta.setText("ELIMINAR");
        eliminarReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarRecetaActionPerformed(evt);
            }
        });
        menuReceta.add(eliminarReceta);

        menuBar.add(menuReceta);

        menuFactura.setMnemonic('h');
        menuFactura.setText("FACTURA");

        crearFactura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        crearFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuCrear.png"))); // NOI18N
        crearFactura.setMnemonic('c');
        crearFactura.setText("CREAR");
        crearFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearFacturaActionPerformed(evt);
            }
        });
        menuFactura.add(crearFactura);

        buscarFactura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        buscarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuBuscar.png"))); // NOI18N
        buscarFactura.setMnemonic('a');
        buscarFactura.setText("BUSCAR");
        buscarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFacturaActionPerformed(evt);
            }
        });
        menuFactura.add(buscarFactura);

        listarFactura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        listarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuListar.png"))); // NOI18N
        listarFactura.setMnemonic('a');
        listarFactura.setText("LISTAR");
        listarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarFacturaActionPerformed(evt);
            }
        });
        menuFactura.add(listarFactura);

        eliminarFactura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        eliminarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuEliminar.png"))); // NOI18N
        eliminarFactura.setMnemonic('a');
        eliminarFactura.setText("ANULAR");
        eliminarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarFacturaActionPerformed(evt);
            }
        });
        menuFactura.add(eliminarFactura);

        menuBar.add(menuFactura);

        menuIdioma.setText("IDIOMA");

        espanol.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        espanol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuIdioma.png"))); // NOI18N
        espanol.setText("ESPAÑOL");
        espanol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espanolActionPerformed(evt);
            }
        });
        menuIdioma.add(espanol);

        ingles.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        ingles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BotonMenuIdioma.png"))); // NOI18N
        ingles.setText("INGLES");
        ingles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inglesActionPerformed(evt);
            }
        });
        menuIdioma.add(ingles);

        menuBar.add(menuIdioma);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1216, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarPacienteActionPerformed
        if (ventanaListarPaciente == null || !ventanaListarPaciente.isVisible()) {
            ventanaListarPaciente = new VentanaListarPaciente(controladorPaciente);
            ventanaListarPaciente.setVisible(true);
            desktopPane.add(ventanaListarPaciente);
            VentanaListarPaciente.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_listarPacienteActionPerformed

    private void buscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPacienteActionPerformed
        if (ventanaBuscarPaciente == null || !ventanaBuscarPaciente.isVisible()) {
            ventanaBuscarPaciente = new VentanaBuscaPaciente(controladorPaciente);
            ventanaBuscarPaciente.setVisible(true);
            desktopPane.add(ventanaBuscarPaciente);
            VentanaBuscaPaciente.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_buscarPacienteActionPerformed

    private void eliminarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPacienteActionPerformed
        if (ventanaEliminarPaciente == null || !ventanaEliminarPaciente.isVisible()) {
            ventanaEliminarPaciente = new VentanaEliminarPaciente(controladorPaciente);
            ventanaEliminarPaciente.setVisible(true);
            desktopPane.add(ventanaEliminarPaciente);
            VentanaEliminarPaciente.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_eliminarPacienteActionPerformed

    private void crearMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearMedicoActionPerformed
        // TODO add your handling code here:
        if (ventanaCrearMedico == null || !ventanaCrearMedico.isVisible()) {
            ventanaCrearMedico = new VentanaCrearMedico(controladorMedico);
            ventanaCrearMedico.setVisible(true);
            desktopPane.add(ventanaCrearMedico);
            VentanaCrearMedico.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_crearMedicoActionPerformed

    private void crearPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPacienteActionPerformed
        // TODO add your handling code here:
        if (ventanaCrearPaciente == null || !ventanaCrearPaciente.isVisible()) {
            ventanaCrearPaciente = new VentanaCrearPaciente(controladorPaciente);
            ventanaCrearPaciente.setVisible(true);
            desktopPane.add(ventanaCrearPaciente);
            VentanaCrearPaciente.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_crearPacienteActionPerformed

    private void buscarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarMedicoActionPerformed
        if (ventanaBuscarMedico == null || !ventanaBuscarMedico.isVisible()) {
            ventanaBuscarMedico = new VentanaBuscarMedico(controladorMedico);
            ventanaBuscarMedico.setVisible(true);
            desktopPane.add(ventanaBuscarMedico);
            VentanaBuscarMedico.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_buscarMedicoActionPerformed

    private void actualizarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarMedicoActionPerformed
        if (ventanaActualizarMedico == null || !ventanaActualizarMedico.isVisible()) {
            ventanaActualizarMedico = new VentanaActualizarMedico(controladorMedico);
            ventanaActualizarMedico.setVisible(true);
            desktopPane.add(ventanaActualizarMedico);
            VentanaActualizarMedico.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_actualizarMedicoActionPerformed

    private void eliminarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarMedicoActionPerformed
        if (ventanaEliminarMedico == null || !ventanaEliminarMedico.isVisible()) {
            ventanaEliminarMedico = new VentanaEliminarMedico(controladorMedico);
            ventanaEliminarMedico.setVisible(true);
            desktopPane.add(ventanaEliminarMedico);
            VentanaEliminarMedico.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_eliminarMedicoActionPerformed

    private void listarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarMedicoActionPerformed
        if (ventanaListarMedico == null || !ventanaListarMedico.isVisible()) {
            ventanaListarMedico = new VentanaListarMedico(controladorMedico);
            ventanaListarMedico.setVisible(true);
            desktopPane.add(ventanaListarMedico);
            VentanaListarMedico.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_listarMedicoActionPerformed

    private void crearMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearMedicinaActionPerformed
        if (ventanaCrearMedicina == null || !ventanaCrearMedicina.isVisible()) {
            ventanaCrearMedicina = new VentanaCrearMedicina(controladorMedicina);
            ventanaCrearMedicina.setVisible(true);
            desktopPane.add(ventanaCrearMedicina);
            VentanaCrearMedicina.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_crearMedicinaActionPerformed

    private void eliminarMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarMedicinaActionPerformed
        if (ventanaEliminarMedicina == null || !ventanaEliminarMedicina.isVisible()) {
            ventanaEliminarMedicina = new VentanaEliminarMedicina(controladorMedicina);
            ventanaEliminarMedicina.setVisible(true);
            desktopPane.add(ventanaEliminarMedicina);
            VentanaEliminarMedicina.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_eliminarMedicinaActionPerformed

    private void buscarMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarMedicinaActionPerformed
        if (ventanaBuscarMedicina == null || !ventanaBuscarMedicina.isVisible()) {
            ventanaBuscarMedicina = new VentanaBuscarMedicina(controladorMedicina);
            ventanaBuscarMedicina.setVisible(true);
            desktopPane.add(ventanaBuscarMedicina);
            VentanaBuscarMedicina.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_buscarMedicinaActionPerformed

    private void actualizarMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarMedicinaActionPerformed
        if (ventanaActualizarMedicina == null || !ventanaActualizarMedicina.isVisible()) {
            ventanaActualizarMedicina = new VentanaActualizarMedicina(controladorMedicina);
            ventanaActualizarMedicina.setVisible(true);
            desktopPane.add(ventanaActualizarMedicina);
            VentanaActualizarMedicina.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_actualizarMedicinaActionPerformed

    private void listarMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarMedicinaActionPerformed
        if (ventanaListarMedicina == null || !ventanaListarMedicina.isVisible()) {
            ventanaListarMedicina = new VentanaListarMedicina(controladorMedicina);
            ventanaListarMedicina.setVisible(true);
            desktopPane.add(ventanaListarMedicina);
            VentanaListarMedicina.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_listarMedicinaActionPerformed

    private void crearCitaMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCitaMedicaActionPerformed
        // TODO add your handling code here:
        if (ventanaCrearCitaMedica == null || !ventanaCrearCitaMedica.isVisible()) {
            ventanaCrearCitaMedica = new VentanaCrearCitaMedica(controladorCitaMedica, controladorCitaMedicaDetallada, controladorPaciente, controladorMedico);
            ventanaCrearCitaMedica.setVisible(true);
            desktopPane.add(ventanaCrearCitaMedica);
            VentanaCrearCitaMedica.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_crearCitaMedicaActionPerformed

    private void listarCitaMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarCitaMedicaActionPerformed
        // TODO add your handling code here:
        if (ventanaListarCitaMedica == null || !ventanaListarCitaMedica.isVisible()) {
            ventanaListarCitaMedica = new VentanaListarCitaMedica(controladorCitaMedica, controladorCitaMedicaDetallada, controladorMedico, controladorPaciente);
            ventanaListarCitaMedica.setVisible(true);
            desktopPane.add(ventanaListarCitaMedica);
            VentanaListarCitaMedica.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_listarCitaMedicaActionPerformed

    private void buscarCitaMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCitaMedicaActionPerformed
        if (ventanaBuscarCitaMedica == null || !ventanaBuscarCitaMedica.isVisible()) {
            ventanaBuscarCitaMedica = new VentanaBuscarCitaMedica(controladorCitaMedica, controladorCitaMedicaDetallada, controladorPaciente, controladorMedico);
            ventanaBuscarCitaMedica.setVisible(true);
            desktopPane.add(ventanaBuscarCitaMedica);
            VentanaBuscarCitaMedica.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_buscarCitaMedicaActionPerformed

    private void eliminarCitaMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCitaMedicaActionPerformed
        if (ventanaEliminarCitaMedica == null || !ventanaEliminarCitaMedica.isVisible()) {
            ventanaEliminarCitaMedica = new VentanaEliminarCitaMedica(controladorCitaMedica);
            ventanaEliminarCitaMedica.setVisible(true);
            desktopPane.add(ventanaEliminarCitaMedica);
            VentanaEliminarCitaMedica.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_eliminarCitaMedicaActionPerformed

    private void actualizarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarPacienteActionPerformed
        if (ventanaActualizarPaciente == null || !ventanaActualizarPaciente.isVisible()) {
            ventanaActualizarPaciente = new VentanaActualizarPaciente(controladorPaciente);
            ventanaActualizarPaciente.setVisible(true);
            desktopPane.add(ventanaActualizarPaciente);
            VentanaActualizarPaciente.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_actualizarPacienteActionPerformed

    private void crearRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearRecetaActionPerformed
        if (ventanaCrearReceta == null || !ventanaCrearReceta.isVisible()) {
            ventanaCrearReceta = new VentanaCrearReceta(controladorReceta, controladorPaciente, controladorMedicina, controladorCitaMedica, controladorCitaMedicaDetallada);
            ventanaCrearReceta.setVisible(true);
            desktopPane.add(ventanaCrearReceta);
            VentanaCrearReceta.cambiarIdioma(localizacion);
        }

    }//GEN-LAST:event_crearRecetaActionPerformed

    private void buscarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarRecetaActionPerformed
        // TODO add your handling code here:
        if (ventanaBuscarReceta == null || !ventanaBuscarReceta.isVisible()) {
            ventanaBuscarReceta = new VentanaBuscarReceta(controladorReceta, controladorPaciente, controladorMedicina, controladorCitaMedica, controladorCitaMedicaDetallada);
            ventanaBuscarReceta.setVisible(true);
            desktopPane.add(ventanaBuscarReceta);
            VentanaBuscarReceta.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_buscarRecetaActionPerformed

    private void eliminarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarRecetaActionPerformed
        // TODO add your handling code here:
        if (ventanaEliminarReceta == null || !ventanaEliminarReceta.isVisible()) {
            ventanaEliminarReceta = new VentanaEliminarReceta(controladorReceta);
            ventanaEliminarReceta.setVisible(true);
            desktopPane.add(ventanaEliminarReceta);
            VentanaEliminarReceta.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_eliminarRecetaActionPerformed

    private void listarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarRecetaActionPerformed
        if (ventanaListarReceta == null || !ventanaListarReceta.isVisible()) {
            ventanaListarReceta = new VentanaListarRecetas(controladorReceta, controladorPaciente, controladorMedicina, controladorCitaMedica, controladorCitaMedicaDetallada);
            ventanaListarReceta.setVisible(true);
            desktopPane.add(ventanaListarReceta);
            VentanaListarRecetas.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_listarRecetaActionPerformed

    private void espanolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_espanolActionPerformed
        // TODO add your handling code here:
        localizacion = new Locale("es", "EC");
        Locale.setDefault(localizacion);
        cambiarIdioma();
        idiomaVentanas();
    }//GEN-LAST:event_espanolActionPerformed

    private void inglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesActionPerformed
        // TODO add your handling code here:
        localizacion = new Locale("en", "US");
        Locale.setDefault(localizacion);
        cambiarIdioma();
        idiomaVentanas();
    }//GEN-LAST:event_inglesActionPerformed

    private void crearFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearFacturaActionPerformed
        // TODO add your handling code here:
        if (ventanaCrearFactura == null || !ventanaCrearFactura.isVisible()) {
            ventanaCrearFactura = new VentanaCrearFactura(controladorCitaMedica, controladorFactura, controladorFacturaDetallada);
            ventanaCrearFactura.setVisible(true);
            desktopPane.add(ventanaCrearFactura);
            VentanaCrearFactura.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_crearFacturaActionPerformed

    private void buscarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFacturaActionPerformed
        // TODO add your handling code here:
        if (ventanaBuscarFactura == null || !ventanaBuscarFactura.isVisible()) {
            ventanaBuscarFactura = new VentanaBuscarFactura(controladorCitaMedica, controladorFactura, controladorFacturaDetallada);
            ventanaBuscarFactura.setVisible(true);
            desktopPane.add(ventanaBuscarFactura);
            VentanaBuscarFactura.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_buscarFacturaActionPerformed

    private void listarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listarFacturaActionPerformed

    private void eliminarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarFacturaActionPerformed
        // TODO add your handling code here:
        if (ventanaAnularFactura == null || !ventanaAnularFactura.isVisible()) {
            ventanaAnularFactura = new VentanaAnularFactura(controladorCitaMedica, controladorFactura, controladorFacturaDetallada);
            ventanaAnularFactura.setVisible(true);
            desktopPane.add(ventanaAnularFactura);
            VentanaAnularFactura.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_eliminarFacturaActionPerformed

    private void actualizarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarRecetaActionPerformed
        if (ventanaActualizarReceta == null || !ventanaActualizarReceta.isVisible()) {
            ventanaActualizarReceta = new VentanaActualizarReceta(controladorReceta, controladorPaciente, controladorMedicina, controladorCitaMedica, controladorCitaMedicaDetallada);
            ventanaActualizarReceta.setVisible(true);
            desktopPane.add(ventanaActualizarReceta);
            VentanaActualizarReceta.cambiarIdioma(localizacion);
        }
    }//GEN-LAST:event_actualizarRecetaActionPerformed

    private void idiomaVentanas() {
        //ventanaPaciente
        if (ventanaCrearPaciente != null && ventanaCrearPaciente.isVisible()) {
            ventanaCrearPaciente.cambiarIdioma(localizacion);
        }
        if (ventanaActualizarPaciente != null && ventanaActualizarPaciente.isVisible()) {
            ventanaActualizarPaciente.cambiarIdioma(localizacion);
        }
        if (ventanaBuscarPaciente != null && ventanaBuscarPaciente.isVisible()) {
            ventanaBuscarPaciente.cambiarIdioma(localizacion);
        }
        if (ventanaEliminarPaciente != null && ventanaEliminarPaciente.isVisible()) {
            ventanaEliminarPaciente.cambiarIdioma(localizacion);
        }
        if (ventanaListarPaciente != null && ventanaListarPaciente.isVisible()) {
            ventanaListarPaciente.cambiarIdioma(localizacion);
        }
        //ventanasMedico
        if (ventanaCrearMedico != null && ventanaCrearMedico.isVisible()) {
            ventanaCrearMedico.cambiarIdioma(localizacion);
        }
        if (ventanaActualizarMedico != null && ventanaActualizarMedico.isVisible()) {
            ventanaActualizarMedico.cambiarIdioma(localizacion);
        }
        if (ventanaBuscarMedico != null && ventanaBuscarMedico.isVisible()) {
            ventanaBuscarMedico.cambiarIdioma(localizacion);
        }
        if (ventanaEliminarMedico != null && ventanaEliminarMedico.isVisible()) {
            ventanaEliminarMedico.cambiarIdioma(localizacion);
        }
        if (ventanaListarMedico != null && ventanaListarMedico.isVisible()) {
            ventanaListarMedico.cambiarIdioma(localizacion);
        }
        //ventanaMedicina
        if (ventanaCrearMedicina != null && ventanaCrearMedicina.isVisible()) {
            ventanaCrearMedicina.cambiarIdioma(localizacion);
        }
        if (ventanaActualizarMedicina != null && ventanaActualizarMedicina.isVisible()) {
            ventanaActualizarMedicina.cambiarIdioma(localizacion);
        }
        if (ventanaBuscarMedicina != null && ventanaBuscarMedicina.isVisible()) {
            ventanaBuscarMedicina.cambiarIdioma(localizacion);
        }
        if (ventanaEliminarMedicina != null && ventanaEliminarMedicina.isVisible()) {
            ventanaEliminarMedicina.cambiarIdioma(localizacion);
        }
        if (ventanaListarMedicina != null && ventanaListarMedicina.isVisible()) {
            ventanaListarMedicina.cambiarIdioma(localizacion);
        }
        //citaMedica
        if (ventanaCrearCitaMedica != null && ventanaCrearCitaMedica.isVisible()) {
            ventanaCrearCitaMedica.cambiarIdioma(localizacion);
        }
        if (ventanaBuscarCitaMedica != null && ventanaBuscarCitaMedica.isVisible()) {
            ventanaBuscarCitaMedica.cambiarIdioma(localizacion);
        }
        if (ventanaEliminarCitaMedica != null && ventanaEliminarCitaMedica.isVisible()) {
            ventanaEliminarCitaMedica.cambiarIdioma(localizacion);
        }
        if (ventanaListarCitaMedica != null && ventanaListarCitaMedica.isVisible()) {
            ventanaListarCitaMedica.cambiarIdioma(localizacion);
        }
        //ventana factura
        if (ventanaCrearFactura != null && ventanaCrearFactura.isVisible()) {
            ventanaCrearFactura.cambiarIdioma(localizacion);
        }
        if (ventanaBuscarFactura != null && ventanaBuscarFactura.isVisible()) {
            ventanaBuscarFactura.cambiarIdioma(localizacion);
        }
        if (ventanaAnularFactura != null && ventanaAnularFactura.isVisible()) {
            ventanaAnularFactura.cambiarIdioma(localizacion);
        }
        //ventanas receta
        if (ventanaCrearReceta != null && ventanaCrearReceta.isVisible()) {
            ventanaCrearReceta.cambiarIdioma(localizacion);
        }
        if (ventanaActualizarReceta != null && ventanaActualizarReceta.isVisible()) {
            ventanaActualizarReceta.cambiarIdioma(localizacion);
        }
        if (ventanaBuscarReceta != null && ventanaBuscarReceta.isVisible()) {
            ventanaBuscarReceta.cambiarIdioma(localizacion);
        }
        if (ventanaEliminarReceta != null && ventanaEliminarReceta.isVisible()) {
            ventanaEliminarReceta.cambiarIdioma(localizacion);
        }
        if (ventanaListarReceta != null && ventanaListarReceta.isVisible()) {
            ventanaListarReceta.cambiarIdioma(localizacion);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem actualizarMedicina;
    private javax.swing.JMenuItem actualizarMedico;
    private javax.swing.JMenuItem actualizarPaciente;
    private javax.swing.JMenuItem actualizarReceta;
    private javax.swing.JMenuItem buscarCitaMedica;
    private javax.swing.JMenuItem buscarFactura;
    private javax.swing.JMenuItem buscarMedicina;
    private javax.swing.JMenuItem buscarMedico;
    private javax.swing.JMenuItem buscarPaciente;
    private javax.swing.JMenuItem buscarReceta;
    private javax.swing.JMenuItem crearCitaMedica;
    private javax.swing.JMenuItem crearFactura;
    private javax.swing.JMenuItem crearMedicina;
    private javax.swing.JMenuItem crearMedico;
    private javax.swing.JMenuItem crearPaciente;
    private javax.swing.JMenuItem crearReceta;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem eliminarCitaMedica;
    private javax.swing.JMenuItem eliminarFactura;
    private javax.swing.JMenuItem eliminarMedicina;
    private javax.swing.JMenuItem eliminarMedico;
    private javax.swing.JMenuItem eliminarPaciente;
    private javax.swing.JMenuItem eliminarReceta;
    private javax.swing.JMenuItem espanol;
    private javax.swing.JMenuItem ingles;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem listarCitaMedica;
    private javax.swing.JMenuItem listarFactura;
    private javax.swing.JMenuItem listarMedicina;
    private javax.swing.JMenuItem listarMedico;
    private javax.swing.JMenuItem listarPaciente;
    private javax.swing.JMenuItem listarReceta;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCitamedica;
    private javax.swing.JMenu menuFactura;
    private javax.swing.JMenu menuIdioma;
    private javax.swing.JMenu menuMedicina;
    private javax.swing.JMenu menuMedico;
    private javax.swing.JMenu menuPaciente;
    private javax.swing.JMenu menuReceta;
    // End of variables declaration//GEN-END:variables

}
