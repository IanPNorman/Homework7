import java.io.Serializable;

public class TextCharacter implements Serializable {
    private final char character;
    private final CharacterProperty property;

    public TextCharacter(char character, CharacterProperty property) {
        this.character = character;
        this.property = property;
    }

    public char getCharacter() {
        return character;
    }

    public CharacterProperty getProperty() {
        return property;
    }
}


