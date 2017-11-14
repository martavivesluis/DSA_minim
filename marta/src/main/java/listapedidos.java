import java.util.ArrayList;

public class listapedidos {
int numeropedidos;
pedido first;
    public pedido getUltim()
    {
        pedido actual = this.first;
        if(this.first == null){

           //llistat buit
        }
        int i =0;
        while(actual.siguiente != null)
        {
            i++;
            actual = actual.siguiente;
        }
        return actual;
    }
    public int push(ArrayList<productocantidad> pedidos)
    {

        // this.push(nuevopedido);
        if(this.numeropedidos == 0) {

            pedido nou = new pedido();
            nou.pedidos = pedidos;
            this.first = nou;
            numeropedidos++;
            return 0;
        }else{
            pedido ultim = getUltim();
            pedido nou = new pedido();
            nou.pedidos = pedidos;
            nou.siguiente = null;
            ultim.siguiente = nou;
            numeropedidos++;
            return 0;
        }

    }
    public void buidarElement(pedido node)
    {
        node.pedidos = null;
    }
}
