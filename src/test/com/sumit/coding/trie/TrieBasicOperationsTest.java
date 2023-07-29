package test.com.sumit.coding.trie;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.com.sumit.coding.topics.trie.basicOperations.Trie;

public class TrieBasicOperationsTest {

    private List<String> setOfStrings;

    private Trie trie;

    @Test
    @Before
    public void before() {
        setOfStrings = new ArrayList<>();
        setOfStrings.add("pqrs");
        setOfStrings.add("pprt");
        setOfStrings.add("psst");
        setOfStrings.add("qqrs");
        setOfStrings.add("pqrs");
        trie = new Trie();
        setOfStrings.forEach(trie::insert);
    }

    @Test
    public void test_countOfStrings() {
        Assert.assertEquals(2, trie.query("pqrs"));
        Assert.assertEquals(1, trie.query("pprt"));
        Assert.assertEquals(1, trie.query("psst"));
        Assert.assertEquals(1, trie.query("qqrs"));
    }

    @Test
    public void test_queryNotFound() {
        Assert.assertEquals(0, trie.query("asasds"));
    }

    @Test
    public void test_insertNewString() {
        trie.insert("pqrs");
        Assert.assertEquals(3, trie.query("pqrs"));
    }

    @Test
    public void test_deletePreviousString() {
        trie.delete("pqrs");
        Assert.assertEquals(1, trie.query("pqrs"));
    }

    @Test
    public void test_updatePreviousString() {
        trie.update("pqrs", "psst");
        Assert.assertEquals(2, trie.query("psst"));
    }


    @Test
    @After
    public void after() {
        setOfStrings = null;
        trie = null;
    }

}
