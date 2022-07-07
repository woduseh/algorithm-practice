package practice.modernjava.stream.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public final class WordCounterSpliterator implements Spliterator<Character> {

    private final String string;
    private int currentChar;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) {
            return null;
        }
        for (int splitPos = currentSize / 2; splitPos < currentSize; splitPos++) {
            if (Character.isWhitespace(string.charAt(currentChar))) {
                currentChar = splitPos;
                return new WordCounterSpliterator(string.substring(currentChar, splitPos));
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL - IMMUTABLE;
    }
}
