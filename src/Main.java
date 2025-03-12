/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 6
 * Biancka Raxón 24960
 * 
 * Clase: Main
 * Clase principal del programa
 * Controlar la logica de funcionamiento para que se pueda interactuar con el usuario.
 */

import java.io.IOException;
import java.util.*;

public class Main {
    /**
     * Permite al usuario tener una coleccion personal con sus Pokemon y 
     * más opciones para visualizar los Pokemon tanto de su coleccion, como los de la coleccion general. 
     * 
     * @param args
     */
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n+-----+------------------------------------------+");
            System.out.println("|                SELECCIONAR MAP                 |");
            System.out.println("+-----+------------------------------------------+");
            System.out.printf("| %-3s | %-40s |\n", "N°", "Tipo de Map");
            System.out.println("+-----+------------------------------------------+");
            System.out.printf("| %-3s | %-40s |\n", "1", "HashMap");
            System.out.printf("| %-3s | %-40s |\n", "2", "TreeMap");
            System.out.printf("| %-3s | %-40s |\n", "3", "LinkedHashMap");
            System.out.println("+-----+------------------------------------------+");
            
            int opcionImplementacion = -1;
            boolean opcionValidaFactory = false;
            
            while (!opcionValidaFactory) {
                System.out.print("Ingrese el N° del tipo de Map a utilizar: ");
                try {
                    opcionImplementacion = Integer.parseInt(scanner.nextLine());
                    if (opcionImplementacion >= 1 && opcionImplementacion <= 3) {
                        opcionValidaFactory = true;
                    } else {
                        System.out.println("Opción inválida. Debe ser un número entre 1 y 3.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Opción inválida. Debe ingresar un número.");
                }
            }
            
            IFactory factory;
            
            switch (opcionImplementacion) {
                case 1 -> {
                    factory = new HashMapFactory(); 
                    System.out.println("¡Usaremos un Hash Map para ordenar su colección!");
                }
                case 2 -> {
                    factory = new TreeMapFactory();
                    System.out.println("¡Usaremos un Tree Map para ordenar su colección!");
                }
                case 3 -> {
                    factory = new LinkedHashMapFactory();
                    System.out.println("¡Usaremos un Linked Hash Map para ordenar su colección!");
                }
                default -> throw new IllegalArgumentException("Opción inválida.");
            }
            
            Map<String, Pokemon> allPokemons = PokemonData.loadPokemons("pokemon_data.csv");
            PokemonManager manager = new PokemonManager(factory, allPokemons);
            
            boolean continuar = true;
            while (continuar) {
                System.out.println("\n+-----+--------------------------------------------------------------+");
                System.out.println("|                             MENÚ                                   |");
                System.out.println("+-----+--------------------------------------------------------------+");
                System.out.printf("| %-3s | %-60s |\n", "N°", "Descripción");
                System.out.println("+-----+--------------------------------------------------------------+");
                System.out.printf("| %-3s | %-60s |\n", "1", "Agregar Pokémon a colección personal");
                System.out.printf("| %-3s | %-60s |\n", "2", "Mostrar datos de un Pokémon");
                System.out.printf("| %-3s | %-60s |\n", "3", "Mostrar colección personal ordenada por Type1");
                System.out.printf("| %-3s | %-60s |\n", "4", "Mostrar todos los Pokémon ordenados por Type1");
                System.out.printf("| %-3s | %-60s |\n", "5", "Mostrar todos los Pokémon por habilidad");
                System.out.printf("| %-3s | %-60s |\n", "6", "Salir");
                System.out.println("+-----+--------------------------------------------------------------+");
                
                int opcionMenu = -1;
                boolean opcionValida = false;
                while (!opcionValida) {
                    System.out.print("Ingrese el N° de la opción a elegir: ");
                    try {
                        opcionMenu = Integer.parseInt(scanner.nextLine());
                        if (opcionMenu >= 1 && opcionMenu <= 6) {
                            opcionValida = true;
                        } else {
                            System.out.println("Opción inválida. Debe ser un número entre 1 y 6.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Opción inválida. Debe ingresar un número.");
                    }
                }
                
                switch (opcionMenu) {
                    case 1 -> {
                        System.out.print("Ingrese el nombre del Pokémon a agregar: ");
                        String name =  scanner.nextLine().toLowerCase();
                        System.out.println(manager.agregarPokemon(name));
                    }
                    case 2 -> {
                        System.out.print("Ingrese el nombre del Pokémon: ");
                        String name =  scanner.nextLine().toLowerCase();
                        System.out.println(manager.mostrarDatosPokemon(name));
                    }
                    case 3 -> manager.ordenadoTipo1UserCollection().forEach(System.out::println);
                    case 4 -> manager.ordenadoTipo1AllPokemons().forEach(System.out::println);
                    case 5 -> {
                        System.out.print("Ingrese la habilidad para filtrar: ");
                        String habilidad = scanner.nextLine();
                        List<Pokemon> pokemonsConHabilidad = manager.pokemonsPorHabilidad(habilidad);
                        
                        if (!pokemonsConHabilidad.isEmpty()) {
                            System.out.println("\nLos Pokémon que contienen la habilidad \"" + habilidad + "\" son:");
                            for (int i = 0; i < pokemonsConHabilidad.size(); i++) {
                                System.out.println((i + 1) + ". " + pokemonsConHabilidad.get(i).getName());
                            }
                        } else {
                            System.out.println("No se encontraron Pokémon con esa habilidad.");
                        }                        
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