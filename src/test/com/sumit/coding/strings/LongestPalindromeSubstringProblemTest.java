package test.com.sumit.coding.strings;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.com.sumit.coding.strings.LongestPalindromeSubstringProblem;

public class LongestPalindromeSubstringProblemTest {

    LongestPalindromeSubstringProblem longestPalindromeSubstringProblem;

    @Before
    public void before() {
        longestPalindromeSubstringProblem = new LongestPalindromeSubstringProblem();
    }

    @Test(expected = NullPointerException.class)
    public void test_NullStrings() {
        String str = null;
        Assert.assertNull(longestPalindromeSubstringProblem.longestPalindrome(str));
    }

    @Test
    public void test_longestPalindromePositiveTestCase() {
        String str = "forgeeksskeegfor";
        String result = "geeksskeeg";

        Assert.assertEquals(result, longestPalindromeSubstringProblem.longestPalindrome(str));
    }

    @Test
    public void test_longestPalindromeNegativeTestCase() {
        String str = "forgeeksskeegfor";
        String result = "geeksskeegs";

        Assert.assertNotEquals(result, longestPalindromeSubstringProblem.longestPalindrome(str));
    }

    @Test
    public void test_longestPalindromeTestCase_1() {
        String str = "babad";
        String result = "bab";

        Assert.assertEquals(result, longestPalindromeSubstringProblem.longestPalindrome(str));
    }

    @Test
    public void test_longestPalindromeTestCase_2() {
        String str = "cbbd";
        String result = "bb";

        Assert.assertEquals(result, longestPalindromeSubstringProblem.longestPalindrome(str));
    }

    @After
    public void after() {
        longestPalindromeSubstringProblem = null;
    }

}
