import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PokemonManagerTest {
    @Test
    public void shouldAddPokemonToUserCollection() throws IOException {
        IFactory factory = new HashMapFactory();
        Map<String, Pokemon> allPokemons = PokemonData.loadPokemons("src/pokemon_data.csv");
        PokemonManager manager = new PokemonManager(factory, allPokemons);
    
        String name = "pikachu";
    
        String resultado = manager.agregarPokemon(name);
    
        assertTrue(resultado.contains("agregado"));
    }
    
    @Test
    public void shouldShowDataAllPokemon() throws IOException {
        IFactory factory = new HashMapFactory();
        Map<String, Pokemon> allPokemons = PokemonData.loadPokemons("src/pokemon_data.csv");
        PokemonManager manager = new PokemonManager(factory, allPokemons);
    
        String name = "pikachu";
    
        String resultado = manager.mostrarDatosPokemon(name);
    
        assertTrue(resultado.contains("Pikachu"));
        assertTrue(resultado.contains("Electric"));
        assertTrue(resultado.contains("Static"));
    }
    
    @Test
    public void shouldShowPokemonByAbility() throws IOException {
        IFactory factory = new HashMapFactory();
        Map<String, Pokemon> allPokemons = PokemonData.loadPokemons("src/pokemon_data.csv");
        PokemonManager manager = new PokemonManager(factory, allPokemons);

        String habilidad = "Overgrow";

        List<Pokemon> result = manager.pokemonsPorHabilidad(habilidad);

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertTrue(result.stream().anyMatch(pokemon -> pokemon.getAbilities().toLowerCase().contains(habilidad.toLowerCase())));
    }
}
