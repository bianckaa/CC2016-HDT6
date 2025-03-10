import java.util.HashMap;
import java.util.Map;

public class HashMapFactory implements IFactory {
    public Map<String, Pokemon> createMap() {
        return new HashMap<>();
    }
}
