import java.util.*;

public class PokemonManager {
    private Map<String, Pokemon> allPokemons;
    private Map<String, Pokemon> usurioColleccion;

    public PokemonManager(MapFactory factory) {
        this.allPokemons = new HashMap<>();
        this.usurioColleccion = factory.createMap();
    }
}
