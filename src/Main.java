import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Seleccione el tipo de Map a utilizar:\n1. HashMap\n2. TreeMap\n3. LinkedHashMap");
            int opcionImplementacion = scanner.nextInt();
            scanner.nextLine();
            IFactory factory;

            switch (opcionImplementacion) {
                case 1 -> {
                    factory = new HashMapFactory(); 
                    System.out.println("¡Usaremos un Hash Map para ordenar su colección!");
                }
                case 2 -> {
                    factory = new TreeMapFactory();
                    System.out.println("¡Usaremos un Tree Mao para ordenar su colección!");
                }
                case 3 -> {
                    factory = new LinkedHashMapFactory();
                    System.out.println("¡Usaremos un Linked Hash Map para ordenar su colección!");
                }
                default -> throw new IllegalArgumentException("Opción inválida.");
            }

            Map<String, Pokemon> allPokemons = PokemonData.loadPokemons("src/pokemon_data.csv");
            PokemonManager manager = new PokemonManager(factory, allPokemons);

            boolean continuar = true;
            while (continuar) {
                System.out.println("\nOpciones:\n1. Agregar Pokémon\n2. Mostrar datos de un Pokémon\n3. Mostrar colección ordenada por Type1\n4. Mostrar todos los Pokémon ordenados por Type1\n5. Mostrar Pokémon por habilidad\n6. Salir");
                int opcionMenu = scanner.nextInt();
                scanner.nextLine();

                switch (opcionMenu) {
                    case 1 -> {
                        System.out.println("Ingrese el nombre del Pokémon a agregar:");
                        String name =  scanner.nextLine().toLowerCase();
                        System.out.println(manager.agregarPokemon(name));
                    }
                    case 2 -> {
                        System.out.println("Ingrese el nombre del Pokémon:");
                        System.out.println(manager.mostrarDatosPokemon(scanner.nextLine()));
                    }
                    case 3 -> manager.ordenadoTipo1UserCollection().forEach(System.out::println);
                    case 4 -> manager.ordenadoTipo1AllPokemons().forEach(System.out::println);
                    case 5 -> {
                        System.out.println("Ingrese la habilidad:");
                        manager.pokemonsPorHabilidad(scanner.nextLine()).forEach(System.out::println);
                    }
                    case 6 -> {
                        continuar = false;
                        System.out.println("Saliendo del programa...");
                    }
                    default -> System.out.println("Opción inválida.");
                }
            }
        }
    } 
}