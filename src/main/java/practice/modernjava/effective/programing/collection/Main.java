package practice.modernjava.effective.programing.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main {

    public static void main(String[] args) {
        Set<String> set = Set.of("a", "b");
        Map<String, Integer> map = Map.ofEntries(
                Map.entry("a", 1),
                Map.entry("b", 2)
        );
        System.out.println(set);
        System.out.println(map);

        List<String> languages = new ArrayList<>(List.of("Java", "Scala", "Kotlin"));

        // remove language from list when it starts with "S"
        languages.removeIf(l -> l.startsWith("S"));
        languages.replaceAll(l -> l.toUpperCase() + " Language");

        System.out.println(languages);

        // insert some value into cm
        ConcurrentMap<String, Integer> cm = new ConcurrentHashMap<>();
        cm.put("a", 1);
        cm.put("b", 2);
        cm.put("c", 3);
    }
}
