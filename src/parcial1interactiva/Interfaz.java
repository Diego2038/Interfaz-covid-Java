/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1interactiva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author Juan Diego Gil Trujillo 1747240 - 3743
 */
public class Interfaz extends JFrame{
    private Estadistica ciudadanos;
    
    // Componentes atómicos
   private JLabel nombre, id, edadl,ocupacion,cormobilidad,fotoGobierno;
   private JTextField tnombre,tid;
   private JButton bMostrarCiudadanos,bIngresarCiudadano;
   private JTextArea salida;
   private JScrollPane scrollxd;
   
   private JComboBox edad, cormobilidadJ, ocupacionPersona;
   
   // Paneles
   Container principal;
   JPanel panelA, panelB, panelC, panelD;
   
   /*
   * declaraciones: Método que se encarga en declarar todos los componentes
   * atómicos y paneles del GUI
   * Ingreso: N/A
   * Retorna: Los atributos de la clase ya delcarados y organizados ordenadamente
   */
   private void declaraciones(){
       
       nombre = new JLabel("Nombre:");
       id = new JLabel("Documento de identificación:");
       edadl = new JLabel("Edad:");
       ocupacion = new JLabel("Ocupación:");
       cormobilidad = new JLabel("¿Presenta alguna cormobilidad?:");
       
       tnombre = new JTextField();
       tid = new JTextField();
       salida = new JTextArea();
       salida.setEditable(false);
       scrollxd = new JScrollPane(salida);
       
       bMostrarCiudadanos = new JButton("Mostrar ciudadanos");
       bIngresarCiudadano = new JButton("Ingresar ciudadano");
       
        
        Integer[] edadPer = new Integer[120];
        
        for(int i=0;i<120;i++){
            edadPer[i] = i;
        }
        
        String[] opcCor = {"No","Si"};
        edad = new JComboBox(edadPer);
        JPanel panelFechaNacimiento = new JPanel();
        panelFechaNacimiento.setLayout(new GridLayout(1,1,10,10));
        panelFechaNacimiento.add(edad);
        
        cormobilidadJ = new JComboBox(opcCor);
        JPanel panelFechaIngreso = new JPanel();
        panelFechaIngreso.setLayout(new GridLayout(1,1,10,10));
        panelFechaIngreso.add(cormobilidadJ);
        
        String[] ocupacionc = {"Otro","Personal de salud con contacto directo","Persona de salud sin contacto directo",
        "Personal relacionado con el servicio educativo","Militar","Policía","Bombero","Socorrista",
        "Piloto","Auxiliar de vuelo","Habitante de calle"};
        ocupacionPersona = new JComboBox(ocupacionc);
       
       // Contenedores
       panelA = new JPanel();
       panelA.setLayout(new GridLayout(5,2));
       panelA.add(nombre);
       panelA.add(tnombre);
       panelA.add(id);
       panelA.add(tid);
       panelA.add(edadl);
       panelA.add(edad);
       panelA.add(ocupacion);
       panelA.add(ocupacionPersona);
       panelA.add(cormobilidad);
       panelA.add(panelFechaIngreso);
       panelA.setBorder(BorderFactory.createTitledBorder(
               BorderFactory.createLineBorder(Color.ORANGE,3),"Datos del ciudadano"));
       
       panelB = new JPanel();
       panelB.setLayout(new GridLayout(1,2,10,10));
       panelB.add(bIngresarCiudadano);
       panelB.add(bMostrarCiudadanos);
       
       panelC = new JPanel();
       panelC.setLayout(new BorderLayout());
       Image img= new ImageIcon("src/parcial1interactiva/minSalud.jpg").getImage();
       ImageIcon imgRedimension = new ImageIcon(img.getScaledInstance(300,300,Image.SCALE_SMOOTH));
       fotoGobierno = new JLabel("",imgRedimension,SwingConstants.RIGHT);
       panelC.add(fotoGobierno,BorderLayout.CENTER);
       panelC.add(panelB,BorderLayout.NORTH);
       
       
       panelD = new JPanel();
       panelD.setLayout(new GridLayout(1,2));
       panelD.add(scrollxd);
       panelD.add(panelC);
       
       
       principal = getContentPane();
       principal.setLayout(new BorderLayout());
       principal.add(panelA,BorderLayout.NORTH);
       principal.add(panelD,BorderLayout.CENTER);
       
       
   }
   
   /*
    * Constructor
    */
   public Interfaz(){
       ciudadanos = new Estadistica();
       
       declaraciones();
       setTitle("Ingreso de ciudadanos para la logística de vacunación");
       setSize(800,400);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       /*********** Listeners **********/
       // KeyEvent
       tnombre.addKeyListener(new ManejadorDeEventos());
       tid.addKeyListener(new ManejadorDeEventos());
       
       // ActionEvent
       bMostrarCiudadanos.addActionListener(new ManejadorDeEventos());
       bIngresarCiudadano.addActionListener(new ManejadorDeEventos());
       
   }
   
   public class ManejadorDeEventos implements ActionListener, KeyListener{
       
        /*
        * actionPerformed: Método sobrecargado que maneja los eventos de los botones (para este caso)
        * Ingreso: Los eventos arrojados por los listeners
        * Retorna: Los eventos que se realizan en el método
        */
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == bMostrarCiudadanos){
                salida.setText(ciudadanos.mostrarCiudadanos());
            }else if(ae.getSource() == bIngresarCiudadano){
                
                Persona person = new Persona(tnombre.getText(),
                        tid.getText(),Integer.parseInt(edad.getSelectedItem().toString()),
                        ocupacionPersona.getSelectedItem().toString(),
                        cormobilidadJ.getSelectedItem().toString());
                
                ciudadanos.ingresarCiudadano(person);
                
                JOptionPane.showMessageDialog(null,"Se ha añadido un nuevo ciudadano");
                
                JOptionPane.showMessageDialog(null,person.informacionCiudadano());
                vaciarDatos();
                
            }
        }
        
        // Método para el KeyListener (Maneja los cuadros de texto (son 3, pero sólo se usará 1)
        @Override
        public void keyTyped(KeyEvent ke) {
            // No implementado
        }

        /*
        * keyPressed: Método sobrecargado que maneja los eventos del teclado (para este caso)
        * Ingreso: Los eventos arrojados por los listeners
        * Retorna: Los eventos que se realizan en el método
        */
        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getSource() == tnombre){
                if(ke.getKeyCode() == ke.VK_ENTER) tid.requestFocusInWindow();
            }else if(ke.getSource() == tid){
                if(ke.getKeyCode() == ke.VK_ENTER){
                    bIngresarCiudadano.doClick();
                    tnombre.requestFocusInWindow();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            // No implementado
        }
        
        /*
        * vaciarDatos: Método que se encarga de vaciar los datos de los cuadros de texto
        * Ingreso: N/A
        * Retorna: Realiza el evento de vaciar los carácteres en los cuadros de texto de la GUI
        */
        private void vaciarDatos(){
            tnombre.setText("");
            tid.setText("");
            salida.setText("");
            tnombre.requestFocusInWindow();
        }
       
   }
   
}

