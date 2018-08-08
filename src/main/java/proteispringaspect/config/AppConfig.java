package proteispringaspect.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lelay
 */
@Configuration
@Import({TextEditorConfig.class, InputLinesLoggerAspectConfig.class})
public class AppConfig {

}
