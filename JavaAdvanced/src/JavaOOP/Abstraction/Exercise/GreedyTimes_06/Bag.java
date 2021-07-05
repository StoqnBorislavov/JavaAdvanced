package JavaOOP.Abstraction.Exercise.GreedyTimes_06;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private long currentTotalQuantity;
    private long gold;
    private Map<String, Long> stones;
    private Map<String, Long> money;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.stones = new HashMap<>();
        this.money = new HashMap<>();
    }

    public void addMoney(String item, long quantity) {
        long totalMoney = getTotalMoney();
        long totalStones = getTotalStones();
        if (hasFreeCapacity(quantity) && totalStones >= totalMoney + quantity) {
            if (!this.money.containsKey(item)) {
                this.money.put(item, quantity);
            } else {
                this.money.put(item, this.money.get(item) + quantity);
            }
            this.currentTotalQuantity += quantity;
        }
    }
    private long getTotalMoney(){
        return this.money.values().stream().mapToLong(e->e).sum();
    }

    public void addStones(String item, long quantity){
        long totalStones = getTotalStones();
        if(hasFreeCapacity(quantity) && totalStones + quantity <= this.gold) {
            if(!this.stones.containsKey(item)){
                this.stones.put(item, quantity);
            } else {
                this.stones.put(item, this.stones.get(item) + quantity);
            }
            this.currentTotalQuantity += quantity;
        }
    }
    private long getTotalStones(){
        return this.stones.values().stream().mapToLong(e->e).sum();
    }

    public void addGold(long quantity){
        if(hasFreeCapacity(quantity)){
            this.gold += quantity;
            this.currentTotalQuantity += quantity;
        }

    }

    private boolean hasFreeCapacity(long quantity) {
        return currentTotalQuantity + quantity <= capacity;
    }

    public void printContent(){
        StringBuilder builder = new StringBuilder();
        //gold
        if(this.gold >= 0) {
            builder.append(String.format("<Gold> $%d", this.gold)).append(System.lineSeparator());
            builder.append(String.format("##Gold - %d", this.gold)).append(System.lineSeparator());
        }

        //stones
        if(!this.stones.isEmpty()){
            builder.append(String.format("<Gem> $%d", getTotalStones())).append(System.lineSeparator());
            this.stones.entrySet().stream().sorted(getComparator())
                    .forEach(entry ->builder.append(String.format("##%s - %d", entry.getKey(), entry.getValue()))
                        .append(System.lineSeparator()));
        }

        //cash
        if(!this.money.isEmpty()){
            builder.append(String.format("<Cash> $%d", getTotalMoney())).append(System.lineSeparator());
            this.money.entrySet().stream().sorted(getComparator())
            .forEach(entry ->builder.append(String.format("##%s - %d", entry.getKey(), entry.getValue()))
                    .append(System.lineSeparator()));
        }
        System.out.println(builder.toString().trim());
    }
    private Comparator<Map.Entry<String, Long>> getComparator(){
        return new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> e1, Map.Entry<String, Long> e2) {
                    int result = e2.getKey().compareTo(e1.getKey());
                    if(result == 0){
                        result = e1.getValue().compareTo(e2.getValue());
                    }
                    return result;
            }
        };
    }
}
