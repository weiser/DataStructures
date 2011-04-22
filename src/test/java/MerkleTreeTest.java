import junit.framework.Assert;
import junit.framework.TestCase;

public class MerkleTreeTest extends TestCase {

  /***
   * this function verifies that if I create two MerkleTrees, m1 and m2, from
   * the same object, m1 and m2 will be the same
   */
  public void testIdenticalObjectsHaveSameMerkleTreeHash() {
    
    String message="hello world!";
    MerkleTree m1 = new MerkleTree(message);
    MerkleTree m2 = new MerkleTree(message);
    
    Assert.assertTrue(m1.getHash().equals(m2.getHash()));

  }

}
