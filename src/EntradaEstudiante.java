public class EntradaEstudiante extends EntradaGeneral {

    public EntradaEstudiante(String tipo, String asiento, double precio) {
        super(tipo, asiento, precio);
    }
    //metodo heredado de la clase Entrada General.
    @Override
    public double calcularPrecio() {
    return precio*40/100;
    
}
}
