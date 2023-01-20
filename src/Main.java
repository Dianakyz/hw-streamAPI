import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Task 1
        findMinMax(Stream.of(5,20,10,1,251,5000,-350,1000),
                Comparator.naturalOrder(),
                (min,max) -> System.out.println("min = " + min + ". max = " + max));

        //Task 2
        List<Integer> numbers = Arrays.asList(5,20,10,1,251,5000,-350,1000);
        System.out.println(filter(numbers));
    }

    //Task 1
    private static <T> void findMinMax(Stream<T> stream,
                                       Comparator<T> order,
                                       BiConsumer<T,T> minMaxConsumer) {
        List<? extends T> temp = stream.toList();
        minMaxConsumer.accept(
                temp.stream().min(order).orElse(null),
                temp.stream().max(order).orElse(null));
    }

    //Task 2
    private static List<Integer> filter (List<Integer> numbers) {
        return numbers.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());
    }
}