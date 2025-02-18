public class EntradaVip extends Entrada{

public EntradaVip(String tipo, String asiento, double precio){
    super(tipo, asiento, precio);
}

@Override
public double calcularPrecio() {
    return precio*20/100;
}



    
}
