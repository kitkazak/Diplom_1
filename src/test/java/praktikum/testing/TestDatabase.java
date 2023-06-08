package praktikum.testing;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Database;

public class TestDatabase {
    @Test
    public void testAvailableBunsReturnBunsWithSizeEquals3() {
        Database db = new Database();
        Assert.assertEquals(3, db.availableBuns().size());
    }

    @Test
    public void testAvailableIngredientsReturnIngredientsWithSizeEquals6() {
        Database db = new Database();
        Assert.assertEquals(6, db.availableIngredients().size());
    }
}
