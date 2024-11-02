import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;
    private final String bunName = "Bun1";
    private final float bunPrice = 12.34f;
    @Mock
    Ingredient ingredient1, ingredient2, ingredient3;

    private @Mock List<Ingredient> listOfIngredients;
    float delta = 0.1f;

    @Before
    public void init() {
        burger = new Burger();

        when(bun.getName()).thenReturn(bunName);
        when(bun.getPrice()).thenReturn(bunPrice);

        when(ingredient1.getName()).thenReturn("Ingredient1");
        when(ingredient1.getPrice()).thenReturn(45.0f);
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);

        when(ingredient2.getName()).thenReturn("Ingredient2");
        when(ingredient2.getPrice()).thenReturn(67f);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);

        when(ingredient2.getName()).thenReturn("Ingredient3");
        when(ingredient2.getPrice()).thenReturn(89.99f);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        listOfIngredients = Arrays.asList(ingredient1, ingredient2, ingredient3);
    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertEquals("Invalid setBuns method",bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(listOfIngredients.get(0));
        assertEquals("Invalid ingredient list size", 1, burger.ingredients.size());
    }
}
