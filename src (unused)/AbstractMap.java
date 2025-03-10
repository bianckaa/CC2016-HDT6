public abstract class AbstractMap<K, V> implements IMap<K, V> {
    protected int size = 0;

    /** 
     * Obtiene tamaño actual del mapa. 
     * 
     * @return numero de elementos del Map
     */
    @Override 
    public int size(){
        return size;
    }

    /**
     * Verifica si el Map esta vacio. 
     * 
     * @return true si el Map esta vacio, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }
}
