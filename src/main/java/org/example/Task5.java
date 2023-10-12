import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Task5 {
    public static void main(String[] args) {
        Stream<Integer> firstStream = Stream.of(5, 8, 1, 5, 5);
        Stream<Integer> secondStream = Stream.of(10, 20, 30, 40);

        Stream<Integer> zippedStream = zip(firstStream, secondStream);

        zippedStream.forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Spliterator<T> firstSpliterator = first.spliterator();
        Spliterator<T> secondSpliterator = second.spliterator();

        Spliterator<T> zippingSpliterator = new Spliterator<T>() {
            @Override
            public boolean tryAdvance(Consumer<? super T> action) {
                boolean hasNextInFirst = firstSpliterator.tryAdvance(action);
                boolean hasNextInSecond = secondSpliterator.tryAdvance(action);
                return hasNextInFirst || hasNextInSecond;
            }

            @Override
            public Spliterator<T> trySplit() {
                return null;
            }

            @Override
            public long estimateSize() {
                long firstSize = firstSpliterator.estimateSize();
                long secondSize = secondSpliterator.estimateSize();
                return Math.min(firstSize, secondSize);
            }

            @Override
            public int characteristics() {
                return firstSpliterator.characteristics() & secondSpliterator.characteristics() &
                        ~(Spliterator.SIZED | Spliterator.SUBSIZED);
            }
        };

        return StreamSupport.stream(zippingSpliterator, false);
    }
}
