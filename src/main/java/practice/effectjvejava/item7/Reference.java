package practice.effectjvejava.item7;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Reference {
	public static void main(String[] args) {
		// Strong
		Reference strongRef = new Reference();
		System.out.println("GC 실행 전 : " + strongRef);
		System.gc();
		System.out.println("GC 실행 후 : " + strongRef);

		strongRef = null; // null 참조를 통해 gc 대상으로 만들 수 있음


		Object softObj = new Object();
		SoftReference<Object> softRef = new SoftReference<>(softObj);
		softObj = null;

		System.gc();

		// GC 가 여유롭다면 해시코드를 확인할 수 있다.
		System.out.println(softRef.get());


		Object weakObj = new Object();
		WeakReference<Object> weakRef = new WeakReference<>(weakObj);
		weakObj = null;

		System.gc();

		// 무조건 null 을 확인하게 된다.
		System.out.println(weakRef.get());
	}
}
