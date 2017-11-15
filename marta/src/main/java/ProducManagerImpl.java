import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ProducManagerImpl implements ProductManager {

    HashMap<String,Integer > productosVendidos; // per contar total nom producte, numero unitats venudes
    HashMap<Integer,Pedido> todosLosPedidosEver; // per recuperar pedidos i afegir-hi productes
    HashMap<String, Usuario> usuarios; // per recuperar usuaios a partir del nom
    Listapedidos listaDePedidos; // cua de pedidos
    //no cal hash NomUsario->Array de pedidos pq Usuari tindra attribut pedidos
    HashMap<String,Producto> productosenventa;//productos disponibles
    int idsdepedido = 0;

    private static final Logger logger = LogManager.getLogger(ProductManager.class.getName());
    private static ProducManagerImpl mimundo;
    private ProducManagerImpl() {
        this.usuarios = new HashMap<String, Usuario>();
        this.productosVendidos = new HashMap<String, Integer>();
        this.listaDePedidos = new Listapedidos();
        this.todosLosPedidosEver = new HashMap<Integer,Pedido>();
        this.productosenventa = new HashMap<String,Producto>();
    }
    public static ProducManagerImpl getInstance() {
        if (mimundo == null)
            mimundo = new ProducManagerImpl();
        return mimundo;
    }

    public void añadirUsuario(Usuario u) {
        if (u == null) {
            logger.error("l'usuari està buit");

        }
        Usuario t = usuarios.put(u.getNombre(), u);
        if (t != null) {
            logger.error("l'usuari ja existeix");

        } else {
            logger.info("usuari afegit");

        }
    }

    public ArrayList<Producto> productosOrdenados() {
        if(productosenventa == null)
        {
            logger.error("no hi han objectes disponibles");
            return null;
        }
        ArrayList<Producto> ordenados = new ArrayList<Producto>(productosenventa.values());
        Collections.sort(ordenados, new Comparator<Producto>() {
            public int compare(Producto product1, Producto product2) {
                Integer idea1 = new Integer(product1.getPrecio());
                Integer idea2 = new Integer(product2.getPrecio());
                return idea1.compareTo(idea2);

            }
        });
        for (int x = 0; x < ordenados.size(); x++) {
            logger.info(ordenados.get(x).getNombre());
            logger.info(ordenados.get(x).getPrecio());
        }

        return ordenados;
    }

    public int crearPedido(Usuario usuari) {//una comanda pot estar buida s'omplirà mès endavant
        logger.info("numero actual de comandes = "+idsdepedido);
        Pedido nuevo = new Pedido(this.idsdepedido,usuari);
        int actual = this.idsdepedido;
        this.idsdepedido++;
        this.todosLosPedidosEver.put(nuevo.id,nuevo);
        listaDePedidos.push(nuevo);
        //usuari.getMispedidos().add(nuevo);
        logger.info("numero actual de comandes = "+idsdepedido);
        return actual;
        }

    //@Override
    public void añadirProductoaPedido(Producto producto, int id) {
        Pedido mipedido;
        mipedido = this.todosLosPedidosEver.get(id);//recupera el pedido
        mipedido.nuevoProducto(producto);
    }
    @Override
    public boolean añadirProducto(Producto nuevo)
    {
        if (productosenventa.containsKey(nuevo.getNombre())){
            logger.error("ja hi ha ningun article amb aquest nom a la venta");
            return false;
        }
        productosenventa.put(nuevo.getNombre(),nuevo);//añadimos producto
        logger.info("el producte s'ha afegit a la venta");
        productosVendidos.put(nuevo.getNombre(),0);//inicialment ninguna venuda
        return true;
    }

    public void unidadesvendidas(Pedido p) {
        ArrayList<Producto> milista = p.getProductos();
        for (Producto nuevo:milista)
        {
           int unidadesActuales = productosVendidos.get(nuevo.getNombre());
           unidadesActuales  = unidadesActuales+1;
           productosVendidos.put(nuevo.getNombre(),unidadesActuales);

        }

    }


    public Pedido servirPedido() {
        Pedido nuevo = this.listaDePedidos.desencuaFirstPedido();
        Usuario usuari = nuevo.getUsuario();
        usuarios.get(usuari.getNombre()).mispedidos.add(nuevo);//afgim la comanda al propietari
        unidadesvendidas(nuevo);
        return nuevo;
    }

    @Override
    public ArrayList<Pedido> listarPedidos(Usuario u) {
      ArrayList<Pedido> mispedidos = u.getMispedidos();
      if(u.getMispedidos()==null)
      {
          logger.info("no s'han processat encara cap comanda");
      }
      ArrayList<Producto> productos = new ArrayList<Producto>();
      int numeroDelPedido;
        for (int x = 0; x < mispedidos.size(); x++) {
            productos = mispedidos.get(x).getProductos();
            numeroDelPedido=mispedidos.get(x).getId();
            for (Producto p:productos) {
                logger.info("numero de comanda " +numeroDelPedido+" nom del objecte venut "+p.getNombre());

            }

        }
        return u.getMispedidos();


    }



    public void productosDisponibles() {
        ArrayList<Producto> disponibles = new ArrayList<Producto>(productosenventa.values());
        for (int x = 0; x < disponibles.size(); x++) {
            logger.info(disponibles.get(x).getNombre());
        }
    }


    @Override
    public void listarVentas()
    {
        Iterator it = productosVendidos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            logger.info(e.getKey() + " " + e.getValue());
        }


    }

    public void reiniciarSingleton() {
        mimundo = null;
    }



}






