import java.util.*;

public class LinkedHashMapFactory implements IFactory{
    public Map<String, Pokemon> createMap() {
        return new LinkedHashMap<>();
    }
}
