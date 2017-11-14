import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ProducManagerImpl implements ProductManager {
    HashMap<String, producto> productosenventa;
    HashMap<String, usuario> usuarios;
    listapedidos milista;
    private static ProducManagerImpl mimundo;

    private ProducManagerImpl() {

        this.usuarios = new HashMap<String, usuario>();
        this.productosenventa = new HashMap<String, producto>();

    }

    public static ProducManagerImpl getInstance() {
        if (mimundo == null)
            mimundo = new ProducManagerImpl();
        return mimundo;
    }

    public boolean añadirProducto(producto miproducto) {

        if (productosenventa.containsKey(miproducto.getNombre())) {
            return false;
        } else {
            productosenventa.put(miproducto.getNombre(), miproducto);
            return true;
        }


    }

    public ArrayList<producto> productosOrdenados() {
        ArrayList<producto> ordenados = new ArrayList<producto>(productosenventa.values());
        Collections.sort(ordenados, new Comparator<producto>() {
            public int compare(producto product1, producto product2) {
                Integer idea1 = new Integer(product1.getPrecio());
                Integer idea2 = new Integer(product2.getPrecio());
                return idea1.compareTo(idea2);

            }
        });
        for (int x = 0; x < ordenados.size(); x++) {
            System.out.println(ordenados.get(x).getNombre());
            System.out.println(ordenados.get(x).getPrecio());
        }

        return ordenados;
    }

    public void productosDisponibles() {
        ArrayList<producto> disponibles = new ArrayList<producto>(productosenventa.values());
        for (int x = 0; x < disponibles.size(); x++) {
            System.out.println(disponibles.get(x));
        }
    }

    public void reiniciarSingleton() {
        mimundo = null;
    }

    public pedido realizarPedido(String nombreUsuario, ArrayList<productocantidad> mispedidos) {
        ArrayList<productocantidad> futurospedidos = new ArrayList<productocantidad>();
        productocantidad productopedido = new productocantidad();
        pedido nuevo = new pedido();
        if (usuarios.containsKey(nombreUsuario)) //existe usuario
        {
            for (int x = 0; x < mispedidos.size(); x++) {
                if (productosenventa.containsValue(mispedidos.get(x).getNombreproducto()) == false) //no existe producto
                {
                    nuevo = null;

                } else//existen producto
                {
                    productopedido.setNombreproducto(mispedidos.get(x).getNombreproducto());
                    productopedido.setCantidad(mispedidos.get(x).getCantidad());
                    futurospedidos.add(productopedido);//afegim a l'arraylist el producte+quantitat
                }
            }

        }
        else{nuevo = null;}
        nuevo.pedidos = futurospedidos;
        nuevo.nombre = nombreUsuario;
        return nuevo;
    }

}






