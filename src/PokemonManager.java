/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 6
 * Biancka Raxón 24960
 * 
 * Clase: PokemonManager.java
 * Clase que gestiona una coleccion de Pokemon
 */

import java.util.*;
import java.util.stream.Collectors;

public class PokemonManager {
    /**
     * Mapa que contiene todos los Pokemon extraidos del archivo CSV
     */
    private Map<String, Pokemon> allPokemons;

    /**
     * Mapa que contiene los Pokemon que tiene el usuario en su coleccion
     */
    private Map<String, Pokemon> userCollection;

    /**
     * Constructor de un PokemonManager. 
     * 
     * @param factory Tipo de implementacion de Map que el usuario eligio para guardar su coleccion 
     * @param allPokemons Mapa que contiene todos los Pokemon extraidos del archivo CSV
     */
    public PokemonManager(IFactory factory, Map<String, Pokemon> allPokemons) {
        this.allPokemons = allPokemons;
        this.userCollection = factory.createMap();
    }

    /**
     * Recibe el nombre de un Pokemon y lo busca en el mapa que contiene todos los Pokemon 
     * para agregarlo a la coleccion del usuario
     * 
     * @param name Nombre del Pokemon 
     * @return Mensaje que indica si el Pokémon fue agregado correctamente 
 *         o si ocurrió algún error
     */
    public String agregarPokemon(String name) {
        if (!allPokemons.containsKey(name)) {
            return "Error: Pokemon no encontrado.";
        }

        if (userCollection.containsKey(name)) {
            return "Error: El Pokemon ya se encuentra en su colección.";
        }

        userCollection.put(name, allPokemons.get(name));
        return "¡Pokemon agregado correctamente a la coleccion!";
    }

    /**
     * Recibe el nombre de un Pokemon válido y lo busca dentro del Map 
     * de la coleccion general para devolver todos los datos de este. 
     * 
     * @param name Nombre del Pokemon
     * @return Datos del Pokemon si se encuentra en la coleccion general, 
     * de lo contrario un mensaje de error. 
     */
    public String mostrarDatosPokemon(String name) {
        Pokemon pokemon = allPokemons.get(name);
        
        if (pokemon == null) {
            return "Error: Pokemon no encontrado.";
        }
        return pokemon.toString();
    }

    /**
     * Compara los Pokemon de la coleccion del usuario por su type1 
     * para devolver una lista ordenada en base a esto
     * 
     * @return Lista que contiene los Pokemon de la coleccion del 
     * usuario ordenados por su type1
     */
    public List<String> ordenadoTipo1UserCollection() {
        return userCollection.values().stream()
                .sorted(Comparator.comparing(Pokemon::getType1))
                .map(pokemon -> "Nombre: " + pokemon.getName() + ", Tipo 1: " + pokemon.getType1()) 
                .toList();
    }    

    /**
     * 
     * 
     * @return Lista que contiene todos los Pokemon de la coleccion general ordenados por su type1
     */
    public List<String> ordenadoTipo1AllPokemons() {
        return allPokemons.values().stream()
                .sorted(Comparator.comparing(Pokemon::getType1))
                .map(pokemon -> "Nombre: " + pokemon.getName() + ", Tipo 1: " + pokemon.getType1()) 
                .toList();
    }    

    /**
     * Recibe la habilidad a buscar en los Pokemon de la coleccion general, 
     * para devolver una lista que contiene unicamente a estos
     * 
     * @param ability Nombre de la habilidad
     * @return Lista que contiene todos los Pokemon de la coleccion general que tienen la habilidad
     */
    public List<Pokemon> pokemonsPorHabilidad(String ability) {
        String abilityPattern = "\\b" + ability.toLowerCase().trim() + "\\b";  
        return allPokemons.values().stream()
                .filter(pokemon -> pokemon.getAbilities().toLowerCase().matches(".*" + abilityPattern + ".*")) 
                .collect(Collectors.toList());
    }
}
