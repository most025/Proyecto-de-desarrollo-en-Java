public class EntradaVip extends Entrada{

public EntradaVip(String tipo, String asiento){
    super(tipo, asiento);
}

@Override
public double calcularPrecio() {
    return PRECIO+(PRECIO*50/100);
}
@Override
public void generarAsiento() {
    // TODO Auto-generated method stub
    
}



    
}
