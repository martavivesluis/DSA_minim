import java.util.ArrayList;

public class Listapedidos {
    public class Nodo{
        Nodo siguiente;
        Pedido contenido;
    }
int numeropedidos;
    Nodo first;
    public Listapedidos(){}

    public void push(Pedido pedido)
    {
        Nodo nuevo = new Nodo();
        nuevo.contenido = pedido;
        Nodo ultimo = getUltim();
        if(ultimo == null){
            first = nuevo;
        }else {
            ultimo.siguiente = nuevo;
        }
    }

    public Pedido desencuaFirstPedido(){
        Nodo aretornar = this.first;
        if(aretornar == null){
            return null;
        }else {
            Nodo futuroprimero = aretornar.siguiente;
            this.first = futuroprimero;
            return aretornar.contenido;
        }
    }

    public Nodo getUltim()
    {
        Nodo actual = this.first;
        if(this.first == null){
            return null;
        }
        int i =0;
        while(actual.siguiente != null)
        {
            i++;
            actual = actual.siguiente;
        }
        return actual;
    }
}
