import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TrieUse {
    public static void main(String args[]) {
//        Trie trie = new Trie();
//        trie.addString("book");
//        trie.addString("books");
//        System.out.println(trie.searchString("boo"));
//        trie.deleteString("book");
//        System.out.println(trie.searchString("book"));
//        System.out.println(trie.searchString("books"));
//        System.out.println(trie.countWords());
//        trie.addString("hellojava");
//        trie.addString("book");
//        System.out.println(trie.countWords());
//        trie.printWords();
//
//        PatternMatching matching = new PatternMatching();
//        String words[] = {"abc", "def", "ghi", "cba"};
//        matching.patternMatching(words);
//        System.out.println(matching.searchWord("ef"));
//        System.out.println(matching.searchWord("de"));

//        AutoComplete complete = new AutoComplete();
//        String word = "hello dog hell cat a hel help helps helping";
//        String words[] = word
//                .split(" ");
//        complete.autoComplete(words, "hel");
//
//        UniqueShortestPrefix prefix = new UniqueShortestPrefix();
//        String arr[] = {"zebra", "dog", "duck", "dove"};
//        prefix.addWord(arr);
//
//        WordBreak wordBreak = new WordBreak();
//        String dictionary[] = {"mobile", "samsung", "sam",
//                "sung", "man", "mango",
//                "icecream", "and", "go", "i",
//                "like", "ice", "cream"};
//        System.out.println(wordBreak.addWord(dictionary, "samsungandmangok"));
//        int[][] arr = {{0, 1, 0, 0, 1},
//                {1, 0, 1, 1, 0},
//                {0, 1, 0, 0, 1},
//                {1, 0, 1, 0, 0}};
//        UniqueRows.addMatrix(arr);
//		Scanner ob = new Scanner(System.in);
//
//		SortingWords sortingWords = new SortingWords();
//		int n = ob.nextInt();
//		String words[] = new String[n];
//		for (int i = 0; i < words.length; i++) {
//			words[i] = ob.next();
//		}
//		sortingWords.sortWord(words);
//
//		DistinctSubstrings distinctSubstrings = new DistinctSubstrings();
//		distinctSubstrings.distinctSubstrings("ababa");

//		WordBoggle wordBoggle = new WordBoggle();
//		String words[] = {"GEEKS", "FOR", "QUIZ", "GO"};
//		char arr[][] = {{'G', 'I', 'Z'},
//				{'U', 'E', 'K'},
//				{'Q', 'S', 'E'}};
//		wordBoggle.boogleWord(words, arr);
//		String dictionary[] = {"geeks", "code", "xyz",
//				"forgeeks", "paper"};
//		String str = "geeksforgeeks";

//		TwoWords twoWords = new TwoWords();
//		twoWords.concatenateWords(dictionary, str);
//
//		PreixSuffix preixSuffix = new PreixSuffix();
//		String arr[] = {"apple", "app", "biscuit", "mouse", "orange", "bat", "microphone", "mine"};
//		List<String> list = Arrays.asList(arr);
//		preixSuffix.prefixSuffix(arr, "a", "b");

//		SpellChecker spellChecker = new SpellChecker();
//		String str[] = { "gee", "geeks", "ape", "apple", "geeksforgeeks" };
//		spellChecker.spellChecker(str, "geek");

//		PrintUniqueString printUniqueString = new PrintUniqueString();
//		String arr [] = { "geeks", "geek", "ab", "geek", "code", "karega" };
//		printUniqueString.printUniqueString(arr);

//		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
//		String arr[] = { "geeksforgeeks", "geeks", "geeksforcse" };
//		longestCommonPrefix.longesPrefix(arr);

//		PossibleJoints possibleJoints = new PossibleJoints();
////		String str[] = { "geek", "geeky",
////				"geeks", "gel" };
////		possibleJoints.possibleJoints(str);

//		PatternArrays patternArrays = new PatternArrays();
//		String str[] = {"moon", "soon", "month", "date", "data"};
//		patternArrays.patternArrays(str, "d.t.");

//        SuffixString suffixString = new SuffixString();
//        String arr[] = {"geeks", "geeksforgeeks", "geek", "newgeeks", "friendsongeeks", "toppergeek"};
//        suffixString.suffixString(arr, "geeks");

//        MostFrequent mostFrequent = new MostFrequent();
//        String words[] = {"geeks", "for", "geeks", "a",
//                "portal", "to", "learn", "can",
//                "be", "computer", "science",
//                "zoom", "yup", "fire", "in",
//                "be", "data", "geeks"};
//        mostFrequent.mostFrequent(words);

//        MaxXOR maxXOR = new MaxXOR();
//        int arr[] = {8,10,2};
//        maxXOR.maxXor(arr);

//        LongestPrefix longestPrefix = new LongestPrefix();
//        String str [] = {"geeksforgeeks", "geeks", "geeksforcse" };
//        longestPrefix.longestPrefix(str);

        String str[] = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        ConcatenatedWords.concatenateWords(str);
    }

}
