package proteispringaspect.editor;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author lelay
 */
@Component
public class TextEditor {

    private final String outPath;

    private final Scanner scanner;

    public TextEditor(String outPath) {
        this.outPath = outPath;

        this.scanner = new Scanner(System.in);
        this.scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
    }

    public String readText() {
        System.out.println("Enter a text to write it to the file: ");

        return scanner.next();
    }

    public void writeText(StringBuilder textBuilder) {
        try (FileWriter writer = new FileWriter(new File(outPath), true)) {
            writer.write(textBuilder.toString());

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        scanner.close();
    }
}
