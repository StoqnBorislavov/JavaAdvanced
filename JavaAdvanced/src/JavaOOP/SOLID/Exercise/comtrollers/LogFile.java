package JavaOOP.SOLID.Exercise.comtrollers;

import JavaOOP.SOLID.Exercise.enums.ReportLevel;
import JavaOOP.SOLID.Exercise.interfaces.File;

public class LogFile implements File {
    private StringBuilder builder;

    public LogFile() {
        this.builder = new StringBuilder();
    }

    @Override
    public void write(String text) {
        this.builder.append(text);

    }

    @Override
    public int getSize() {
        int result = 0;
        for (int i = 0; i < this.builder.length(); i++) {
             char symbol = this.builder.charAt(i);
             if(Character.isAlphabetic(symbol)){
                 result += symbol;
             }

        }
        return result;
    }
}
