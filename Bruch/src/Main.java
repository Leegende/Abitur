import java.util.ArrayList;

public class Main {
    record Bruch(int a, int b) {
    }

    public static void main(String[] args) {
        getStammBrüche(new Bruch(15, 16)).forEach(System.out::println);
    }

    public static Bruch minus(Bruch b1, Bruch b2) {
        return new Bruch((b1.a * b2.b) - (b1.b * b2.a), b1.b * b2.b);
    }

    public static float getValue(Bruch b1) {
        return Float.parseFloat(String.valueOf(b1.a)) / Float.parseFloat(String.valueOf(b1.b));
    }

    public static ArrayList<Bruch> getStammBrüche(Bruch bruch) {
        ArrayList<Bruch> brueche = new ArrayList<>();
        int index = 1;
        Bruch result = bruch;
        while (getValue(result) > 0) {
            System.out.println(index);
            Bruch indexBruch = new Bruch(1, index);
            if (getValue(result) >= getValue(indexBruch)) {
                result = minus(result, indexBruch);
                brueche.add(indexBruch);
            }
            index++;
        }
        return brueche;

    }
}