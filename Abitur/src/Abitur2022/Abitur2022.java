package Abitur2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Abitur2022 {


    public String Aufgabe2(String word) {
        String result = "";
        ArrayList<Vertex> vertices = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();

        Character[] characters = word.chars().mapToObj(value -> (char) value).toArray(Character[]::new);
        vertices = word.chars().distinct().mapToObj(value -> new Vertex((char) value, (int) Arrays.stream(characters).filter(character -> character.equals((char) value)).count())).collect(Collectors.toCollection(ArrayList::new));
        vertices.forEach(vertex -> {
            System.out.println(vertex.c);
            System.out.println(vertex.value);
        });

        return result;
    }

}

class Vertex {

    char c;
    int value;

    public Vertex(char c, int value) {
        this.c = c;
        this.value = value;
    }
}

class Edge {
    char a, b;
    boolean right;

    public Edge(char a, char b, boolean right) {
        this.a = a;
        this.b = b;
        this.right = right;
    }
}
