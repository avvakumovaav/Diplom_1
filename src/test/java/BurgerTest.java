import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
    private final float bunPrice = 1f;
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
        when(ingredient1.getPrice()).thenReturn(1f);
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);

        when(ingredient2.getName()).thenReturn("Ingredient2");
        when(ingredient2.getPrice()).thenReturn(2f);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);

        when(ingredient2.getName()).thenReturn("Ingredient3");
        when(ingredient2.getPrice()).thenReturn(3f);
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
        assertEquals("Invalid addIngredient method", 1, burger.ingredients.size());
        assertEquals("Invalid addIngredient method",ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(listOfIngredients.get(0));
        burger.addIngredient(listOfIngredients.get(1));
        burger.removeIngredient(0);
        assertEquals("Invalid removeIngredient method", 1, burger.ingredients.size());
        assertEquals("Invalid removeIngredient method", ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(listOfIngredients.get(0));
        burger.addIngredient(listOfIngredients.get(1));
        burger.addIngredient(listOfIngredients.get(2));
        burger.moveIngredient(2, 0);
        assertEquals("Invalid moveIngredient method", ingredient3, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        float expectedBurgerPrice = (bun.getPrice() * 2) +
                ingredient1.getPrice() +
                ingredient2.getPrice();
        burger.setBuns(bun);
        burger.addIngredient(listOfIngredients.get(0));
        burger.addIngredient(listOfIngredients.get(1));
        float actualBurgerPrice = burger.getPrice();
        assertEquals("Invalid getPrice method", expectedBurgerPrice, actualBurgerPrice, delta);
    }


}
