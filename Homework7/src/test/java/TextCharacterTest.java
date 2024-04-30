import org.junit.jupiter.api.Test;

class TextCharacterTest {

    @Test
    void testTextCharacterProperties() {
        CharacterProperty prop = new CharacterProperty("Arial", "Blue", 14);
        TextCharacter textChar = new TextCharacter('A', prop);

        System.out.println("Testing TextCharacter properties:");
        System.out.println("Character: " + textChar.getCharacter());
        System.out.println("Property: " + textChar.getProperty());
    }
}
