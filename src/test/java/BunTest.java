import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {

    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Флюоресцентная булка", 988 },
                { "Галактическая булка для безумных любителей инопланетных существ с любовью к дробным числам", 55.55f },
                { "null", -150},
                { "", 0},
                { "9999999999", 9999999999.99F },
                {"Cheese Bun", 0.0000001F},
                {"$$$amay vкu$n@y ン!", -1},
    });
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        Assert.assertEquals(name, actualName);
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(price, actualPrice, 0);
    }
}
