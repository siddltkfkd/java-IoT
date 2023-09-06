import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogback {
    private static final Logger logger = LoggerFactory.getLogger(MyLogback.class);
    
    public static int sum(int a, int b) {
        logger.trace("test = {}, {}", a, b);
        logger.info("plus : {} + {}", a, b);
        return a+b;
    }

    public static int divide (int a, int b) {
        if (b==0) {
            logger.warn("fain.. can not divide 0");
            throw new ArithmeticException("Can't divide 0");
        }
        return a/b;
    }

    public static void main(String[] args) {
        int a = 4;
        int b = 2;

        System.out.println(sum(a, b));
        System.out.println(divide(a, b));
    }
}
