package proteispringaspect.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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

    @Pointcut("execution(String proteispringaspect.editor.TextEditor.readText())")
    private void readFromConsoleMethod() {}

    @Before("readFromConsoleMethod()")
    public void logLinesInfo() {
        logger.info("You've written characters: " + numberOfCharactersInFile);

        if (lastTimeWrittenLine != null) {
            logger.info("Last written line is: " + lastTimeWrittenLine);
        }
    }

    @AfterReturning(pointcut = "readFromConsoleMethod()", returning = "writtenText")
    public void rememberLastWrittenLine(String writtenText) {
        lastTimeWrittenLine = writtenText;
    }

    @AfterReturning(pointcut = "readFromConsoleMethod()", returning = "writtenText")
    public void countCharacters(String writtenText) {
        numberOfCharactersInFile += writtenText.length();
    }

}
