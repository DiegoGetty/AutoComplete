
import java.util.*;

public class Trie {

    TrieNode node;

    public class TrieNode {
        String root;
        HashMap<Character, TrieNode> children;

        // checks whether it's the last character of a branch
        boolean isLeaf;

        private TrieNode(String prefix) {
            this.root = prefix;
            this.children = new HashMap<Character, TrieNode>();
        }
    }

    // builds trie tree from dictionary added in tests
    public Trie(String[] dict) {
        node = new TrieNode("");
        for (String s : dict){
            insert(s);
        }
    }


    private void insert(String word) {

        TrieNode curr = node;

        // iterates through each character in word
        for (int i = 0; i < word.length(); i++) {
            //if the character doesn't exists in trie then add it
            if (!curr.children.containsKey(word.toLowerCase().charAt(i))) {
                curr.children.put(word.charAt(i), new TrieNode(word.substring(0, i + 1)));
            }
            // locates where to find it and ends it
            curr = curr.children.get(word.charAt(i));
            if (i == word.length() - 1){
                curr.isLeaf = true;
            }
        }
    }

    public List<String> search(String word) {
        List<String> results = new LinkedList<String>();

        // goes to the end of the word
        TrieNode curr = node;
        for (char c : word.toLowerCase().toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return results;
            }
        }
        // at the end of the given word finds all words connected to it and adds it to list
        searchHelper(curr, results);
        // returns list with words
        return results;
    }

    private void searchHelper(TrieNode n, List<String> results) {
        if (n.isLeaf) {
            results.add(n.root);
        }
        for (Character c : n.children.keySet()) {
            // recursive if their are more words connected to it
            searchHelper(n.children.get(c), results);
        }
    }

}