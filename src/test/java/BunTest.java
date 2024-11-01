import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void init() {
        bun = new Bun(name, price);
    }

    @Parameterized.Parameters(name = "name, price: {0}, {1}\n")
    public static Object[][] getBunData() {
        return new Object[][]{
                { "Bun1", 12.3f},
                { "Bun2", 45.0f},
                { "Bun3", 46f},
                { "Bun4", -0.5f},
                { "Bun5", 0f},
        };
    }

    @Test
    public void getNameTest() {
        assertEquals("Invalid bun name", name, bun.getName());

    }

    @Test
    public void getPriceTest() {
        var delta = 0.1f;
        assertEquals("Invalid bun price", price, bun.getPrice(), delta);
    }
}
