package practice.modernjava.reactive.flow;

public class Excel {

    public static void main(String[] args) {
        ArithmeticCell c3 = new ArithmeticCell("C3");
        SimpleCell c1 = new SimpleCell("C1");
        SimpleCell c2 = new SimpleCell("C2");

        c1.subscribe(c3::setLeft);
        c2.subscribe(c3::setRight);

        c1.onNext(10);
        c2.onNext(20);
        c1.onNext(17);

        System.out.println("===========================================");

        ArithmeticCell c4 = new ArithmeticCell("C4");
        ArithmeticCell c5 = new ArithmeticCell("C5");

        c1.subscribe(c4::setLeft);
        c3.subscribe(c4::setRight);

        c2.subscribe(c5::setLeft);
        c4.subscribe(c5::setRight);

        c1.onNext(30);
        c2.onNext(40);
    }
}
