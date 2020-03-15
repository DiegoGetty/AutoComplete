

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AutocompleteTests {
    @Test
    public void searchTest() {

        Trie a = new Trie(new String[]{"hello", "high", "seattle", "seatac", "see", "hollow", "how"});

        //assertEquals(Arrays.asList("hello", "high", "hollow", "how"), mas.search("h"));
        assertEquals(Arrays.asList("hello", "high", "how", "hollow"), a.search("h"));
        assertEquals(Arrays.asList("seatac", "seattle", "see"), a.search("se"));
        assertEquals(Arrays.asList("seatac", "seattle"), a.search("sea"));
        assertEquals(Arrays.asList("how", "hollow"), a.search("ho"));
        assertEquals(Arrays.asList(), a.search("xyz"));
    }
}