import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameters(name = "{index}: Ingredient Type = {0}")
    public static IngredientType[] data() {
        return IngredientType.values();
    }

    @Parameterized.Parameter
    public IngredientType ingredientType;

    @Test
    public void testIngredientType() {
        assertEquals(ingredientType.toString(), ingredientType.name());
        assertEquals(ingredientType.ordinal(), IngredientType.valueOf(ingredientType.name()).ordinal());
    }
}
