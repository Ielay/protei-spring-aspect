package proteispringaspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proteispringaspect.config.AppConfig;
import proteispringaspect.editor.TextEditor;

import java.util.Scanner;

/**
 * @author lelay
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(AppConfig.class);
        ctx.refresh();

        TextEditor editor = ctx.getBean("textEditor", TextEditor.class);

        StringBuilder builder = new StringBuilder("");

        boolean wannaRead = true;

        try (Scanner scanner = new Scanner(System.in)) {
            while (wannaRead) {
                builder.append(editor.readText());
                builder.append(System.lineSeparator());

                System.out.println("Do you want to continue reading text? [y/n]");
                if (scanner.next().toLowerCase().equals("n")) {
                    wannaRead = false;
                }
            }
        }

        editor.writeText(builder);

        editor.close();

        ctx.close();
    }
}
