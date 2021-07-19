package JavaOOP.SOLID.Exercise.comtrollers;

import JavaOOP.SOLID.Exercise.enums.ReportLevel;
import JavaOOP.SOLID.Exercise.interfaces.Appender;
import JavaOOP.SOLID.Exercise.interfaces.Layout;

import java.io.*;
import java.net.Socket;

public class SocketAppender extends AbstractAppender{
    private Socket socket;


    public SocketAppender(ReportLevel reportLevel, Layout layout) throws IOException {
        super(reportLevel, layout);
        socket = new Socket("localhost", 21);
    }

    @Override
    protected String getType() {
        return "SocketAppender";
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        String output = this.getLayout().format(date, reportLevel, message);
        try {
            OutputStream outputStream = this.socket.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
