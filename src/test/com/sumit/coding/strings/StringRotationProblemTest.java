package test.com.sumit.coding.strings;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.com.sumit.coding.topics.strings.StringRotationProblem;

public class StringRotationProblemTest {

    StringRotationProblem stringRotationProblem;

    @Before
    public void before() {
        stringRotationProblem = new StringRotationProblem();
    }

    @Test(expected = NullPointerException.class)
    public void test_NullStrings() {
        String str1 = null;
        String str2 = null;
        Assert.assertNull(stringRotationProblem.checkStringRotation(str1, str2));
    }

    @Test
    public void test_stringsRotationPositiveTestCase() {
        String str1 = "AWEW";
        String str2 = "EWAW";

        Assert.assertTrue(stringRotationProblem.checkStringRotation(str1, str2));
    }

    @Test
    public void test_stringsRotationNegativeTestCase() {
        String str1 = "ASESWS";
        String str2 = "EWAW";

        Assert.assertFalse(stringRotationProblem.checkStringRotation(str1, str2));
    }

    @Test
    public void test_stringsRotationByTwoPlacesPositiveTestCase() {
        String str1 = "AWEW";
        String str2 = "EWAW";

        Assert.assertTrue(stringRotationProblem.checkStringRotatedByTwoPlaces(str1, str2));
    }

    @Test
    public void test_stringsRotationByTwoPlacesNegativeTestCase() {
        String str1 = "ASESWS";
        String str2 = "EWAW";

        Assert.assertFalse(stringRotationProblem.checkStringRotatedByTwoPlaces(str1, str2));
    }

    @After
    public void after() {
        stringRotationProblem = null;
    }
}
