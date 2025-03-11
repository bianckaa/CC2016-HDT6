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

    public String getName() {
        return name;
        }
    
    public int getpokedexNumber() {
        return pokedexNumber;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getClassification() {
        return classification;
    }
    public float getHeight() {
        return height;
    }
    public float getWeight() {
        return weight;
    }

    public String getAbilities() {
        return abilities;
    }

    public String getGeneration() {
        return generation;
    }

    public String getIsLegendary() {
        return isLegendary;
    }
    
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
