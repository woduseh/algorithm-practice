package practice.effectjvejava.item18;

import java.util.Collection;
import java.util.HashSet;

public class ExtendInstrumentedHashSet<E> extends HashSet<E> {

	// 추가된 원소의 수
	private int addCount = 0;

	public ExtendInstrumentedHashSet(){}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	// super.addAll 내부에서 add 함수를 호출하는 까닭에 예상하지 못한 문제가 발생할 수 있음
	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}

	public int getAddCount() {
		return addCount;
	}
}