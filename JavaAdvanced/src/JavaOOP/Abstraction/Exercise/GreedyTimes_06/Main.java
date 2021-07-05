
package JavaOOP.Abstraction.Exercise.GreedyTimes_06;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacityBag = Long.parseLong(scanner.nextLine());
        String[] inputData = scanner.nextLine().split("\\s+");


        Bag bag = new Bag(capacityBag);

        for (int i = 0; i < inputData.length; i += 2) {
            String item = inputData[i];
            long quantity = Long.parseLong(inputData[i + 1]);

            if (item.length() == 3) {
                bag.addMoney(item, quantity);
            } else if (item.toLowerCase().endsWith("gem")) {
                bag.addStones(item, quantity);
            } else if (item.toLowerCase().equals("gold")) {
                bag.addGold(quantity);
            }
        }
        bag.printContent();
    }
}