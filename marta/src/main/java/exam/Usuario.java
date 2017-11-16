package exam;

import java.util.ArrayList;

public class Usuario {
    String nombre;
    public ArrayList<Pedido> mispedidos;
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}



    public Usuario(String nombre) {
        this.nombre = nombre;
        this.mispedidos = new ArrayList<Pedido>();

    }
    public Usuario() {

    }

    public ArrayList<Pedido> getMispedidos() {return mispedidos;}
    public void setMispedidos(ArrayList<Pedido> mispedidos) {this.mispedidos = mispedidos;}
}
