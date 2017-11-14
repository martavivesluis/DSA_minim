import java.util.ArrayList;
import java.util.HashMap;

public class pedido {
    ArrayList<productocantidad> pedidos;
    String nombre;
    pedido siguiente;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<productocantidad> getPedidos() {
        return pedidos;
    }
    public void setPedidos(ArrayList<productocantidad> pedidos) {
        this.pedidos = pedidos;
    }
    public void pedido(){

    }
    public pedido getSiguiente() {return siguiente;}
    public void setSiguiente(pedido siguiente) {this.siguiente = siguiente;}
}

