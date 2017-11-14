public class producto {
    String nombre;
    int precio;
    public producto()
    {
        this.precio =0;

    }
    public producto( String nombre, int precio)
    {
        this.precio = precio;
        this.nombre = nombre;
    }
    public String getNombre(){return nombre;}
    public int getPrecio(){return precio;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setPrecio(int precio){this.precio = precio;}
}
