package main;
 
import test.Dice;

public class DiceCalculator {

    public static int addDice(Dice first, Dice second) {
        return first.getNumber() + second.getNumber();
    }

    public static int subDice(Dice first, Dice second) {
        return first.getNumber() - second.getNumber();
    }

    public static int mulDice(Dice first, Dice second) {
        return first.getNumber() * second.getNumber();
    }

    public static int divDice(Dice first, Dice second) {
        if (second.getNumber() == 0){
            System.out.println("second dice is 0");
            return 0;
        }
        return first.getNumber() / second.getNumber();
    }

    public static Boolean isOdd(Dice dice) {
        return dice.getNumber() % 2 != 0;
    }

    public static Boolean isEven(Dice dice) {
        return dice.getNumber() % 2 == 0;
    }

}
