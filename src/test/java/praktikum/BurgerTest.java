package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertSame;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient ingredientMockFirst;

    @Mock
    private Ingredient ingredientMockSecond;

    @Before
    public void setUp() {
        burger = new Burger();

    }

    @Test
    public void testSetBun() {
        burger.setBuns(bunMock);
        assertSame(burger.bun, bunMock);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredientMockFirst);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {

        burger.addIngredient(ingredientMockFirst);
        burger.addIngredient(ingredientMockSecond);

        burger.removeIngredient(0);

        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertFalse(burger.ingredients.contains(ingredientMockFirst));
        Assert.assertTrue(burger.ingredients.contains(ingredientMockSecond));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredientMockFirst);
        burger.addIngredient(ingredientMockSecond);

        burger.moveIngredient(0, 1);

        Assert.assertEquals(2, burger.ingredients.size());
        Assert.assertTrue(burger.ingredients.get(0) == ingredientMockSecond);
        Assert.assertTrue(burger.ingredients.get(1) == ingredientMockFirst);
    }







}
