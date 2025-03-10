import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de Map a utilizar:\n1. HashMap\n2. TreeMap\n3. LinkedHashMap");
        int opcionImplementacion = scanner.nextInt();
        scanner.nextLine();
        IFactory factory;

        switch (opcionImplementacion) {
            case 1 -> factory = new HashMapFactory();
            case 2 -> factory = new TreeMapFactory();
            case 3 -> factory = new LinkedHashMapFactory();
            default -> throw new IllegalArgumentException("Opción inválida");
        }

        Map<String, Pokemon> allPokemons = PokemonData.loadPokemons("pokemon_data.csv");
        PokemonManager manager = new PokemonManager(factory, allPokemons);

        while (true) {
            System.out.println("\nOpciones:\n1. Agregar Pokémon\n2. Mostrar datos de un Pokémon\n3. Mostrar colección ordenada por Type1\n4. Mostrar todos los Pokémon ordenados por Type1\n5. Mostrar Pokémon por habilidad\n6. Salir");
            int opcionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (opcionMenu) {
                case 1 -> {
                    System.out.println("Ingrese el nombre del Pokémon a agregar:");
                    System.out.println(manager.agregarPokemon(scanner.nextLine()));
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre del Pokémon:");
                    System.out.println(manager.mostrarDatosPokemon(scanner.nextLine()));
                }
                
                case 6 -> System.exit(0);
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}