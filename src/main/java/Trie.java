import java.util.HashMap;

public class Trie {

  Character prefix;
  HashMap<Character, Trie> trieMap;
  int prefixCount;

  public Trie() {
    prefix = null;
    trieMap = new HashMap<Character, Trie>();
    prefixCount = 0;
  }

  public void add(String word) {
    if (word == null || word.length() == 0)
      return;
    if (prefix == null)
      prefix = new Character(word.charAt(0));
    prefixCount++;
    if (word.length() > 1) {
      Character nextChar = new Character(word.charAt(1));
      if (!trieMap.containsKey(nextChar)) {
        Trie subTrie = new Trie();
        subTrie.add(word.substring(1));
        trieMap.put(nextChar, subTrie);
      }else{
        Trie subTrie = trieMap.get(nextChar);
        subTrie.add(word.substring(1));
      }
    }

  }

  public boolean contains(String word) {
    return containsHelper(word, 0);
  }

  private boolean containsHelper(String word, int i) {
    if(word.length() == 0 || word == null)
      return true;
    if (word.length() == 1){
      if (prefix.equals(Character.valueOf(word.charAt(0)))) {
        return true;
      }else{
        return false;
      }
    }
    
    if(prefix.equals(Character.valueOf(word.charAt(0))) && trieMap.containsKey(Character.valueOf(word.charAt(1)))){
      return trieMap.get(Character.valueOf(word.charAt(1))).contains(word.substring(1));
    }else{
      return false;
    }
  }
}
