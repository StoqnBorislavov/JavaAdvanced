package JavaOOP.SOLID.Exercise.comtrollers;

import JavaOOP.SOLID.Exercise.enums.ReportLevel;
import JavaOOP.SOLID.Exercise.interfaces.Appender;
import JavaOOP.SOLID.Exercise.interfaces.Layout;

public class ConsoleAppender extends AbstractAppender {


    public ConsoleAppender(ReportLevel reportLevel, Layout layout) {
        super(reportLevel, layout);
    }

    @Override
    protected String getType() {
        return "ConsoleAppender";
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        System.out.println(this.getLayout().format(date, reportLevel, message));
        super.incrementAppendsCount();
    }
}
