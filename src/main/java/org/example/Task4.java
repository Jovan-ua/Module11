package org.example;

import java.util.stream.Stream;

public class Task4 {
    public static Stream<Long> generateStream(long a, long c, long m, long seed){
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2,48);
        long seed = 0L;
        Stream<Long> random = generateStream(a, c, m, seed);
        random.limit(20)
                .forEach(System.out::println);
    }
}
