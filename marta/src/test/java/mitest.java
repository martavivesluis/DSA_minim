import junit.framework.Assert;

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
{
        producto miProducto = new producto("lampara", 20);
        producto miProducto2 = new producto("lapiz", 50);
        producto miProducto3 = new producto("casco", 35);

        mimundo.añadirProducto(miProducto);
        mimundo.añadirProducto(miProducto2);
        mimundo.añadirProducto(miProducto3);
        mimundo.productosOrdenados();
        mimundo.productosDisponibles();
    ArrayList<productocantidad> miarray = new ArrayList<productocantidad>();
    ArrayList<productocantidad> auxiliar = new ArrayList<productocantidad>();
        productocantidad r = new productocantidad("lampara",50);
        productocantidad s = new productocantidad("bicicleta",60);
        miarray.add(r);
        miarray.add(s);
        mimundo.realizarPedido("marta",miarray);
    }
}

