/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 6
 * Biancka Raxón 24960
 * 
 * Clase: HashMapFactory.java
 * Clase que implementar la interfaz IMap y que se encarga de crear un HashMap
 */

import java.util.HashMap;
import java.util.Map;

public class HashMapFactory implements IFactory {
    /** 
     * Crea y devuelve la instancia de un HashMap.
     * 
     * @return Instancia de un HashMap.
     */
    public Map<String, Pokemon> createMap() {
        return new HashMap<>();
    }
}
