package practice.effectjvejava.lambda;

public class OperationExec {

    public static void main(String[] args) {
        Operation plus = Operation.PLUS;

        double x = 1.0;
        double y = 2.0;

        double result = plus.apply(x, y);

        System.out.println(result);
    }
}
