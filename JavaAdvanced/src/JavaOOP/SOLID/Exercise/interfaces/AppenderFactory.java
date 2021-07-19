package JavaOOP.SOLID.Exercise.interfaces;

import JavaOOP.SOLID.Exercise.enums.ReportLevel;

import java.io.IOException;

public interface AppenderFactory {
    Appender produce(String type, ReportLevel reportLevel, Layout layout) throws IOException;
}
