package Abitur2021;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Abitur2021 {

    public ArrayList<Integer> getAllPrimNumbersTo(int n) {
        return IntStream.rangeClosed(2, n).filter(this::isPrime).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean isPrime(int num) {
        return num >= 1 && IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(i -> num % i == 0);
    }

    public int getNumber() {
        int n = 3;
        boolean solutionWasFound = false;
        ArrayList<Integer> result = new ArrayList<>();
        while (n <= 10) {
            ArrayList<Integer> primes = getAllPrimNumbersTo(n);

            int bounds = (int) Math.sqrt((double) (n - 2) / 2);
            for (Integer a : primes) {
                for (int i = 1; i < bounds; i++) {
                    int b = i * i;
                    for (int j = 1; j < bounds; j++) {
                        int tmp = a + b + (j * j);
                        result.add(tmp);
                        System.out.println(a + " + " + i + " + " + j + " + " + n + " + " + tmp);


                    }
                }
            }
            n++;
        }
        System.out.println(result.stream().filter(integer -> primeFactorization(integer).size() >= 2 && integer % 2 != 0).min(Integer::compareTo));

        return 0;
    }

    public static ArrayList<Integer> primeFactorization(int number) {
        ArrayList<Integer> primeFactors = new ArrayList<>();

        while (number % 2 == 0) {
            primeFactors.add(2);
            number /= 2;
        }

        for (int i = 3; i * i <= number; i += 2) {
            while (number % i == 0) {
                primeFactors.add(i);
                number /= i;
            }
        }

        if (number > 2) {
            primeFactors.add(number);
        }

        return primeFactors;
    }


}
