package praktikum.testing;

import org.junit.Test;
import praktikum.Bun;

public class TestBunPrice {
    @Test(expected = Exception.class)
    public void zeroIsNotAllowedPrice() {
        new Bun("Name", 0);
    }

    @Test(expected = Exception.class)
    public void negativePriceIsNotAllowed() {
        new Bun("Name", -0.01F);
    }

    @Test
    public void minPriceIsPossible() {
        new Bun("Name", 0.01F);
    }

    @Test
    public void largePriceIsPossible() {
        new Bun("Name", Float.MAX_VALUE);
    }
}
