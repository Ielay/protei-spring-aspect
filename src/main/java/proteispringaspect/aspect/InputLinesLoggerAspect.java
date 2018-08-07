package proteispringaspect.aspect;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author lelay
 */
@Aspect
@Component
public class InputLinesLoggerAspect {

    private int numberOfCharactersInFile;

    private String lastTimeWrittenLine;

    private Logger logger;

    public InputLinesLoggerAspect() {
        numberOfCharactersInFile = 0;
        lastTimeWrittenLine = null;

        logger = Logger.getLogger(InputLinesLoggerAspect.class);
    }

    public void logLinesInfo() {
        logger.info("You've written characters: " + numberOfCharactersInFile);

        if (lastTimeWrittenLine != null) {
            logger.info("Last written line is: " + lastTimeWrittenLine);
        }
    }

    public void rememberLastWrittenLine(String writtenText) {
        lastTimeWrittenLine = writtenText;
    }

    public void countCharacters(String writtenText) {
        numberOfCharactersInFile += writtenText.length();
    }

}
