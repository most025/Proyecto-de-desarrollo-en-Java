public class EntradaEstudiante extends EntradaGeneral {

    public EntradaEstudiante(String tipo, String asiento) {
        super(tipo, asiento);
    }
    //metodo heredado de la clase Entrada General.
    @Override
    public double calcularPrecio() {
    return PRECIO*40/100;
    
}
}
