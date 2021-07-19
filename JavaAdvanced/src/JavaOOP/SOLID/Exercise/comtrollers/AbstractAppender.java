package JavaOOP.SOLID.Exercise.comtrollers;

import JavaOOP.SOLID.Exercise.enums.ReportLevel;
import JavaOOP.SOLID.Exercise.interfaces.Appender;
import JavaOOP.SOLID.Exercise.interfaces.Layout;

public abstract class AbstractAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int appendsCount;

    public AbstractAppender(ReportLevel reportLevel, Layout layout) {
        this.reportLevel = reportLevel;
        this.layout = layout;
        this.appendsCount = 0;
    }

    public AbstractAppender(Layout layout){
        this(ReportLevel.INFO, layout);
    }

    protected Layout getLayout() {
        return layout;
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }
    protected abstract String getType();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Appender type: ")
                .append(this.getType())
                .append(", Layout type : ")
                .append(this.layout.getType())
                .append(", ")
                .append(String.format("Report level: %s, ", this.getReportLevel().toString()))
                .append("Messages appended: ")
                .append(this.appendsCount);
        return builder.toString();
    }

    protected void incrementAppendsCount(){
        this.appendsCount++;
    }
}
