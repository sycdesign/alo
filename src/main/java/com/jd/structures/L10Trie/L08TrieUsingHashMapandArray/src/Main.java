import com.jd.structures.L14HashTable.L05HashTableImplementation.FileOperation;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words) &&
                FileOperation.readFile("a-tale-of-two-cities.txt", words)){

            // Test BST
            long startTime = System.nanoTime();

            BSTSet<String> set = new BSTSet<>();
            for(String word: words)
                set.add(word);

            for(String word: words)
                set.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + " s");

            // ---

            // Test TreeMap Trie
            startTime = System.nanoTime();

            Trie trie = new Trie();
            for(String word: words)
                trie.add(word);

            for(String word: words)
                trie.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("TreeMap Trie: " + time + " s");

            // ---

            // Test HashMap Trie
            startTime = System.nanoTime();

            Trie2 trie2 = new Trie2();
            for(String word: words)
                trie2.add(word);

            for(String word: words)
                trie2.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("HashMap Trie: " + time + " s");

            // ---

            // Test com.jd.structures.L02Arrays.L02CreateOurOwnArray.com.jd.structures.L02Arrays.L03AddElementinArray.com.jd.structures.L02Arrays.L04QueryandUpdateElement.com.jd.structures.L02Arrays.L05ContainFindandRemove.com.jd.structures.L02Arrays.L06GenericDataStructures.Array(Map) Trie
            startTime = System.nanoTime();

            Trie3 trie3 = new Trie3();
            for(String word: words)
                trie3.add(word);

            for(String word: words)
                trie3.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("com.jd.structures.L02Arrays.L02CreateOurOwnArray.com.jd.structures.L02Arrays.L03AddElementinArray.com.jd.structures.L02Arrays.L04QueryandUpdateElement.com.jd.structures.L02Arrays.L05ContainFindandRemove.com.jd.structures.L02Arrays.L06GenericDataStructures.Array(Map) Trie: " + time + " s");
        }
    }
}
