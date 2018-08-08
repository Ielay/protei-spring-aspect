package proteispringaspect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import proteispringaspect.editor.TextEditor;

/**
 * @author lelay
 */
@Configuration
public class TextEditorConfig {

    @Bean
    @Scope("prototype")
    public TextEditor textEditor() {
        return new TextEditor("src/main/resources/someText.txt");
    }
}
