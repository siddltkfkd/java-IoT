public class LoggerTest {
    public static int sum (int a, int b) {
        MyLogger.getLogger().info("plus : " + a + "+" + b);
        return a+b;
    }

    public static double divide (int a, int b) {
        MyLogger.getLogger().info("divide : " + a +"/"+ b);
        if (b==0) {
            MyLogger.getLogger().info("can not divide 0");
            throw new ArithmeticException("can not divide 0");
        }
        return a/b;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        System.out.println(sum(a, b));
        System.out.println(divide(a, b));
    }


}
