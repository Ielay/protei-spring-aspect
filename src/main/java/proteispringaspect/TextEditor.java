package proteispringaspect;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author lelay
 */
public class TextEditor {

    private final String outPath;

    public TextEditor(String outPath) {
        this.outPath = outPath;
    }

    private String readText(Scanner scanner) {
        System.out.println("Enter a text to write it to the file: ");

        return scanner.next();
    }

    private void writeText(StringBuilder textBuilder) {
        try (FileWriter writer = new FileWriter(new File(outPath))) {
            writer.write(textBuilder.toString());

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFromConsole() {

        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));

            StringBuilder textBuilder = new StringBuilder("");

            boolean wannaWrite = true;

            while (wannaWrite) {
                String newLine = this.readText(scanner);

                textBuilder.append(newLine);
                textBuilder.append(System.lineSeparator());

                System.out.println("Do you want to write more? [y/n]");

                if (scanner.next().toLowerCase().equals("n")) {
                    wannaWrite = false;
                }
            }

            this.writeText(textBuilder);
        }
    }
}
