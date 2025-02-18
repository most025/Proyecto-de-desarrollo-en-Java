public class EntradaGeneral extends Entrada {

    public EntradaGeneral(String tipo,String asiento, double precio){
        super(tipo, asiento, precio);
    }
    @Override
    public double calcularPrecio() {
        return precio*10/100;
    } 
}
