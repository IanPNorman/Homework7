import java.util.HashMap;
import java.util.Map;

public class CharacterPropertyFactory {
    private static final Map<CharacterProperty, CharacterProperty> properties = new HashMap<>();

    public static CharacterProperty getCharacterProperty(String font, String color, int fontSize) {
        CharacterProperty property = new CharacterProperty(font, color, fontSize);
        properties.putIfAbsent(property, property);
        return properties.get(property);
    }
}
