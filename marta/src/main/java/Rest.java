import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;

public class Rest {
    ProductManager miproductor;

    @GET
    @Path("/Productes/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getProductos() {
        return miproductor.productosOrdenados();
    }
}


