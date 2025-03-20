import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame {
    /******************************************* Variables Globales*************************************************/
    private JTextField campoNombre;
    private JTextField campoEdad;
    private JComboBox<String> listadoDeOpciones;
    private JCheckBox[][] asientos;

    public Gui() {
        this.setSize(600, 400);
        this.setTitle("Sistema de entrada de cine");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        formulario();
    }

    private void formulario() {
        // *************************** Conponentes del formulario**************************************************************
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        Color colorFondo= new Color(206, 186, 177);
        panelFormulario.setBackground(colorFondo);
        this.getContentPane().add(panelFormulario);

        GridBagConstraints grid = new GridBagConstraints();
        grid.insets = new Insets(10, 10, 10, 10); // este metodo añade un padding.
        grid.fill = GridBagConstraints.HORIZONTAL;

        JLabel etiquetanombre = new JLabel("Nombre");
        etiquetanombre.setFont(new Font("Roboto", Font.PLAIN, 18));
        etiquetanombre.setForeground(Color.BLACK);
        grid.gridx = 0;
        grid.gridy = 0;
        panelFormulario.add(etiquetanombre, grid);

        campoNombre = new JTextField(20);
        campoNombre.setFont(new Font("Roboto", Font.PLAIN, 20));
        grid.gridx = 1;
        grid.gridy = 0;
        panelFormulario.add(campoNombre, grid);

        JLabel etiquetaEdad = new JLabel("Edad");
        etiquetaEdad.setFont(new Font("Roboto", Font.PLAIN, 18));
        etiquetaEdad.setForeground(Color.BLACK);
        grid.gridx = 0;
        grid.gridy = 1;
        panelFormulario.add(etiquetaEdad, grid);

        campoEdad = new JTextField(20);
        campoEdad.setFont(new Font("Roboto", Font.PLAIN, 20));
        grid.gridx = 1;
        grid.gridy = 1;
        panelFormulario.add(campoEdad, grid);

        JLabel etiquetaDeOPciones = new JLabel("Selecionar Entradas");
        etiquetaDeOPciones.setFont(new Font("Roboto", Font.PLAIN, 18));
        etiquetaDeOPciones.setForeground(Color.BLACK);
        grid.gridx = 0;
        grid.gridy = 2;
        panelFormulario.add(etiquetaDeOPciones, grid);

        String[] opciones = {"Selecciona una opcion", "Entrada General", "Entrada VIP", "Entrada para Estudiantes" };
        listadoDeOpciones = new JComboBox<>(opciones);
        listadoDeOpciones.setFont(new Font("Roboto", Font.PLAIN, 18));
        listadoDeOpciones.setRenderer(new DefaultListCellRenderer(){
           @Override
           public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                   boolean cellHasFocus) {
                    Component c= super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value.equals("Selecciona una opcion")){
                        setEnabled(false);
                    }else if (value. equals("Entrada General")) {
                        Color verdePersonalizado= new Color(166,188,54);
                        setBackground(verdePersonalizado); 
                    }else if (value.equals("Entrada VIP")){
                        Color amarilloPersonalizado= new Color(249,221,54);
                        setBackground(amarilloPersonalizado);
                    }else if (value.equals("Entrada para Estudiantes")){
                        Color celestePersonalizado= new Color(189,211,206);
                        setBackground(celestePersonalizado);  
                    }
                    return c;
           }
        });
        grid.gridx = 1;
        grid.gridy = 2;
        panelFormulario.add(listadoDeOpciones, grid);

        JLabel etiquetaSalas = new JLabel("Salas");
        etiquetaSalas.setFont(new Font("Roboto", Font.PLAIN, 18));
        etiquetaSalas.setForeground(Color.BLACK);
        grid.gridx = 0;
        grid.gridy = 3;
        panelFormulario.add(etiquetaSalas, grid);

        JPanel panelAsientos = new JPanel(new GridBagLayout());
        Color colorPanel= new Color(223,180,148);
        panelAsientos.setBackground(colorPanel);
        grid.gridx = 1;
        grid.gridy = 3;
        grid.gridwidth = 2;
        panelFormulario.add(panelAsientos, grid);

        asientos = new JCheckBox[10][10];
        GridBagConstraints asientoGrid = new GridBagConstraints();
        asientoGrid.insets = new Insets(2, 2, 2, 2);

        for (int j = 0; j < 10; j++) {
            JLabel etiquetaColumna = new JLabel(String.valueOf(j + 1));
            asientoGrid.gridx = j + 1;
            asientoGrid.gridy = 0;
            panelAsientos.add(etiquetaColumna, asientoGrid);
        }

        for (int i = 0; i < 10; i++) {
            JLabel etiquetaFila = new JLabel(String.valueOf((char) ('A' + i)));
            asientoGrid.gridx = 0;
            asientoGrid.gridy = i + 1;
            panelAsientos.add(etiquetaFila, asientoGrid);

            for (int j = 0; j < 10; j++) {
                asientos[i][j] = new JCheckBox();
                asientos[i][j].setBackground(colorPanel);
                asientos[i][j].setEnabled(false);
                asientoGrid.gridx = j + 1;
                asientoGrid.gridy = i + 1;
                panelAsientos.add(asientos[i][j], asientoGrid);
            }
        }

        JButton botonEnviar = new JButton();
        botonEnviar.setText("Enviar");
        botonEnviar.setFont(new Font("Roboto", Font.BOLD, 18));
        Color colorEnviar= new Color(23,80,106);
        botonEnviar.setBackground(colorEnviar);
        botonEnviar.setForeground(Color.WHITE);
        grid.gridx = 1;
        grid.gridy = 4;
        panelFormulario.add(botonEnviar, grid);

        // ***************************************Boton Mostrar************************************************ */
        JButton botonMostrar = new JButton("Mostrar Datos");
        Color customColor= new Color(52,81,58);
        botonMostrar.setBackground(customColor);
        botonMostrar.setFont(new Font("Roboto", Font.BOLD, 18));
        botonMostrar.setForeground(Color.WHITE);
        grid.gridx = 1;
        grid.gridy = 5;
        panelFormulario.add(botonMostrar, grid);
        // **************************************EVENTOS*****************************************************************/
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });
        botonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDatos();
            }
        });

        listadoDeOpciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarAsientos();

            }
        });

        listadoDeOpciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listadoDeOpciones.getSelectedItem().equals("Selecciona una opcion")){
                    listadoDeOpciones.setSelectedIndex(1);  
                }
            }
        });
    }

    /******************************************* Metodos *************************************************/
    public void guardarDatos() {
        try {
            // Se encargan de extraer los datos de los campos del formulario.
            String nombre = campoNombre.getText();
            String edad = campoEdad.getText();
            String tipoEntrada = (String) listadoDeOpciones.getSelectedItem();

            StringBuilder asientosSeleccionados = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (asientos[i][j].isSelected()) {
                        asientosSeleccionados.append((char) ('A' + i)).append(j + 1).append(",");
                    }
                }
            }
            // Esta condicional se encarga de comprobar que los campos esten vacios.
            if (nombre.isEmpty() || edad.isEmpty() || asientosSeleccionados.length() == 0) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos");
                return;
            }
            File carpeta = new File("Datos");
            carpeta.mkdir();
            FileWriter archivo = new FileWriter("Datos/reservas.txt", true);
            BufferedWriter escritor = new BufferedWriter(archivo);
            escritor.write("Nombre: " + nombre + "\n");
            escritor.write("Edad: " + edad + "\n");
            escritor.write("Tipo de Entrada: " + tipoEntrada + "\n");
            escritor.write("Asientos: " + asientosSeleccionados.toString() + "\n");
            escritor.write("------------------------\n");
            escritor.close();

            JOptionPane.showMessageDialog(this, "Datos guardados exitosamente");
            campoNombre.setText("");
            campoEdad.setText("");
            listadoDeOpciones.setSelectedIndex(0);
            actualizarAsientos();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + ex.getMessage());
        }
    }

    private void mostrarDatos() {

    }

    private void actualizarAsientos() {
        String opcion = (String) listadoDeOpciones.getSelectedItem();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                asientos[i][j].setEnabled(true);
                asientos[i][j].setSelected(false);
            }
        }
        if (opcion.equals("Entrada para Estudiantes")) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j < 8) {
                        asientos[i][j].setEnabled(false);
                    }
                }
            }
        } else if (opcion.equals("Entrada VIP")) {
            // Primero deshabilitar todos los asientos
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    asientos[i][j].setEnabled(false);
                }
            }

            String[] asientosVIP = {
                    "E3", "F3", "E4", "F4", "D5", "E5", "F5", "G5",
                    "D6", "E6", "F6", "G6", "C7", "D7", "E7", "F7",
                    "G7", "H7", "C8", "D8", "E8", "F8", "G8", "H8"
            };

            // Habilitar solo los asientos VIP
            for (String asiento : asientosVIP) {
                int fila = asiento.charAt(0) - 'A'; // Convertir letra a índice (A=0, B=1, etc)
                int columna = Integer.parseInt(asiento.substring(1)) - 1; // Convertir número a índice
                asientos[fila][columna].setEnabled(true);
            }
        } else if (opcion.equals("Entrada General")) {
            for (int i=0; i< 10; i++){
                for (int j=0; j< 10; j++){
                    asientos[i][j].setEnabled(true);
                }
            } 
            // Este for se encarga de desabilitar la columna 9 y 1o de la sala.
            for (int i = 0; i < 10; i++) {
                asientos[i][8].setEnabled(false);
                asientos[i][9].setEnabled(false);
            }

            String [] asientosVIP={
                "E3", "F3", "E4", "F4", "D5", "E5", "F5", "G5",
                "D6", "E6", "F6", "G6", "C7", "D7", "E7", "F7",
                "G7", "H7", "C8", "D8", "E8", "F8", "G8", "H8"
            };
            for (String asiento : asientosVIP) {
                int fila = asiento.charAt(0) - 'A'; // Convertir letra a índice (A=0, B=1, etc)
                int columna = Integer.parseInt(asiento.substring(1)) - 1; // Convertir número a índice
                asientos[fila][columna].setEnabled(false);
            }
            
        }

    }
}