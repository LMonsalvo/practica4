


/**
 * Esta clase implementa el TAD Lista utilizando un arreglo como estructura base.
 */
public class ListaArray<T> implements Lista<T>
{
    private final  T[] elems;
    private final int maxSize;
    

    @SuppressWarnings("unchecked")
    public ListaArray(int maxSize){
        this.elems = (T[]) new Object[maxSize];
        this.maxSize = maxSize;
        
        
    }
    @Override
    public void insertarFin(T item){
      elems[maxSize-1] = item;
    }
    @Override
    public void insertarInicio(T elem){
        elems[0]=elem;
    }
    @Override
    public void insertarPos(T elem, int pos){
    if (elems[pos] != null) {
        for(int i=pos+1; i<elems.length-1; i++){
            elems[i] = elems[i+1];
        }
        elems[pos]=elem;
     }else{
        elems[pos]=elem;
        }
    }


    @Override
    public boolean eliminar(T item){
        int i=0;
        boolean encontrado = false;
        while(i<elems.length-1 && !encontrado){
            if(elems[i]==item){
                encontrado = true;
            }
            i++;
        }
        return encontrado;
    }

    @Override
    public int buscar(T item){
       //Completar
       for (int i = 0; i < elems.length-1; i++) {
        if (elems[i].equals(item)) {
            return i;
        }
    }
    return -1; // Retorna -1 si no encuentra el elemento.
    }
    
    @Override
    public int longitud(){
        int aux = 0;
        for(int i = 0 ; i < elems.length-1; i++ ){
            if (elems[i]!=null){
                aux++;
            }
        }
        return aux;
    }
    @Override
    public void imprimir(){
        for(T e : elems){
            System.out.println("elemento.."+e+ " en el arreglo");
        }
    }
}
