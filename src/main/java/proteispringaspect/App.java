package proteispringaspect;

import proteispringaspect.editor.TextEditor;

/**
 * @author lelay
 */
public class App {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor("src/main/resources/someText.txt");

        editor.writeFromConsole();
    }
}
