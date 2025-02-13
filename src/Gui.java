
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame {
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
        //*************************** Conponentes del formulario **************************************************************
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

        JTextField campoNombre = new JTextField(20);
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

        JTextField campoEdad = new JTextField(20);
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
        @SuppressWarnings("rawtypes")
        JComboBox listadoDeOpciones = new JComboBox<>(opciones);
        listadoDeOpciones.setFont(new Font("Roboto", Font.PLAIN, 18));
        grid.gridx = 1;
        grid.gridy = 2;
        panelFormulario.add(listadoDeOpciones, grid);

        JLabel etiquetaSalas= new JLabel("Salas");
        etiquetaSalas.setFont(new Font("Roboto", Font.PLAIN, 18));
        etiquetaSalas.setForeground(Color.BLACK);
        grid.gridx=0;
        grid.gridy=3;
        panelFormulario.add(etiquetaSalas,grid);

        JButton botonEnviar = new JButton();
        botonEnviar.setText("Enviar");
        botonEnviar.setFont(new Font("Roboto", Font.BOLD, 18));
        botonEnviar.setBackground(Color.BLUE);
        botonEnviar.setForeground(Color.WHITE);
        grid.gridx = 1;
        grid.gridy = 3;
        panelFormulario.add(botonEnviar, grid);

        //***************************************Boton Mostrar************************************************ */
        JButton botonMostrar= new JButton("Mostrar Datos");
        botonMostrar.setBackground(Color.GREEN);
        botonMostrar.setFont(new Font("Roboto",Font.PLAIN, 18));
        botonMostrar.setForeground(Color.WHITE);
        grid.gridx=1;
        grid.gridy=5;
        panelFormulario.add(botonMostrar,grid);
    }
}
