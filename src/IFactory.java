/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 6
 * Biancka Raxón 24960
 * 
 * Clase: IFactory.java
 * Interfaz que define la creacion de un map, que recibe String 
 * como Key y un objeto Pokemon como valor. 
 */

import java.util.Map;

public interface IFactory {
    Map<String, Pokemon> createMap();
}