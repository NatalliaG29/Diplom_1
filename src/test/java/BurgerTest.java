import org.junit.Assert;
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

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    private Ingredient mockIngredient1;
    @Mock
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }
    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        Assert.assertTrue(burger.ingredients.contains(mockIngredient1));
    }

    @Test
    public void testRemoveIngredient() {
        burger.ingredients.add(mockIngredient1);
        burger.ingredients.add(mockIngredient2);

        burger.removeIngredient(0);

        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.ingredients.add(mockIngredient1);
        burger.ingredients.add(mockIngredient2);

        burger.moveIngredient(0, 1);

        Assert.assertEquals(mockIngredient2, burger.ingredients.get(0));
        Assert.assertEquals(mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(bun.getPrice()).thenReturn(750F);
        when(mockIngredient1.getPrice()).thenReturn(500.9F);
        when(mockIngredient2.getPrice()).thenReturn(320.7F);
        burger.setBuns(bun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float totalPrice = burger.getPrice();

        Assert.assertEquals(2321.6F, totalPrice, 0);
    }

    @Test
    public void testGetReceipt() {
        when(bun.getName()).thenReturn("Галактическая булка");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getName()).thenReturn("Биокотлета из цветов");
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient2.getName()).thenReturn("Соус Spicy");
        burger.setBuns(bun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String receipt = burger.getReceipt();

        String expectedReceipt = "(==== Галактическая булка ====)\r\n" +
                "= filling Биокотлета из цветов =\r\n" +
                "= sauce Соус Spicy =\r\n" +
                "(==== Галактическая булка ====)\r\n" +
                "\r\n" +
                "Price: 0,000000\r\n";
        Assert.assertEquals(expectedReceipt, receipt);
    }
}
