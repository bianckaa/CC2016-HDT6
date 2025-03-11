/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 6
 * Biancka Raxón 24960
 * 
 * Clase: PokemonData
 * Clase que carga datos de Pokemon desde un archivo CSV. 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class PokemonData {
    public static Map<String, Pokemon> loadPokemons(String filename) throws IOException {
        Map<String, Pokemon> pokemons = new LinkedHashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                try {
                    String[] datos = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                    String name = datos[0].trim();
                    int pokedexNumber = Integer.parseInt(datos[1].trim());
                    String type1 = datos[2].trim();
                    String type2 = datos[3].trim().isEmpty() ? null : datos[3].trim();
                    String classification = datos[4].trim();
                    float height = Float.parseFloat(datos[5].trim());
                    float weight = Float.parseFloat(datos[6].trim());
                    
                    
                    String abilities = datos[7].trim();
                    if (abilities.startsWith("\"") && abilities.endsWith("\"")) {
                        abilities = abilities.substring(1, abilities.length() - 1); 
                    }

                    String generation = datos[8].trim();               
                    String legendaryStatus = datos[9].trim();

                    Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification, height, 
                    weight, abilities, generation, legendaryStatus);
                    pokemons.put(pokemon.getName().toLowerCase(), pokemon);

                } catch (Exception e) {
                    System.out.println("Error en la línea: " + line + " - " + e.getMessage());
                }
            }
        } 
        return pokemons;
    } 
}
