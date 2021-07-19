package JavaOOP.SOLID.Exercise.comtrollers;

import JavaOOP.SOLID.Exercise.enums.ReportLevel;
import JavaOOP.SOLID.Exercise.interfaces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s",
                date, reportLevel.toString(), message);
    }

    @Override
    public String getType() {
        return "SimpleLayout";
    }
}
