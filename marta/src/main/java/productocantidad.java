public class productocantidad {
    int cantidad;
    String nombreproducto;
    public productocantidad()
    {

    }
    public productocantidad( String nombre, int cantidad)
    {
        this.cantidad = cantidad;
        this.nombreproducto = nombre;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }
}
