package lab8_map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader r1 = new BufferedReader(new FileReader(fileName));
		String line = null;
		int index = 1;
		while (true) {
			line = r1.readLine();
			if (line == null) {
				break;
			}
			StringTokenizer s1 = new StringTokenizer(line, " ");
			while (s1.hasMoreTokens()) {
				String tmp = s1.nextToken();
				if (s1.hasMoreTokens()) {
					add(tmp, index++);
				} else {
					add(tmp, -index++);
				}

			}
		}
		r1.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		if (map.containsKey(word)) {
			a1 = map.get(word);
			a1.add(position);
		} else {
			a1.add(position);
		}
		map.put(word, a1);
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		Map<String, ArrayList<Integer>> treeMap = new TreeMap<>(map);
		for (Entry<String, ArrayList<Integer>> arr : treeMap.entrySet()) {
			System.out.println("\n" + arr.getKey() + " " + arr.getValue());
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() throws IOException {
		int index = 1;
		int max = 0;
		for (String arr : map.keySet()) {
			max += map.get(arr).size();
		}
		while (index < max) {
			for (String arr : map.keySet()) {
				if (map.get(arr).contains(index)) {
					System.out.print(arr + " ");
					index++;
				}
				if (map.get(arr).contains(-index)) {
					System.out.print(arr + " ");
					System.out.println();
					index++;
				}
			}
		}
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		int max = 0;
		String result = "";
		for (String arr : map.keySet()) {
			if (map.get(arr).size() > max) {
				max = map.get(arr).size();
			}
		}
		for (String arr : map.keySet()) {
			if (map.get(arr).size() == max) {
				result += arr + " ";
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		TextAnalyzer t1 = new TextAnalyzer();
		String fileName = "src/data/short.txt";
//		 load file
		System.out.println("load file : \n");
		t1.load(fileName);
		System.out.println(t1.map);
//		// display word
		System.out.println("--------------------------" + "\n displayWords() :");
		t1.displayWords();
//		 display text
		System.out.println("--------------------------" + "\n displayText() :");
		t1.displayText();
		System.out.println();
		// most frequent word
		System.out.println("--------------------------" + "\n mostFrequentWord() :");
		System.out.println(t1.mostFrequentWord());
	}

}
