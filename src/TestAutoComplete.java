import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
public class TestAutoComplete {
	@Test
	public void testAutoComplete() {
		//Creation of the trie
		Trie workingTrie = new Trie();
		List<String> dict = new ArrayList<String>(); 
		dict.add("hello"); dict.add("high"); dict.add("seattle"); dict.add("seatac"); dict.add("see"); dict.add("hollow"); dict.add("how");
		for(String e : dict) {
			workingTrie.insert(e);
		}
		
		//Test Case One | autoComplete("h")
		List<String> expected1 = new ArrayList<String>();
		expected1.add("hello"); expected1.add("high"); expected1.add("hollow"); expected1.add("how");
		assertEquals(expected1, workingTrie.autoComplete("h"));
		
		//Test Case Two | autoComplete("se")
		List<String> expected2 = new ArrayList<String>();
		expected2.add("seatac"); expected2.add("seattle"); expected2.add("see"); 
		assertEquals(expected2, workingTrie.autoComplete("se"));
		
		//Test Case Three | autoComplete("sea")
		List<String> expected3 = new ArrayList<String>();
		expected3.add("seatac"); expected3.add("seattle"); 
		assertEquals(expected3, workingTrie.autoComplete("sea"));
		
		//Test Case Four | autoComplete("ho")
		List<String> expected4 = new ArrayList<String>();
		expected4.add("hollow"); expected4.add("how");
		assertEquals(expected4, workingTrie.autoComplete("ho"));
		
		//Test Case Five (EMPTY CASE)| autoComplete("xyz")
		List<String> expected5 = new ArrayList<String>();
		assertEquals(expected5, workingTrie.autoComplete("xyz"));
	}
}
