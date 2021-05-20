package StackAndQueue.Exercise;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputRobots = sc.nextLine();
        String[] robots = inputRobots.split(";");
        Map<String, Integer> robotsData = getRobotsMap(robots);
        Map<String, Integer> robotsWorkingTime = getRobotsWorkingTimeMap(robots);
        String startTime = sc.nextLine();

        int startTimeInSeconds = getStartTimeInSeconds(startTime);

        ArrayDeque<String> products = new ArrayDeque<>();

        String product = sc.nextLine();

        while (!product.equals("End")) {
            products.offer(product);
            product = sc.nextLine();
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            startTimeInSeconds++;
            decreaseWorkingTime(robotsWorkingTime);
            boolean isTaken = false;
            //check if we have free robot
            for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
                if (robot.getValue() == 0) { // robot is free -> and he starts to processed the product
                    String takenTime = getStartTime(startTimeInSeconds);
                    System.out.println(robot.getKey() + " - " + currentProduct + " " + takenTime);
                    robotsWorkingTime.put(robot.getKey(), robotsData.get(robot.getKey()));
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken) {
                products.offer(currentProduct);
            }
        }
    }

    private static void decreaseWorkingTime(Map<String, Integer> robotsWorkingTime ) {
        for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
            if(robot.getValue() > 0){
                robotsWorkingTime.put(robot.getKey(), robot.getValue() - 1);
            }
        }
    }

    private static String getStartTime(int startTimeInSeconds) {
        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = startTimeInSeconds % 3600 / 60;
        int seconds = startTimeInSeconds % 60;
        return String.format("[%02d:%02d:%02d]" ,hours, minutes, seconds);
    }

    private static Map<String, Integer> getRobotsWorkingTimeMap(String[] robots) {
        LinkedHashMap<String, Integer> robotsData = new LinkedHashMap<>();
        for (int i = 0; i < robots.length; i++) {
            String[] robotData = robots[i].split("-");
            String robotName = robotData[0];
            robotsData.put(robotName, 0);
        }
        return robotsData;
    }

    private static int getStartTimeInSeconds(String startTime) {
        int hours = Integer.parseInt(startTime.split(":")[0]);
        int minutes = Integer.parseInt(startTime.split(":")[1]);
        int seconds = Integer.parseInt(startTime.split(":")[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    private static LinkedHashMap<String, Integer> getRobotsMap(String[] robots) {
        LinkedHashMap<String, Integer> robotsData = new LinkedHashMap<>();
        for (int i = 0; i < robots.length; i++) {
            String[] robotData = robots[i].split("-");
            String robotName = robotData[0];
            int processingTime = Integer.parseInt(robotData[1]);
            robotsData.put(robotName, processingTime);
        }
        return robotsData;
    }
}
