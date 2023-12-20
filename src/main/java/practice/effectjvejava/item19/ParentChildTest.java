package practice.effectjvejava.item19;

public class ParentChildTest {
	public static void main(String[] args) throws Exception {
		// final인 instant의 상태가 2개 존재한다!
		Child child = new Child();
		child.overrideMe();
	}
}
