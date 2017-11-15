import java.util.ArrayList;

public class Pedido {

    public  ArrayList<Producto> productos;
    Usuario usuario;
    int id;

    public Pedido(int id, Usuario usuario){
        productos = new ArrayList<Producto>();
        this.setId(id);
        this.setUsuario(usuario);
    }

    public Pedido(){

    }

    public void nuevoProducto(Producto nuevo){
        this.productos.add(nuevo);
    }
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}

