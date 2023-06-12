package praktikum.testing;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class TestBurgerMoveIngredient {
    @Test
    public void testBurgerMoveIngredient() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("white bun", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.moveIngredient(1, 0);

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "white bun"));
        expectedReceipt.append(String.format("= %s %s =%n", "filling", "cutlet"));
        expectedReceipt.append(String.format("= %s %s =%n", "sauce", "sauce"));
        expectedReceipt.append(String.format("(==== %s ====)%n", "white bun"));
        expectedReceipt.append(String.format("%nPrice: %f%n", 400.0F));

        Assert.assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}
