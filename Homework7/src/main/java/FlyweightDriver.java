import java.io.IOException;

public class FlyweightDriver {
        public static void main(String[] args) {
            Document document = new Document();
            document.addCharacter('H', "Roboto", "Green", 8);
            document.addCharacter('e', "Calibri", "Blue", 14);
            document.addCharacter('l', "Times New Roman", "Black", 16);
            document.addCharacter('l', "Comic Sans", "Red", 12);
            document.addCharacter('o', "Lora", "Purple", 20);
            document.addCharacter('4', "Barlow", "Pink", 14);
            document.addCharacter('8', "Verdana", "Orange", 16);
            document.addCharacter('0', "Arial", "Yellow", 32);
            document.addCharacter('0', "Karla", "White", 17);
            document.addCharacter('!', "Verdana", "Gray", 16);

            try {
                document.saveToFile("HelloWorldCS5800.txt"); //I'm not sure if it was supposed to be 4800
                document.loadFromFile("HelloWorldCS5800.txt");
                document.displayDocument();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
    }
