import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Before
    public void init() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Parameterized.Parameters(name = "ingredientType, name, price: {0}, {1}\n")
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {IngredientType.SAUCE, "ingredient1", 12.31f},
                {IngredientType.SAUCE, "ingredient2", 45.0f},
                {IngredientType.FILLING, "ingredient3", 46f},
                {IngredientType.FILLING, "ingredient4", -0.5f},
                {IngredientType.FILLING, "ingredient5", 0f}
        };
    }

    @Test
    public void getTypeTest() {
        assertEquals("Invalid ingredient type", ingredientType, ingredient.getType());
    }

    @Test
    public void getNameTest() {
        assertEquals("Invalid ingredient name", name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        var delta = 0.1f;
        assertEquals("Invalid ingredient price", price, ingredient.getPrice(), delta);
    }
}
