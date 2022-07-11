package practice.modernjava.defaultmethod;

public class C implements A, B {

    // Class의 Method 가 최우선
    // 그 다음으로는 SubInterfasce의 defaultMethod가 우선
    // 우선순위가 동등한 경우 개발자가 직접 어느 인터페이스의 메서드를 쓸지 지정해주면 해결

    // abstract class와의 차이는 effective java 20장 참고
    public static void main(String[] args) {
        new C().hello();
    }
}
