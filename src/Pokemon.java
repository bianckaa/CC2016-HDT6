/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 6
 * Biancka Raxón 24960
 * 
 * Clase: Pokemon
 * Clase que define un objeto Pokemon con sus correspondientes datos. 
 */

public class Pokemon {
    private String name;
    private int pokedexNumber;
    private String type1;
    private String type2;
    private String classification;
    private float height;
    private float weight;
    private String abilities;
    private String generation;
    private String isLegendary;

    /**
     * Constructor de la clase Pokemon
     * 
     * @param name nombre del Pokemon
     * @param pokedexNumber numero de pokedex del Pokemon
     * @param type1 tipo 1 del Pokemon
     * @param type2 tipo 2 del Pokemon 
     * @param classification clasificacion del Pokemon
     * @param height altura en m del Pokemon
     * @param weight peso en kg del Pokemon
     * @param abilities habilidades del Pokemon
     * @param generation generacion del Pokemon
     * @param isLegendary si el Pokemon es legendario o no
     */
    public Pokemon(String name, 
    int pokedexNumber, 
    String type1, 
    String type2, 
    String classification, 
    float height, 
    float weight, 
    String abilities, 
    String generation, 
    String isLegendary) {
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.isLegendary = isLegendary;
    }

    /**
     * Obtiene nombre del Pokemon
     * 
     * @return nombre del Pokemon
     */
    public String getName() {
        return name;
        }
    
    /**
     * Obtiene el numero de pokedex del Pokemon
     * 
     * @return numero de pokedex del Pokemon
     */
    public int getpokedexNumber() {
        return pokedexNumber;
    }

    /** 
     * Obtiene el tipo 1 del Pokemon
     * 
     * @return tipo 1 del Pokemon
     */
    public String getType1() {
        return type1;
    }

    /**
     * Obtiene el tipo 2 del Pokemon
     * 
     * @return tipo 2 del Pokemon
     */
    public String getType2() {
        return type2;
    }

    /**
     * Obtiene la clasificacion del Pokemon
     * 
     * @return clasificacion del Pokemon
     */
    public String getClassification() {
        return classification;
    }

    /**
     * Obtiene la atura del Pokemon
     * 
     * @return altura del Pokemon
     */
    public float getHeight() {
        return height;
    }

    /** Obtiene el peso del Pokemon
     * 
     * @return peso del Pokemon
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Obtiene las habilidades del pokemon
     * 
     * @return habilidades del Pokemon
     */

    public String getAbilities() {
        return abilities;
    }

    /**
     * Obtiene la generacion del Pokemon
     * @return generacion del Pokemon
     */
    public String getGeneration() {
        return generation;
    }

    /**
     * Obtiene el estado legendario del Pokemon
     * @return estado legendario del Pokemon
     */
    public String getIsLegendary() {
        return isLegendary;
    }
    
    /** 
     * Devuelve una representación en formato de cadena de texto con todos los datos del Pokemon
     * 
     * @return cadena que contiene todos los datos del Pokemon
     */
    @Override
    public String toString() {
        return String.format("\nDatos del Pokemon\n" +
        "===================\n" + 
        "Nombre: %s\n" +
        "Pokedex Number: %d\n" +
        "Tipo 1: %s\n" +
        "Tipo 2: %s\n" +
        "Clasificación: %s\n" +
        "Altura (m): %.2f\n" +
        "Peso (kg): %.2f\n" +
        "Habilidades: %s\n" +
        "Generación: %s\n" +
        "Estado Legendario: %s\n",
        name, pokedexNumber, type1, type2 != null ? type2 : "Desconocido", classification, height, weight, abilities, generation, isLegendary);
    }
}
