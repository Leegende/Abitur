package Abitur2017;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Abitur2017 {

    ArrayList<Integer> programmPackages = new ArrayList<>();
    ArrayList<dependency> dependencies = new ArrayList<dependency>();


    public void execute() {
        programmPackages = newPackageList(2);
        addDependecy(0, 1);
        addDependecy(1, 0);
        ArrayList<Integer> visited = new ArrayList<>();

        System.out.println(checkIfCycle(visited, 0));
    }

    public boolean checkIfCycle(ArrayList<Integer> visited, Integer current) {

        visited.add(current);
        ArrayList<Integer> dep = getDependentPackets(current);

        for (Integer i : dep) {
            if (visited.contains(i)) {
                return true;
            }
            return checkIfCycle(visited, i);
        }

        return false;
    }

    public ArrayList<Integer> getDependentPackets(int value) {
        return dependencies.stream()
                .filter(d -> d.a == value)
                .map(d -> d.b)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public ArrayList<Integer> newPackageList(int amount) {
        return IntStream.rangeClosed(0, amount - 1).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    public void addDependecy(int a, int b) {
        dependencies.add(new dependency(a, b));
    }

}

class dependency {
    int a, b;

    public dependency(int a, int b) {
        this.a = a;
        this.b = b;
    }
}