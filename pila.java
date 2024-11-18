
public class  pila<T> implements interfacePila<T>{

    private final  ListaEnlazada<T> pila;

    public pila(){
        pila = new ListaEnlazada<>();
    }

    @Override
    public void apilar(T elem){
        pila.insertarInicio(elem);
    }

    @Override
    public void desapilar(){
        if(!esVacia()){
            pila.eliminar(pila.elemtCabezaT());
        }
    }

    @Override
    public T tope(){
        if(esVacia()) throw new IllegalStateException("la pila esta vacia..");
        return pila.elemtCabezaT();
    }

    @Override
    public boolean esVacia(){
        return pila.longitud() == 0;
    }

    @Override
    public void vaciar(){
            if (esVacia())   throw new IllegalStateException("la pila esta vacia..");
            pila.vaciarLista();
        }   
}