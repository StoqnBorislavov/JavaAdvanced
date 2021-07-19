package JavaOOP.SOLID.Exercise.core;

import JavaOOP.SOLID.Exercise.comtrollers.FactoryRepository;
import JavaOOP.SOLID.Exercise.enums.ReportLevel;
import JavaOOP.SOLID.Exercise.interfaces.Appender;
import JavaOOP.SOLID.Exercise.interfaces.Engine;
import JavaOOP.SOLID.Exercise.interfaces.InputParser;
import JavaOOP.SOLID.Exercise.logger.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.IllformedLocaleException;

public class EngineImpl implements Engine {
    private boolean isRunning;
    private BufferedReader reader;
    private Logger logger;

    public EngineImpl(BufferedReader reader, Logger logger) {
        this.reader = reader;
        this.logger = logger;
    }

    @Override
    public void run() throws IOException {
        this.isRunning = true;

        String line = reader.readLine();
        addAppenders(Integer.parseInt(line));
        while (this.isRunning) {
            line = reader.readLine();
            String[] parse = InputParser.parse(line);
            if (!parse[0].equals("END")) {
                logMessage(parse);
            }
            this.isRunning = !parse[0].equals("END");
        }
    }

    private void logMessage(String[] parse) {
        ReportLevel reportLevel = ReportLevel.valueOf(parse[0]);
        String date = parse[1];
        String message = parse[2];
        switch (reportLevel) {
            case INFO -> logger.logInfo(date, message);
            case WARNING -> logger.logWarning(date, message);
            case ERROR -> logger.logError(date, message);
            case CRITICAL -> logger.logCritical(date, message);
            case FATAL -> logger.logFatal(date, message);
            default -> throw new IllformedLocaleException();
        }
    }

    private void addAppenders(int n) throws IOException {
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            ReportLevel reportLevel = tokens.length == 3
                    ? ReportLevel.valueOf(tokens[2].toUpperCase())
                    : ReportLevel.INFO;

            Appender appender = FactoryRepository.getAppenderFactory().produce
                    (tokens[0], reportLevel,
                            FactoryRepository.getLayoutFactory().produce(tokens[1]));
            logger.addAppender(appender);
        }
    }
}
