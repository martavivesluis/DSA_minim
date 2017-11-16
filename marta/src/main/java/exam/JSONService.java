package exam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;


@Path("/json")
public class JSONService{
    ProducManagerImpl pm = ProducManagerImpl.getInstance();
    public JSONService() { }
    @GET
    @Path("/productes")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getProductos() {
        return pm.productosOrdenados();
    }
    @GET
    @Path("/ventas")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Venda> listarVentas()
    {
        return pm.listarVentas();
    }

    @GET
    @Path("/servir")
    @Produces(MediaType.APPLICATION_JSON)
    public Pedido servir() {
        return pm.servirPedido();
    }

    @POST
    @Path("/usuaris/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public void añadirUsuario(Usuario u) {
        pm.añadirUsuario(u);
    }


    @GET
    @Path("/usuaris")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Usuario> getUsuarios() {
        return pm.listarUsuarios();
    }

    @POST
    @Path("/pedidos/new")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces({MediaType.APPLICATION_JSON})
    public Pedido crearPedido(String usuario) { /// internament fa un new
        Usuario usr = pm.usuarios.get(usuario);
        return pm.crearPedido(usr);
    }



   /*

    //@Override
    public void añadirProductoaPedido(exam.Producto producto, int id) {
        exam.Pedido mipedido;
        mipedido = this.todosLosPedidosEver.get(id);//recupera el pedido
        mipedido.nuevoProducto(producto);
    }
    @Override
    public boolean añadirProducto(exam.Producto nuevo)
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

    public void unidadesvendidas(exam.Pedido p) {
        ArrayList<exam.Producto> milista = p.getProductos();
        for (exam.Producto nuevo:milista)
        {
            int unidadesActuales = productosVendidos.get(nuevo.getNombre());
            unidadesActuales  = unidadesActuales+1;
            productosVendidos.put(nuevo.getNombre(),unidadesActuales);

        }

    }


    public exam.Pedido servirPedido() {
        exam.Pedido nuevo = this.listaDePedidos.desencuaFirstPedido();
        exam.Usuario usuari = nuevo.getUsuario();
        usuarios.get(usuari.getNombre()).mispedidos.add(nuevo);//afgim la comanda al propietari
        unidadesvendidas(nuevo);
        return nuevo;
    }

    @Override
    public ArrayList<exam.Pedido> listarPedidos(exam.Usuario u) {
        ArrayList<exam.Pedido> mispedidos = u.getMispedidos();
        if(u.getMispedidos()==null)
        {
            logger.info("no s'han processat encara cap comanda");
        }
        ArrayList<exam.Producto> productos = new ArrayList<exam.Producto>();
        int numeroDelPedido;
        for (int x = 0; x < mispedidos.size(); x++) {
            productos = mispedidos.get(x).getProductos();
            numeroDelPedido=mispedidos.get(x).getId();
            for (exam.Producto p:productos) {
                logger.info("numero de comanda " +numeroDelPedido+" nom del objecte venut "+p.getNombre());

            }

        }
        return u.getMispedidos();


    }



    public void productosDisponibles() {
        ArrayList<exam.Producto> disponibles = new ArrayList<exam.Producto>(productosenventa.values());
        for (int x = 0; x < disponibles.size(); x++) {
            logger.info(disponibles.get(x).getNombre());
        }
    }

    public class Venda implements Comparable{
        String prod;
        Integer unidadesVendidas;

        @Override
        public int compareTo(Object o) {
            Venda obj = (Venda)o;
            if( this.unidadesVendidas < obj.unidadesVendidas){
                return -1;
            }
            if( this.unidadesVendidas == obj.unidadesVendidas){
                return 0;
            }
            return 1;
        }
    }

    @Override
    public void listarVentas()
    {
        ArrayList<Venda> vendas = new ArrayList<>();

        Iterator it = productosVendidos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String,Integer> e = (Map.Entry)it.next();
            Venda v = new Venda();
            v.prod = e.getKey();
            v.unidadesVendidas =  e.getValue();
            vendas.add(v);
        }
        Collections.sort(vendas);
        for (int i = vendas.size() - 1; i >= 0; i--) {
            logger.info(vendas.get(i).prod + " " + vendas.get(i).unidadesVendidas);
        }
    }


     */
}


