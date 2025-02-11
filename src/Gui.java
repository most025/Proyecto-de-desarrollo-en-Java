
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame {
    public Gui() {
        this.setSize(900, 900);
        this.setTitle("Sistema de entrada de cine");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        iniciarComponentes();

    }

    private void iniciarComponentes() {
        formulario();
    }

    private void formulario() {
        JPanel panelFormulario = new JPanel();
        panelFormulario.setBackground(Color.GRAY);
        this.getContentPane().add(panelFormulario);

        JLabel etiquetanombre = new JLabel("Nombre");
        etiquetanombre.setFont(new Font("Roboto", Font.PLAIN, 18));
        etiquetanombre.setForeground(Color.BLACK);
        panelFormulario.add(etiquetanombre);

        JTextField campoNombre=new JTextField(20);
        campoNombre.setFont(new Font("Roboto", Font.PLAIN, 20));
        panelFormulario.add(campoNombre);

        JLabel etiquetaEdad=new JLabel("Edad");
        etiquetaEdad.setFont(new Font("Roboto",Font.PLAIN, 18));
        etiquetaEdad.setForeground(Color.BLACK);
        panelFormulario.add(etiquetaEdad);

        JTextField campoEdad= new JTextField(20);
        campoEdad.setFont(new Font("Roboto", Font.PLAIN, 20));
        panelFormulario.add(campoEdad);

        JLabel etiquetaDeOPciones=new JLabel("Selecionar Entradas");
        etiquetaDeOPciones.setFont(new Font("Roboto", Font.PLAIN, 18));
        etiquetaDeOPciones.setForeground(Color.BLACK);
        panelFormulario.add(etiquetaDeOPciones);

        String [] opciones={"Entrada General","Entrada VIP","Entrada para Estudiantes"};
        @SuppressWarnings("rawtypes")
        JComboBox  listadoDeOpciones= new JComboBox<>(opciones);
        listadoDeOpciones.setFont(new Font("Roboto", Font.PLAIN, 18));
        panelFormulario.add(listadoDeOpciones);

        JButton botonEnviar= new JButton();
        botonEnviar.setText("Enviar");
        botonEnviar.setFont(new Font("Roboto", Font.BOLD, 18));
        botonEnviar.setBackground(Color.BLUE);
        botonEnviar.setForeground(Color.WHITE);
        panelFormulario.add(botonEnviar);

    }
}
