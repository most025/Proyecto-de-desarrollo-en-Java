public class EntradaVip extends Entrada{

public EntradaVip(String tipo, String asiento){
    super(tipo, asiento);
}

@Override
public double calcularPrecio() {
    return PRECIO*20/100;
}



    
}
