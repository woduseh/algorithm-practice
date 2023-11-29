package practice.effectjvejava.item7;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class CacheSample {
	public static void main(String[] args) {
		Object key = new Object();
		Object value = new Object();

		Map<Object, List> cache = new WeakHashMap<>();
	}
}