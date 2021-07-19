package JavaOOP.SOLID.Exercise.comtrollers;

import JavaOOP.SOLID.Exercise.enums.ReportLevel;
import JavaOOP.SOLID.Exercise.interfaces.Appender;
import JavaOOP.SOLID.Exercise.interfaces.AppenderFactory;
import JavaOOP.SOLID.Exercise.interfaces.Layout;

import java.io.IOException;

public class AppenderWorkshop implements AppenderFactory {

    @Override
    public Appender produce(String type, ReportLevel reportLevel, Layout layout) throws IOException {
        return switch (type){
            case "ConsoleAppender" ->new ConsoleAppender(reportLevel, layout);
            case "FileAppender" -> new FileAppender(reportLevel, layout);
            case "SocketAppender" -> new SocketAppender(reportLevel, layout);
            default -> throw new IllegalStateException(
                        "Not valid type of appender for " + type + " param");
        };
    }
}
