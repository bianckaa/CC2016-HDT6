/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 6
 * Biancka Raxón 24960
 * 
 * Clase: TreeMapFactory.java
 * Clase que implementa la interfaz IMap y que se encarga de crear un Tree Map.
 */
import java.util.Map;
import java.util.TreeMap;

public class TreeMapFactory implements IFactory{
    /** 
     * Crea y devuelve la instancia de un TreeMap.
     * 
     * @return Instancia de un TreeMap.
     */
    public Map<String, Pokemon> createMap() {
        return new TreeMap<>();
    }
}
