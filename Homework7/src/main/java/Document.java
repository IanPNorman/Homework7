import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document implements Serializable {
    private final List<TextCharacter> characters = new ArrayList<>();

    public void addCharacter(char c, String font, String color, int fontSize) {
        CharacterProperty property = CharacterPropertyFactory.getCharacterProperty(font, color, fontSize);
        characters.add(new TextCharacter(c, property));
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(characters);
        }
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            List<?> loadedCharacters = (List<?>) in.readObject();
            characters.clear();
            characters.addAll((List<TextCharacter>) loadedCharacters);
        }
    }

    public void displayDocument() {
        for (TextCharacter tc : characters) {
            System.out.println(tc.getCharacter() + " - Font: " + tc.getProperty().getFont() +
                    ", Color: " + tc.getProperty().getColor() + ", Font Size: " + tc.getProperty().getFontSize());
        }
    }
}
