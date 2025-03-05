import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    record Paket(String PLZ, int vol) {
    }


    public static void main(String[] args) {
        Random random = new Random();
        List<Paket> pakets = IntStream.rangeClosed(0, 30).mapToObj(i -> new Paket(String.valueOf(random.nextInt(0, 9)) + random.nextInt(0, 9), random.nextInt(84000))).collect(Collectors.toCollection(ArrayList::new));
        pakets.sort(Comparator.comparing(Paket::PLZ));
        pakets.forEach(System.out::println);

        HashMap<String, ArrayList<Integer>> paketsGrouped = new HashMap<>();
        for (Paket pack : pakets) {
            if (paketsGrouped.containsKey(pack.PLZ)) {
                paketsGrouped.get(pack.PLZ).add(pack.vol);
            } else {
                paketsGrouped.put(pack.PLZ, new ArrayList<>(List.of(pack.vol)));
            }
        }
        for (String s : paketsGrouped.keySet()) {
            paketsGrouped.replace(s, paketsGrouped.get(s).stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toCollection(ArrayList::new)));
            paketsGrouped.get(s).forEach(integer -> System.out.println(s + " + " + integer));
        }


    }
}