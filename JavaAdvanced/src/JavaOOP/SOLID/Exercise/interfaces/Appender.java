package JavaOOP.SOLID.Exercise.interfaces;

import JavaOOP.SOLID.Exercise.enums.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message);

    ReportLevel getReportLevel();
}
