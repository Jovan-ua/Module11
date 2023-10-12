package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static List<String> sortNames(List<String> input) {
        return input.stream()
                .map(String::toUpperCase)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Peter", "Max", "Eva", "Sergey");
        List<String> sortNames = sortNames(names);
        sortNames.forEach(System.out::println);
    }
}
