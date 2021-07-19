package JavaOOP.SOLID.Exercise;

import JavaOOP.SOLID.Exercise.core.EngineImpl;

import JavaOOP.SOLID.Exercise.logger.Logger;
import JavaOOP.SOLID.Exercise.logger.MessageLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = new MessageLogger();
        new EngineImpl(new BufferedReader(new InputStreamReader(System.in)), logger).run();
        System.out.println(logger);

    }
}
