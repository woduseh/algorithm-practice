package practice.modernjava.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        var list = subsets(List.of(1, 2, 3));

        list.sort(Comparator.comparing(List::toString));
        list.sort(Comparator.comparing(List::size));
        System.out.println(list);
    }

    static List<List<Integer>> subsets(List<Integer> list) {
        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());

        List<List<Integer>> subans = subsets(rest);
        List<List<Integer>> subansTwo = insertAll(first, subans);

        return concat(subans, subansTwo);
    }

    static List<List<Integer>> insertAll(Integer first, List<List<Integer>> subans) {
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> subset : subans) {
            List<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(first);
            ans.add(newSubset);
        }
        return ans;
    }

    static List<List<Integer>> concat(List<List<Integer>> subans, List<List<Integer>> subansTwo) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(subans);
        ans.addAll(subansTwo);
        return ans;
    }
}
