import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private IngredientType ingredientType;
    private String ingredientTypeName;

    public IngredientTypeTest(String ingredientTypeName, IngredientType ingredientType) {
        this.ingredientType = ingredientType;
        this.ingredientTypeName = ingredientTypeName;
    }

    @Parameterized.Parameters(name = "Ingredient type {0}")
    public static Object[][] ingredientTypeParameters() {
        return new Object[][]{
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING}
        };
    }

    @Test
    public void testIngredientTypeName() {
        assertEquals("Invalid ingredient type",ingredientType,IngredientType.valueOf(ingredientTypeName));
    }
}
