package JavaOOP.SOLID.Exercise.interfaces;

import JavaOOP.SOLID.Exercise.enums.ReportLevel;

public interface Layout {
    String format(String date, ReportLevel reportLevel, String message);

    String getType();
}

