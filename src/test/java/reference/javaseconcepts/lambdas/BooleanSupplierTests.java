package reference.javaseconcepts.lambdas;

import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooleanSupplierTests {

    @Test
    public void booleanSupplier_1() {
        BooleanSupplier returnTrue = () -> true;

        boolean value = returnTrue.getAsBoolean();

        assertTrue(value);
    }

    @Test
    public void booleanSupplier_2() {
        BooleanSupplier isDataBaseUp = AppUtil::isDataBaseUp;
        BooleanSupplier isInternetUp = AppUtil::isInterntUp;

        assertTrue(isDataBaseUp);
        assertFalse(isInternetUp);
    }

    @Test
    public void booleanSupplier_3() {
        final int val = 5;
        BooleanSupplier isEven = () -> val % 2 == 0;

        assertFalse(isEven);
    }

    class AppUtil {
        public static boolean isDataBaseUp() {
            return true;
        }

        public static boolean isInterntUp() {
            return false;
        }
    }

}
