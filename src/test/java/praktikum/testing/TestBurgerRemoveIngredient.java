package praktikum.testing;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class TestBurgerRemoveIngredient {
    @Test
    public void testBurgerRemoveIngredient() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("white bun", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sauce", 100));
        burger.removeIngredient(0);

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "white bun"));
        expectedReceipt.append(String.format("(==== %s ====)%n", "white bun"));
        expectedReceipt.append(String.format("%nPrice: %f%n", 200.0F));

        Assert.assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}
