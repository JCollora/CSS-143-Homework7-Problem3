public class TrieNode {
	//FIELDS
	TrieNode[] children = new TrieNode[26]; 
    boolean endOfWord; 
     
    //CONSRTUCTOR
    TrieNode(){ 
        endOfWord = false; 
        for (int i = 0; i < 26; i++) 
            children[i] = null; 
    } 
}
