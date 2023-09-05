import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.DiceCalculator;

public class DiceJunitTest {
    private Dice first;
    private Dice second;

    @BeforeEach
    void setUp() {
        first = new Dice(2);
        second = new Dice(5);
    }

    @Test
    void addDice() {
        assertEquals(DiceCalculator.addDice(first, second), 7);
    }

    @Test
    @DisplayName("dice sub")
    void subDice() {
        assertEquals(DiceCalculator.subDice(first, second), -3);
    }

    @Test
    void makeDice() {
        Assertions.assertThrows(IllegalAccessError.class, 
            () -> new Dice(11));
    }
}
