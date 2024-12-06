import Abitur2017.Abitur2017;

import java.awt.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static Random random = new Random();
    static ArrayList<Paket> pakets = new ArrayList<>();
    static ArrayList<ArrayList<Paket>> paketList = new ArrayList<>();


    public static void main(String[] args) {
        // System.out.println(IntStream.rangeClosed(1, 100).reduce(1, Math::divideExact));
        new Abitur2017().execute();
    }


    private void groupAndSortPackage() {
        for (int i = 0; i < 30; i++) {
            pakets.add(new Paket(new int[]{random.nextInt(1, 60), random.nextInt(1, 45), random.nextInt(1, 35)}, String.valueOf(random.nextInt(10, 99))));
        }
        pakets.addAll(
                random.ints(30, 0, Integer.MAX_VALUE)
                        .mapToObj(i -> new Paket(
                                new int[]{random.nextInt(1, 60), random.nextInt(1, 45), random.nextInt(1, 35)},
                                String.valueOf(random.nextInt(10, 99))
                        ))
                        .toList()
        );


        pakets.sort(Comparator.comparing(p -> p.PLZ));

        for (Paket pack : pakets) {
            if (getListWithPLZValue(pack.PLZ) == null) {
                paketList.add(new ArrayList<>());
                paketList.get(paketList.size() - 1).add(pack);
            } else {
                getListWithPLZValue(pack.PLZ).add(pack);
            }

        }
        paketList.forEach(pakets1 -> pakets1.sort(Comparator.comparing(p -> p.volume)));
        paketList.forEach(pakets1 -> pakets1.forEach(paket -> {
            System.out.println("PLZ: + " + paket.PLZ);
            System.out.println("Volume: + " + paket.volume);
        }));

    }

    private static ArrayList<Paket> getListWithPLZValue(String PLZ) {
        for (ArrayList<Paket> list : paketList) {
            if (list.stream().anyMatch(paket -> paket.PLZ.equals(PLZ))) {
                return list;
            }
        }
        return null;

    }
}