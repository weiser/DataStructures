import junit.framework.Assert;
import junit.framework.TestCase;

public class TrieTest extends TestCase {

  public void testTrieContainsWords() {
    Trie t = new Trie();
    String[] dictionary = { "ad", "add", "adendum" };

    for (String word : dictionary) {
      t.add(word);
    }

    for (String word : dictionary) {
      Assert.assertEquals("Did not find: '"+word+"' in dictionary",true, t.contains(word));
    }
  }
  
  
}
