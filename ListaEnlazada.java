




/**
 * Esta clase implementa el TAD Lista utilizando memoria dinámica (Nodos enlazados)
 * 
 * NOTA: existen dos versiones de listas enlazadas (con y sin ficticio). Implementar una de las dos.
 */
public class ListaEnlazada<T> implements Lista<T> {
    
    private class Nodo {
        T elem;
        Nodo siguiente;

        Nodo(T elem) {
            this.elem = elem;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;
  
    public ListaEnlazada(){
        //Completar
        this.cabeza = null;
        // this.cabeza = null # Para listas sin ficticio
        // this.cabeza = new Nodo(null) # Para listas con ficticio
    }
    public T elemtCabezaT(){
        return cabeza.elem;
    }

    public void vaciarLista(){
    cabeza = null;
    }

    @Override
    public void insertarFin(T item){
        Nodo nuevoNodo = new Nodo(item);
        if (cabeza == null){
        cabeza = nuevoNodo;
        }else{
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        } 
    }

    @Override
    public void insertarInicio(T elem){
        Nodo nuevoNodo = new Nodo(elem);
        if (cabeza == null){
        cabeza = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }
    }

    @Override
    public void insertarPos(T elem, int pos){
        if (pos < 0) throw new IllegalArgumentException("posicion invalida");
        if (pos == 0){
            insertarInicio(elem);
        }else{
            Nodo nuevoNodo = new Nodo(elem);
            Nodo actualNodo = cabeza;
            int cont = 0;
            while(actualNodo.siguiente != null && cont < pos-1){
                actualNodo = actualNodo.siguiente;
                cont++;
            }
            nuevoNodo.siguiente = actualNodo.siguiente;
            actualNodo.siguiente = nuevoNodo;
            
            } 
        }

        @Override
        public boolean eliminar(T item){
            //Completar
        Nodo actual = cabeza;
        Nodo anterior = null;
            // mientras no lo encuentre avanzo
        while (actual != null && !actual.elem.equals(item)) {
            anterior = actual;
            actual = actual.siguiente;
        }
        if (actual == null) {
            return false; // Elemento no encontrado
        }
            // El elemento buscado es la cabeza.
        if (anterior == null) {
            cabeza = actual.siguiente;
        } else {
            anterior.siguiente = actual.siguiente;
        }
            return true;
        }

    @Override
    public int buscar(T item){
        //Completar
        Nodo actualNodo = cabeza;
        int cont = 0;
        while (actualNodo != null) {
            if(actualNodo.elem == item){
                return cont;
            }
            actualNodo = actualNodo.siguiente;
            cont++;
        }
        return -1;
    }

    @Override
    public int longitud(){
        int cont = 0;
        Nodo actualNodo = cabeza;
        if(cabeza == null){
            return cont;
        }else{
            while (actualNodo != null) {
                actualNodo = actualNodo.siguiente;
                cont++;
            }
        }
        return cont;
    }

    @Override
    public void imprimir(){
        Nodo actualNodo = cabeza;
       while(actualNodo != null){
          System.out.println(actualNodo.elem);   
          actualNodo = actualNodo.siguiente;  
       }
    }
 
}
