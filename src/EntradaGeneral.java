public class EntradaGeneral extends Entrada {

    public EntradaGeneral(String tipo,String asiento){
        super(tipo, asiento);
    }
    @Override
    public double calcularPrecio() {
        return PRECIO;
    } 
    @Override
    public void generarAsiento() {
        // TODO Auto-generated method stub
        
    }
}
