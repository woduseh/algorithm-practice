package practice.modernjava.stream.spliterator;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) {
        final String SENTENCE = "Nel mezzo del cammin di nostra vita mi ritrovai in una selva oscura che la dritta via era smarrita";

        WordCounter wordCounter = new WordCounter(0, true);
        int wordCount = countWordsIteratively(SENTENCE);
        System.out.println("Word count: " + wordCount);

        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        System.out.println("Word count: " + wordCounter.countWordsSteam(stream));
    }

    public static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }

        return counter;
    }
}