/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 6
 * Biancka Raxón 24960
 * 
 * Clase: LinkedHashMapFactory.java
 * Clase que implementa la interfaz IMap y que se encarga de crear un Linked Hash Map.
 */
import java.util.*;

public class LinkedHashMapFactory implements IFactory{
    /** 
     * Crea y devuelve la instancia de un LinkedHashMap.
     * 
     * @return Instancia de un LinkedHashMap.
     */
    public Map<String, Pokemon> createMap() {
        return new LinkedHashMap<>();
    }
}
