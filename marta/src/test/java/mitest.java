import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class mitest {
    ProducManagerImpl mimundo;
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
        //mimundo.productosOrdenados();
        //mimundo.productosDisponibles();
        pedidoactual = mimundo.crearPedido(miusuari);
        mimundo.añadirProductoaPedido(miProducto3,pedidoactual);
        mimundo.añadirProductoaPedido(miProducto2,pedidoactual);
        mimundo.añadirProductoaPedido(miProducto2,pedidoactual);//pedido actual = 1 casco 2 lapices

        miotropedido = mimundo.crearPedido(miusuari2);
        mimundo.añadirProductoaPedido(miProducto,miotropedido);
        mimundo.añadirProductoaPedido(miProducto3,miotropedido);//2 lamparas
        mimundo.listarPedidos(miusuari);
        //System.out.println("vacio");
        mimundo.servirPedido();
        System.out.println("primerpedido");
        mimundo.listarPedidos(miusuari);
        mimundo.listarVentas();
        mimundo.servirPedido();
    System.out.println("segundopedido");
        mimundo.listarPedidos(miusuari2);
        mimundo.listarVentas();


    }
}

