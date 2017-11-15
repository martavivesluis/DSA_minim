import java.util.*;

public class ProducManagerImpl implements ProductManager {

    HashMap<String,Integer > productosVendidos; // per contar total nom producte, numero unitats venudes
    HashMap<Integer,Pedido> todosLosPedidosEver; // per recuperar pedidos i afegir-hi productes
    HashMap<String, Usuario> usuarios; // per recuperar usuaios a partir del nom
    Listapedidos listaDePedidos; // cua de pedidos
                                   //no cal hash NomUsario->Array de pedidos pq Usuari tindra attribut pedidos
    HashMap<String,Producto> productosenventa;//productos disponibles
    int idsdepedido = 0;

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
public void añadirUsuario(Usuario u)
{
    this.usuarios.put(u.getNombre(),u);
}
    public ArrayList<Producto> productosOrdenados() {
        ArrayList<Producto> ordenados = new ArrayList<Producto>(productosenventa.values());
        Collections.sort(ordenados, new Comparator<Producto>() {
            public int compare(Producto product1, Producto product2) {
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


    //@Override
    public int crearPedido(Usuario usuari) {//una comanda pot estar buida s'omplirà mès endavant
        Pedido nuevo = new Pedido(this.idsdepedido,usuari);
        int actual = this.idsdepedido;
        this.idsdepedido++;
        this.todosLosPedidosEver.put(nuevo.id,nuevo);
        listaDePedidos.push(nuevo);
        //usuari.getMispedidos().add(nuevo);
        return actual;
        }

    //@Override
    public void añadirProductoaPedido(Producto producto, int id) {
        Pedido mipedido;
        mipedido = this.todosLosPedidosEver.get(id);//recupera el pedido
        mipedido.nuevoProducto(producto);

       /* if (productosVendidos.containsKey(producto.getNombre())){
            Integer numIncrementado = productosVendidos.get(producto.getNombre()) + 1;
            //productosVendidos.put(producto.getNombre(), numIncrementado);
            System.out.println("producto añadido por duplicado");
        }else{
            productosVendidos.put(producto.getNombre(), new Integer(1));
            System.out.println("producto añadido");
        }
        */
    }
    @Override
    public boolean añadirProducto(Producto nuevo)
    {
        if (productosenventa.containsKey(nuevo.getNombre())){
            //contiene ya el producto
            return false;
        }
        productosenventa.put(nuevo.getNombre(),nuevo);//añadimos producto
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
      ArrayList<Producto> productos = new ArrayList<Producto>();
      int numeroDelPedido;
        for (int x = 0; x < mispedidos.size(); x++) {
            productos = mispedidos.get(x).getProductos();
            numeroDelPedido=mispedidos.get(x).getId();
            for (Producto p:productos) {
                System.out.println("numero de pedido" +numeroDelPedido+"nom del objecte venut"+p.getNombre());

            }

        }
        return u.getMispedidos();


    }



    public void productosDisponibles() {
        ArrayList<Producto> disponibles = new ArrayList<Producto>(productosenventa.values());
        for (int x = 0; x < disponibles.size(); x++) {
            System.out.println(disponibles.get(x).getNombre());
        }
    }


    @Override
    public void listarVentas()
    {

        Iterator it = productosVendidos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }


    }

    public void reiniciarSingleton() {
        mimundo = null;
    }



}






