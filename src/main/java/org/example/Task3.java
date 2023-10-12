package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        String[] arr = {"1, 2, 0", "4, 5"};
        String arrToPrint = Arrays.stream(arr)
                .flatMap(s -> Arrays.stream(s.split(". "))
                        .map(Integer::parseInt))
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(arrToPrint);
    }
}
