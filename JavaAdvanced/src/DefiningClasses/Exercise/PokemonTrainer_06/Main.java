package DefiningClasses.Exercise.PokemonTrainer_06;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        Map<String, Trainer> trainersMap = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("Tournament")) {
            String trainerName = input.split("\\s+")[0];
            trainersMap.putIfAbsent(trainerName, new Trainer(trainerName));
            String pokemonName = input.split("\\s+")[1];
            String element = input.split("\\s+")[2];
            int health = Integer.parseInt(input.split("\\s+")[3]);
            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            trainersMap.get(trainerName).addPokemon(pokemon);

            input = sc.nextLine();
        }

        String element = sc.nextLine();

        while (!element.equals("End")) {
            switch (element) {
                case "Fire":
                    reducePokemonsHealthAndIncreaseBadges("Fire", trainersMap);
                    break;
                case "Water":
                    reducePokemonsHealthAndIncreaseBadges("Water", trainersMap);
                    break;
                case "Electricity":
                    reducePokemonsHealthAndIncreaseBadges("Electricity", trainersMap);
                    break;
            }
            element = sc.nextLine();
        }
        trainersMap.values().stream()
                .sorted((first, second) -> Integer.compare(second.getBadges(), first.getBadges()))
                .forEach(t -> System.out.println(t));


    }

    public static void reducePokemonsHealthAndIncreaseBadges(String element, Map<String, Trainer> trainersMap) {
        for (Map.Entry<String, Trainer> entry : trainersMap.entrySet()) {
            if (!entry.getValue().checkForPokemon(element)) {
                entry.getValue().reducePokemonsHealth();
            } else {
                entry.getValue().increaseBadges();
            }
        }
    }
}
