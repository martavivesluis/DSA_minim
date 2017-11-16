package exam;

import java.util.ArrayList;

public interface ProductManager {
    public ArrayList<Producto> productosOrdenados();

    public boolean añadirProducto(Producto miproducto);

    public void productosDisponibles();

    public Pedido crearPedido(Usuario usuari);

    public void añadirProductoaPedido(Producto miproducto, int id);

    public Pedido servirPedido();

    public ArrayList<Pedido> listarPedidos(Usuario u);

    public ArrayList<Venda> listarVentas();
}

