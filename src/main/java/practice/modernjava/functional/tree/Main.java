package practice.modernjava.functional.tree;

import static practice.modernjava.functional.tree.TreeProcesser.functionalUpdate;
import static practice.modernjava.functional.tree.TreeProcesser.update;

public class Main {

    public static void main(String[] args) {
        Tree t = new Tree("A", 1,
                new Tree("B", 2, new Tree("C", 3, null, null), new Tree("D", 4, null, null)),
                new Tree("E", 5, new Tree("F", 6, null, null), new Tree("G", 7, null, null)));

        update("A", 10, t);
        functionalUpdate("A", 10, t);
        // System.out.println(patternMatching(t));

        System.out.println(t);
    }

    // private static String patternMatching(Object obj) {
    //     return switch (obj) {
    //         case Integer i -> i + ": It is an integer";
    //         case String s -> s + ": It is a string";
    //         default -> "It is none of the known data types";
    //     };
    // }
}
