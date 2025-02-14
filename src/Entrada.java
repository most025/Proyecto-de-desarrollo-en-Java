public abstract class Entrada {
    public String tipo;
    public String asiento;
    public double precio;

    public Entrada(String tipo, String asiento, double precio) {
        this.tipo = tipo;
        this.asiento = asiento;
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public abstract double calcularPrecio();
    public abstract void generarAsiento();

}
