package praktikum.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class TestBurger {
    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final float expectedPrice;
    private final String receipt;

    public TestBurger(Bun bun, List<Ingredient> ingredients, float expectedPrice, String receipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
        this.receipt = receipt;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredientList.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredientList.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));

        ingredientList.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingredientList.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        ingredientList.add(new Ingredient(IngredientType.FILLING, "sausage", 300));

        // White bun mock
        Bun whiteBun = mock(Bun.class);
        when(whiteBun.getName()).thenReturn("white bun");
        when(whiteBun.getPrice()).thenReturn(100.0F);

        // Black bun mock
        Bun blackBun = mock(Bun.class);
        when(blackBun.getName()).thenReturn("black bun");
        when(blackBun.getPrice()).thenReturn(200.0F);

        // Red bun mock
        Bun redBun = mock(Bun.class);
        when(redBun.getName()).thenReturn("red bun");
        when(redBun.getPrice()).thenReturn(300.0F);

        // White bun receipt
        StringBuilder whiteBunReceipt = new StringBuilder(String.format("(==== %s ====)%n", whiteBun.getName()));
        whiteBunReceipt.append(String.format("= %s %s =%n", ingredientList.get(0).getType().toString().toLowerCase(),
                ingredientList.get(0).getName()));
        whiteBunReceipt.append(String.format("= %s %s =%n", ingredientList.get(3).getType().toString().toLowerCase(),
                ingredientList.get(3).getName()));
        whiteBunReceipt.append(String.format("(==== %s ====)%n", whiteBun.getName()));
        whiteBunReceipt.append(String.format("%nPrice: %f%n", 400.0F));

        // Black bun receipt
        StringBuilder blackBunReceipt = new StringBuilder(String.format("(==== %s ====)%n", blackBun.getName()));
        blackBunReceipt.append(String.format("= %s %s =%n", ingredientList.get(0).getType().toString().toLowerCase(),
                ingredientList.get(0).getName()));
        blackBunReceipt.append(String.format("= %s %s =%n", ingredientList.get(3).getType().toString().toLowerCase(),
                ingredientList.get(3).getName()));
        blackBunReceipt.append(String.format("(==== %s ====)%n", blackBun.getName()));
        blackBunReceipt.append(String.format("%nPrice: %f%n", 600.0F));

        // Red bun receipt
        StringBuilder redBunReceipt = new StringBuilder(String.format("(==== %s ====)%n", redBun.getName()));
        redBunReceipt.append(String.format("= %s %s =%n", ingredientList.get(0).getType().toString().toLowerCase(),
                ingredientList.get(0).getName()));
        redBunReceipt.append(String.format("= %s %s =%n", ingredientList.get(3).getType().toString().toLowerCase(),
                ingredientList.get(3).getName()));
        redBunReceipt.append(String.format("(==== %s ====)%n", redBun.getName()));
        redBunReceipt.append(String.format("%nPrice: %f%n", 800.0F));

        return new Object[][] {
                {
                        whiteBun,
                        ingredientList,
                        300.0F,
                        whiteBunReceipt.toString()
                },
                {
                        blackBun,
                        ingredientList,
                        500.0F,
                        blackBunReceipt.toString()
                },
                {
                        redBun,
                        ingredientList,
                        700.0F,
                        redBunReceipt.toString()
                }
        };
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredients.get(0));

        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(3));

        Assert.assertEquals(receipt, burger.getReceipt());
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
}
