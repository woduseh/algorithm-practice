package practice.effectjvejava.item18;

import java.util.List;
import java.util.TreeSet;

public class InstrumentedHashSetTest {
	public static void main(String[] args) throws Exception {
		ExtendInstrumentedHashSet<String> extendInstrumentedHashSet = new ExtendInstrumentedHashSet<>();
		extendInstrumentedHashSet.addAll(List.of("1", "2", "3", "4"));
		System.out.println(extendInstrumentedHashSet.getAddCount()); // 8 반환

		CompositionInstrumentedSet<String> compositionInstrumentedSet = new CompositionInstrumentedSet<>(new TreeSet<>());
		compositionInstrumentedSet.addAll(List.of("1", "2", "3", "4"));
		System.out.println(compositionInstrumentedSet.getAddCount()); // 8 반환
	}
}
