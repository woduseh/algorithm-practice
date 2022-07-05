package practice.modernjava.stream.spliterator;


import java.util.stream.Stream;

public class WordCounter {

    private int counter;
    private boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounter accumulate(char c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCounter(counter, true);
        } else {
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }
    }

    public WordCounter combine(WordCounter other) {
        return new WordCounter(counter + other.counter, false);
    }

    public int getCounter() {
        return counter;
    }

    public int countWordsSteam(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);

        return wordCounter.getCounter();
    }
}