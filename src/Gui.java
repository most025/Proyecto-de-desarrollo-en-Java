import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame {
    /****************************************** Variables Globales*************************************************/
    //private ArrayList<Cliente> personas;
    private JTextField campoNombre;
    private JTextField campoEdad;
    private JComboBox<String> listadoDeOpciones;
    private JCheckBox [][] asientos;

    public Gui() {
        this.setSize(600, 400);
        this.setTitle("Sistema de entrada de cine");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        iniciarComponentes();
        //personas= new ArrayList<>();

    }

    private void iniciarComponentes() {
        formulario();
    }

    private void formulario() {
        // *************************** Conponentes del formulario**************************************************************
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(Color.LIGHT_GRAY);
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

        String[] opciones = { "Entrada General", "Entrada VIP", "Entrada para Estudiantes" };
        listadoDeOpciones = new JComboBox<>(opciones);
        listadoDeOpciones.setFont(new Font("Roboto", Font.PLAIN, 18));
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
        grid.gridx = 1;
        grid.gridy = 3;
        grid.gridwidth = 2;
        panelFormulario.add(panelAsientos, grid);

        asientos= new JCheckBox[10][10];
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
                asientoGrid.gridx = j + 1;
                asientoGrid.gridy = i + 1;
                panelAsientos.add(asientos[i][j], asientoGrid);
            }
        }

        JButton botonEnviar = new JButton();
        botonEnviar.setText("Enviar");
        botonEnviar.setFont(new Font("Roboto", Font.BOLD, 18));
        botonEnviar.setBackground(Color.BLUE);
        botonEnviar.setForeground(Color.WHITE);
        grid.gridx = 1;
        grid.gridy = 4;
        panelFormulario.add(botonEnviar, grid);

        // ***************************************Boton Mostrar************************************************ */
        JButton botonMostrar = new JButton("Mostrar Datos");
        botonMostrar.setBackground(Color.GREEN);
        botonMostrar.setFont(new Font("Roboto", Font.PLAIN, 18));
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

    }
/********************************************Metodos**********************************************/
    public void guardarDatos() {
        // Nesesito una funcionalidad de guardado de datos en un archivo de texto.
        try {
            String nombre = campoNombre.getText();
            String edad = campoEdad.getText();
            String tipoEntrada = (String) listadoDeOpciones.getSelectedItem();
            
            StringBuilder asientosSeleccionados = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (asientos[i][j].isSelected()) {
                        asientosSeleccionados.append((char)('A' + i)).append(j + 1).append(",");
                    }
                }
            }
            
            if (nombre.isEmpty() || edad.isEmpty() || asientosSeleccionados.length() == 0) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos");
                return;
            }

            FileWriter archivo = new FileWriter("reservas.txt", true);
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

    private void mostrarDatos(){
        
    }

    private void actualizarAsientos(){
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
        } 
        /*Nota: reevaluar esta implementacion y arreglarla */
        //else if (opcion.equals("Entrada VIP")) {
        //     int[][] vipAsientos = {
        //         {4, 1}, {5, 1}, {4, 2}, {5, 2}, {3, 3}, {4, 3}, {5, 3}, {6, 3},
        //         {3, 4}, {4, 4}, {5, 4}, {6, 4}, {2, 5}, {3, 5}, {4, 5}, {5, 5}, {6, 5},
        //         {2, 6}, {3, 6}, {4, 6}, {5, 6}, {6, 6}, {7, 6}, {1, 7}, {2, 7}, {3, 7},
        //         {4, 7}, {5, 7}, {6, 7}, {7, 7}, {8, 7}, {1, 8}, {2, 8}, {3, 8}, {4, 8},
        //         {5, 8}, {6, 8}, {7, 8}, {8, 8}
        //     };
        //     for (int[] asiento : vipAsientos) {
        //         asientos[asiento[0]][asiento[1]].setEnabled(false);
        //     }
        // }
    }

}
