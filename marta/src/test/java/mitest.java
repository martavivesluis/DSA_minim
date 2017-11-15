import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class mitest {
    ProducManagerImpl mimundo;
    private static final Logger logger = LogManager.getLogger(mitest.class.getName());
    @Before
        public void setUp()
        {
            mimundo = mimundo.getInstance();
        }
    @After
    public void tearDown()
    {
        mimundo.getInstance().reiniciarSingleton();
    }

    @Test
    public void testProducteDuplicat()
    { logger.info("iniciem test1");
        Producto miProducto = new Producto("lampara", 20);
        mimundo.añadirProducto(miProducto);
        mimundo.añadirProducto(miProducto);
    }
    @Test
    public void testUsuariRepetit(){
        Usuario miusuari = new Usuario("marta");
        mimundo.añadirUsuario(miusuari);
        mimundo.añadirUsuario(miusuari);

    }
    @Test
    public void testRealitzarComanda(){
        int pedidoactual;
        Producto miProducto = new Producto("lampara", 20);
        Producto miProducto2 = new Producto("lapiz", 50);
        Producto miProducto3 = new Producto("casco", 35);
        Usuario miusuari = new Usuario("marta");
        mimundo.añadirProducto(miProducto);
        mimundo.añadirProducto(miProducto2);
        mimundo.añadirProducto(miProducto3);
        mimundo.añadirUsuario(miusuari);
        pedidoactual = mimundo.crearPedido(miusuari);
        mimundo.añadirProductoaPedido(miProducto3,pedidoactual);
        mimundo.añadirProductoaPedido(miProducto2,pedidoactual);
        mimundo.añadirProductoaPedido(miProducto2,pedidoactual);//pedido actual = 1 casco 2 lapices
        mimundo.listarPedidos(miusuari);//veiem les comandes que ens han processat
        mimundo.servirPedido();
        mimundo.listarPedidos(miusuari);
    }
    @Test
    public void test()
{   int pedidoactual;
    int miotropedido;
        Producto miProducto = new Producto("lampara", 20);
        Producto miProducto2 = new Producto("lapiz", 50);
        Producto miProducto3 = new Producto("casco", 35);
        Usuario miusuari = new Usuario("marta");
        Usuario miusuari2 = new Usuario("anna");
        mimundo.añadirProducto(miProducto);
        mimundo.añadirProducto(miProducto2);
        mimundo.añadirProducto(miProducto3);
        mimundo.añadirUsuario(miusuari);
        mimundo.añadirUsuario(miusuari2);
        pedidoactual = mimundo.crearPedido(miusuari);
        mimundo.añadirProductoaPedido(miProducto3,pedidoactual);
        mimundo.añadirProductoaPedido(miProducto2,pedidoactual);
        mimundo.añadirProductoaPedido(miProducto2,pedidoactual);//pedido actual = 1 casco 2 lapices
        miotropedido = mimundo.crearPedido(miusuari2);
        mimundo.añadirProductoaPedido(miProducto,miotropedido);
        mimundo.añadirProductoaPedido(miProducto3,miotropedido);//2 lamparas
        mimundo.servirPedido();
        logger.info("Hem servit la primera comanda");
        mimundo.listarPedidos(miusuari);
        mimundo.listarVentas();
        mimundo.servirPedido();
        logger.info("Hem servit la segona comanda");
        mimundo.listarPedidos(miusuari2);
        mimundo.listarVentas();


    }
}

