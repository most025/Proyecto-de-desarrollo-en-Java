public abstract class Entrada {
    public String tipo;
    public String asiento;
    public static final double PRECIO=1600;

    public Entrada(){
        
    }

    public Entrada(String tipo, String asiento) {
        this.tipo = tipo;
        this.asiento = asiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public abstract double calcularPrecio();
    public abstract void generarAsiento();

}
