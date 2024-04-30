import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterPropertyFactoryTest {

    @Test
    void testGetCharacterProperty() {
        CharacterProperty prop1 = CharacterPropertyFactory.getCharacterProperty("Arial", "Red", 12);
        CharacterProperty prop2 = CharacterPropertyFactory.getCharacterProperty("Arial", "Red", 12);

        System.out.println("Testing CharacterPropertyFactory.getCharacterProperty:");
        System.out.println("Property 1: " + prop1);
        System.out.println("Property 2: " + prop2);
    }
}
