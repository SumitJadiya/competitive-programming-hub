package test.com.sumit.coding.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.com.sumit.coding.topics.arrays.SquareAndSortNumbersProblem;

public class SquareAndSortNumbersProblemTest {

    private SquareAndSortNumbersProblem squareAndSortNumbersProblem;

    @Before
    public void before() {
        squareAndSortNumbersProblem = new SquareAndSortNumbersProblem();
    }

    @Test
    public void test_case_1() {
        List<Integer> list = new ArrayList<>(Arrays.asList(-6, -3, -1, 2, 4, 5));
        List<Integer> result = new ArrayList<>(Arrays.asList(1, 4, 9, 16, 25, 36));

        boolean isEqual = result.equals(squareAndSortNumbersProblem.squareAndSort(list));

        Assert.assertTrue(isEqual);
    }

    @Test
    public void test_case_2() {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -4, -2, 0, 1));
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 1, 4, 16, 25));

        boolean isEqual = result.equals(squareAndSortNumbersProblem.squareAndSort(list));

        Assert.assertTrue(isEqual);
    }

    @After
    public void after() {
        squareAndSortNumbersProblem = null;
    }
}
