import java.util.*;
public class Trie {
	//FIELDS
	static TrieNode root = new TrieNode();
	
	//TRIE FUNCTIONS
	//----------------------------------------------------------
	//Inserts given items into the trie
	void insert(String item) 
    { 
        String add = item.toLowerCase();
		int level, index; 
        int length = add.length(); 
       
        TrieNode ptr = root; 
        for (level = 0; level < length; level++) { 
            index = add.charAt(level) - 'a'; 
            if (ptr.children[index] == null) { 
            	ptr.children[index] = new TrieNode(); 
            }
            ptr = ptr.children[index]; 
        } 
        ptr.endOfWord = true; 
    } 
	
	//Populates the trie given a set of words
	public void populate(ArrayList<String> set) {
		for(String e : set) {
			insert(e);
		}
	}
	//----------------------------------------------------------
	
	//HOMEWORK METHOD (Unfinished)
	public List<String> autoComplete(String key){
		
		//Gets the last node given the key
		TrieNode lastNode = root;
		int index;
	    for (index = 0; index< key.length(); index++) {
		    lastNode = lastNode.children[key.charAt(index) - 'a'];	     
		    if (lastNode == null) 
		    	   return new ArrayList<String>();      
	    }
	    //Use Recursion to add all possible words 
	    List<String> words = new ArrayList<String>();
	    getWords(words, "" + key, lastNode);
	    return words;
	}
	
	//HELPER FUNCTION
	private void getWords(List<String> result, String wordInProgress, TrieNode start) {
		if(start.endOfWord) {result.add(wordInProgress);}
		for(int i = 0; i < 26; i++) {
			if(start.children[i] != null) {
				getWords(result, wordInProgress + ((char) (i + 'a')), start.children[i]);
			}
		} return;
	}
}
