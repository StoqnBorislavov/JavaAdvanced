package JavaOOP.Abstraction.Lab.RhombusOfStars_01;

import java.util.Scanner;
import java.util.function.Predicate;

public class Main1 {
    public static void main(String[] args) {
        int size = readInput();
        String rombOfStars = buildRombOfStars(size);
        printOutput(rombOfStars);


    }

    private static void printOutput(String rombOfStars) {
        System.out.println(rombOfStars);
    }

    private static String buildRombOfStars(int size) {
        StringBuilder out = new StringBuilder();
        out.append(printMultipleRows(1, size, +1, size))
                .append(printMultipleRows(size - 1, 1, -1, size));

        return out.toString();
    }

    private static String printMultipleRows(int start, int end, int step, int size) {
        StringBuilder out = new StringBuilder();

        Predicate<Integer> loopCondition = iter -> {
            if (step > 0) {
                return iter <= end;
            }
            return iter >= end;
        };
        for (int r = start; loopCondition.test(r); r += step) {
            out.append(printLine(size - r, r))
                    .append(System.lineSeparator());
        }
        return out.toString();
    }

    private static String printLine(int spaces, int stars) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            out.append(" ");
        }
        for (int i = 0; i < stars; i++) {
            out.append("* ");
        }
        return out.toString();
    }

    private static int readInput() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
}
