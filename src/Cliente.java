public class Cliente extends Persona {
    private String tipoEntrada;
    public Cliente(String nombre, int edad, String tipoEntrada){
        super(nombre, edad);
        this.tipoEntrada=tipoEntrada;
    }
    public String getTipoEntrada() {
        return tipoEntrada;
    }
    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }
    
}
