package test.com.sumit.coding.trie;

import com.sumit.coding.topics.trie.basicOperations.Trie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        setOfStrings.add("Sumit");
        trie = new Trie();
        setOfStrings.forEach(trie::insert);
    }

    @Test
    public void test_countOfStrings() {
        Assert.assertTrue(trie.query("pqrs"));
        Assert.assertTrue(trie.query("pprt"));
        Assert.assertTrue(trie.query("psst"));
        Assert.assertTrue(trie.query("qqrs"));
    }

    @Test
    public void test_queryNotFound() {
        Assert.assertFalse(trie.query("asasds"));
    }

    @Test
    public void test_insertNewString() {
        trie.insert("pqrs");
        Assert.assertTrue(trie.query("pqrs"));
    }

    @Test
    public void test_deletePreviousString() {
        trie.delete("pqrs");
        Assert.assertFalse(trie.query("pqrs"));
    }

    @Test
    public void test_updatePreviousString() {
        trie.update("pqrs", "psst");
        Assert.assertTrue(trie.query("psst"));
    }

    @Test
    @After
    public void after() {
        setOfStrings = null;
        trie = null;
    }
}
