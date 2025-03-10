import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonData {
    public static Map<String, Pokemon> loadPokemons(String filename) throws IOException {
        Map<String, Pokemon> pokemons = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                int pokedexNumber = Integer.parseInt(parts[1].trim());
                float height = Float.parseFloat(parts[5].trim());
                float weight = Float.parseFloat(parts[6].trim());
                int generation = Integer.parseInt(parts[8].trim());               
                List<String> abilities = Arrays.asList(parts[7].split(","));

                Pokemon pokemon = new Pokemon(parts[0], pokedexNumber, parts[2], 
                                            parts[3], parts[4], height, 
                                            weight, abilities, generation, 
                                            parts[9]);
                pokemons.put(pokemon.getName(), pokemon);
            }
        } return pokemons;
    } 
}
