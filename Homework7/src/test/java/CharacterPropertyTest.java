import org.junit.jupiter.api.Test;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.*;

class CharacterPropertyTest {

    @Test
    void testEquals() {
        CharacterProperty prop1 = new CharacterProperty("Arial", "Red", 12);
        CharacterProperty prop2 = new CharacterProperty("Arial", "Red", 12);
        System.out.println("Testing Equals:");
        System.out.println("Property 1: " + prop1);
        System.out.println("Property 2: " + prop2);
    }

    @Test
    void testHashCode() {
        CharacterProperty prop = new CharacterProperty("Arial", "Red", 12);
        System.out.println("Testing HashCode:");
        System.out.println("HashCode of Property: " + prop.hashCode());
        System.out.println("Property: " + prop);
    }
}
