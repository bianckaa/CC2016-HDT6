import java.util.Map;
import java.util.TreeMap;

public class TreeMapFactory implements IFactory{
    public Map<String, Pokemon> createMap() {
        return new TreeMap<>();
    }
}
