package JavaOOP.SOLID.Exercise.comtrollers;

import JavaOOP.SOLID.Exercise.enums.ReportLevel;
import JavaOOP.SOLID.Exercise.interfaces.Appender;
import JavaOOP.SOLID.Exercise.interfaces.File;
import JavaOOP.SOLID.Exercise.interfaces.Layout;

public class FileAppender extends AbstractAppender {
    private File file;

    public FileAppender(ReportLevel reportLevel, Layout layout) {
        super(reportLevel, layout);
        this.file = new LogFile();
    }

    @Override
    protected String getType() {
        return "FileAppender";
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        String format = this.getLayout().format(date, reportLevel, message);
        this.file.write(format);
        super.incrementAppendsCount();
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
