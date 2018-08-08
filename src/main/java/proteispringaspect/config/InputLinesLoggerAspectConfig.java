package proteispringaspect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import proteispringaspect.aspect.InputLinesLoggerAspect;

/**
 * @author lelay
 */
@Configuration
@EnableAspectJAutoProxy
public class InputLinesLoggerAspectConfig {

    @Bean
    @Scope("singleton")
    public InputLinesLoggerAspect inputLinesLoggerAspect() {
        return new InputLinesLoggerAspect();
    }
}
