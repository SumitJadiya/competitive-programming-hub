package test.com.sumit.coding.arrays;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.com.sumit.coding.topics.arrays.ReplaceWithGreatestElementOnRight;

public class ReplaceWithGreatestElementOnRightTest {

    private ReplaceWithGreatestElementOnRight replaceWithGreatestElementOnRight;

    @Before
    public void before() {
        replaceWithGreatestElementOnRight = new ReplaceWithGreatestElementOnRight();
    }

    @Test
    public void checkValidTestCase_1() {
        int[] list = {17, 18, 5, 4, 6, 1};
        int[] result = {18, 6, 6, 6, 1, -1};

        boolean isEqual = Arrays.equals(result, replaceWithGreatestElementOnRight.replaceElements(list));
        Assert.assertTrue(isEqual);
    }

    @Test
    public void checkValidTestCase_2() {
        int[] list = {400};
        int[] result = {-1};

        boolean isEqual = Arrays.equals(result, replaceWithGreatestElementOnRight.replaceElements(list));
        Assert.assertTrue(isEqual);
    }

    @Test
    public void checkValidTestCase_3() {
        int[] list = {400, -10, -2, 0};
        int[] result = {0, 0, 0, -1};

        boolean isEqual = Arrays.equals(result, replaceWithGreatestElementOnRight.replaceElements(list));
        Assert.assertTrue(isEqual);
    }


    @After
    public void after() {
        replaceWithGreatestElementOnRight = null;
    }
}
