import java.util.ArrayList;

public class usuario {
    String nombre;
    ArrayList<pedido> mispedidos;
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public ArrayList<pedido> getMispedidos() {return mispedidos;}
    public void setMispedidos(ArrayList<pedido> mispedidos) {this.mispedidos = mispedidos;}
}
