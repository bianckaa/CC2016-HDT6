import java.util.*;
import java.util.HashMap;

public class PokemonManager {
    private Map<String, Pokemon> allPokemons;
    private Map<String, Pokemon> userCollection;

    public PokemonManager(IFactory factory, Map<String, Pokemon> allPokemons) {
        this.allPokemons = new HashMap<>();
        this.userCollection = factory.createMap();
    }

    public String agregarPokemon(String name) {
        if (!allPokemons.containsKey(name)) {
            return "Erro: Pokemon no encontrado.";
        }

        if (userCollection.containsKey(name)) {
            return "Error: El Pokemon ya se encuentra en su coleccion.";
        }

        userCollection.put(name, allPokemons.get(name));
        return "Pokemon agregado a la coleccion";
    }

    public String mostrarDatosPokemon(String name) {
        Pokemon pokemon = allPokemons.get(name);
        if (pokemon == null) {
            return "Error: Pokemon no encontrado.";
        }
        return pokemon.toString();
    }

    public List<Pokemon> ordenadoTipo1UserCollection() {
        return userCollection.values().stream()
                .sorted(Comparator.comparing(Pokemon::getType1))
                .toList();
    }

    public List<Pokemon> ordenadoTipo1AllPokemons() {
        return allPokemons.values().stream()
                .sorted(Comparator.comparing(Pokemon::getType1))
                .toList();
    }

    public List<Pokemon> pokemonsPorHabilidad(String ability) {
        return allPokemons.values().stream()
                .filter(p -> p.getAbilities().contains(ability))
                .toList();
    }
}
