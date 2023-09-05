public class Dice {
    int number;

    public Dice(int number) {
        if (number < 1 || number > 6) {
            throw new IllegalAccessError("dice number is not 0~6");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
