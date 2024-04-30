import java.io.Serializable;
import java.util.Objects;

public class CharacterProperty implements Serializable {
    private final String font;
    private final String color;
    private final int fontSize;

    public CharacterProperty(String font, String color, int fontSize) {
        this.font = font;
        this.color = color;
        this.fontSize = fontSize;
    }

    public String getFont() {
        return font;
    }

    public String getColor() {
        return color;
    }

    public int getFontSize() {
        return fontSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterProperty that = (CharacterProperty) o;
        return fontSize == that.fontSize &&
                Objects.equals(font, that.font) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(font, color, fontSize);
    }
}
