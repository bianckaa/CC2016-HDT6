/** 
 * Referencia:
 * - https://www.youtube.com/watch?v=WtUG_-1Sz_k
 * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html
 * - https://www.programiz.com/java-programming/hashmap
 * 
*/


public interface IMap<K, V>{
    /**
     * Obtiene tamaño actual del mapa. 
     * @return numero de elementos del Map
     */
    int size();

    /** 
     * Elimina todas las asignaciones del Map
     */
    void clear();

    /**
     * Verifica si el Map está vacío
     * @return true si está vacío, false en caso contrario
     */
    boolean isEmpty();

    /**
    * Verifica que la clave especificada se encuentre en el Map
    * 
    * @param key Clave a verificar
    * @return true si la clave existe, false en caso contrario
    */
    boolean containsKey(K key);

    /**
    * Verifica que el valor especificada se encuentre en el Map
    *
    * @param value Valor a verificar
    * @return true si el valor existe, false en caso contrario
    */
    boolean containsValue(V value);

    /**
     * Accede al valor del Map con el cual esta asociada la 
     * clave especificada. 
     * 
     * @param key Clave a acceder
     * @return valor asociado a la clave
     */
    V get(K key);

    /**
     * Asocia la clave especificada con el valor especificado. 
     * Si había un valor anterior asociada a la misma clave, 
     * se reemplaza ese valor con el nuevo valor especificado.
     * 
     * @param key Clave con la que se asociará el valor.
     * @param value Valor que se asociará con la clave especificada. 
     * @return valor anterior asociada con la clave, null si la clave no existía
     */
    V put(K key, V value);

    /**
     * Devuelve una vista en forma de coleccion de los valores que contiene el Map
     * @return vista de los valores
     */
    // Collection<V> values();
}