import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import database.Conexion;
public class EntradaVip extends Entrada{
    Conexion conectarBD= Conexion.getInstancia();

public EntradaVip(){

}

public EntradaVip(String tipo, String asiento){
    super(tipo, asiento);
}

@Override
public double calcularPrecio() {
    return PRECIO+(PRECIO*50/100);
}
@Override
public void generarAsiento() {
    Connection conexion= null;
    PreparedStatement prepararConsulta=null;
    try {
        conexion= conectarBD.ConectarBD();
        String sql="SELECT * FROM salaDeCine WHERE tipo_entrada='Entrada VIP'";
        prepararConsulta= conexion.prepareStatement(sql);
        ResultSet consulta= prepararConsulta.executeQuery();
        StringBuilder informacion= new StringBuilder();
        while(consulta.next()){
            String nombre= consulta.getString("nombre");
            String edad = consulta.getString("edad");
            String entradas=consulta.getString("tipo_entrada");
            String asiento= consulta.getString("asientos");
            // imprimir los datos extraidos de la tabla sala_cine.
            informacion.append("Nombre: ").append(nombre).append("\n")
                        .append("Edad: ").append(edad).append("\n")
                        .append("Tipo de Entrada: ").append(entradas).append("\n")
                        .append("Asiento: ").append(asiento).append("\n")
                        .append("Precio: ").append(calcularPrecio()).append("\n\n");
        }
        if (informacion.length()>0) {
            JOptionPane.showMessageDialog(null, informacion.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron datos para mostrar.");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al extraer los datos : " + ex.getMessage());
    }finally{
        try {
            if (prepararConsulta != null) {
                prepararConsulta.close();
                if (conexion != null) {
                    conexion.close();
                    
                }
                
            }
        } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(null,"Error en el cierre de la conexion con la base de datos "+ excepcion.getMessage());
        }
    }


}



    
}
