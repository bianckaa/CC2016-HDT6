/**
 * Referencias:
 * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html
 * - https://www.youtube.com/watch?v=KovPqRdT5Gk 
 */

import java.util.ArrayList;

public class HashMap<K, V> extends AbstractMap<K, V>{
    int initialCapacity = getInitialCapacity();
    float loadFactor = 0.75F;

    @SuppressWarnings("unchecked")
    private ArrayList<Node<K, V>>[] compartimientos = (ArrayList<Node<K, V>>[]) new ArrayList[initialCapacity]; // Arreglo de lista de nodos

    /**
     * Constructor que inicializa un HashMap vacio. 
     * 
     * @param initialCapacity capacidad inicial
     * @param loadFactor factor de carga
     */
    public HashMap(int initialCapacity, float loadFactor){
        this.initialCapacity = initialCapacity;
        this.loadFactor = loadFactor;        

        for (int i = 0; i < initialCapacity; i++) {
            compartimientos[i] = new ArrayList<>();
        }
    }

    private static int getInitialCapacity() {
        int expectedValue = 1024;
        float loadFactor = 0.75F;

        return (int) (expectedValue / loadFactor) + 1;
    }

    /**
     * Calcula el indice en el arreglo de compartimeintos (buckets)
     * @param key clave
     * @return indice
     */
    private int hash(K key) {
        return Math.abs(key.hashCode()) % initialCapacity;
    }

    @Override 
    public boolean containsKey(K key) {
        int indice = hash(key); 
        
        for (Node<K, V> nodo : compartimientos[indice]) { 
            if (nodo.key.equals(key)) { 
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for(ArrayList<Node<K, V>> compartimiento : compartimientos){
            for (Node<K, V> nodo : compartimiento) {
                if ((value == null && nodo.value == null) || (value != null && value.equals(value))) {
                    return true;
                }
            }   
        }
        return false;
    }

    @Override
    public V get(K key) {
        int indice = hash(key);

        for (Node<K, V> nodo : compartimientos[indice]) {
            if (nodo.key.equals(key)) {
                return nodo.value;
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        int indice = hash(key);

        for (Node<K, V> nodo : compartimientos[indice]) {
            if (nodo.key.equals(key)) {
                V oldValue = nodo.value;
                nodo.value = value;
                return oldValue;
            }
        }

        compartimientos[indice].add(new Node<>(key, value));
        size++;
        return null;
    }
}
