import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Хрустящие минеральные кольца", 150.2f);
        IngredientType expected = IngredientType.FILLING;
        Assert.assertEquals("Тип ингредиента неверный", expected,ingredient.getType());
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Традиционный галактический", 83.5f);
        String expected = "Традиционный галактический";
        Assert.assertEquals("Наименование ингредиента неверное",expected,ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 100.1f);
        float expected = 100.1f;
        Assert.assertEquals("Цена ингредиента неверная", expected,ingredient.getPrice(), 0);
    }
}
