
package greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long input = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long gem = 0;
        long cash = 0;

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long quantityOfItem = Long.parseLong(safe[i + 1]);

            String typeOfTreasure = getTypeOfTreasure(name);

            if (typeOfTreasure.equals("")) {
                continue;
            } else if (input < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + quantityOfItem) {
                continue;
            }

            switch (typeOfTreasure) {
                case "Gem":
                    if (!bag.containsKey(typeOfTreasure)) {
                        if (bag.containsKey("Gold")) {
                            if (quantityOfItem > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(typeOfTreasure).values().stream().mapToLong(e -> e).sum() + quantityOfItem > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(typeOfTreasure)) {
                        if (bag.containsKey("Gem")) {
                            if (quantityOfItem > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(typeOfTreasure).values().stream().mapToLong(e -> e).sum() + quantityOfItem > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(typeOfTreasure)) {
                bag.put((typeOfTreasure), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(typeOfTreasure).containsKey(name)) {
                bag.get(typeOfTreasure).put(name, 0L);
            }


            bag.get(typeOfTreasure).put(name, bag.get(typeOfTreasure).get(name) + quantityOfItem);
            if (typeOfTreasure.equals("Gold")) {
                gold += quantityOfItem;
            } else if (typeOfTreasure.equals("Gem")) {
                gem += quantityOfItem;
            } else if (typeOfTreasure.equals("Cash")) {
                cash += quantityOfItem;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", x.getKey(), sumValues);

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static String getTypeOfTreasure(String name) {
        String typeOfTreasure = "";
        if (name.length() == 3) {
            typeOfTreasure = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            typeOfTreasure = "Gem";
        } else if (name.toLowerCase().equals("gold")) {
            typeOfTreasure = "Gold";
        }
        return typeOfTreasure;
    }
}