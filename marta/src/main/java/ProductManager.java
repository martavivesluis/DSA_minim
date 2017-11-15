import java.util.ArrayList;

public interface ProductManager {
    public ArrayList<Producto> productosOrdenados();

    public boolean añadirProducto(Producto miproducto);

    public void productosDisponibles();

    public int crearPedido(Usuario usuari);

    public void añadirProductoaPedido(Producto miproducto, int id);

    public Pedido servirPedido();

    public ArrayList<Pedido> listarPedidos(Usuario u);

    public void listarVentas();
}

