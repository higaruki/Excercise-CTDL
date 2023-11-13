package lab8_map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;

public class MyWordCountApp {
	// public static final String fileName = "src/data/hamlet.txt";
	public static final String fileName = "src/data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its
	// occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		Scanner input = new Scanner(new File("src/data/fit.txt"));
		while (input.hasNext()) {
			String tmp = input.next();
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
		}
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		int numberOfDistinctTokens = 0;
		for (String arr : map.keySet()) {
			if (map.get(arr) == 1) {
				numberOfDistinctTokens++;
			}
		}
		return numberOfDistinctTokens;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		for (String arr : map.keySet()) {
			if (map.get(arr) == 1) {
				System.out.print(arr + "-" + map.get(arr) + " ");
			}
		}
		System.out.println();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		TreeMap<String, Integer> t1 = new TreeMap<>();
		t1.putAll(map);
		System.out.println(t1);
	}

	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp m1 = new MyWordCountApp();
		//loadData()
		System.out.println("loadData() : ");
		m1.loadData();
		System.out.println(m1.map);
		//countUnique()
		System.out.println("------------------------------");
		System.out.println("The number of unique tokens : " + m1.countUnique());
		//printWordCounts()
		System.out.println("------------------------------");
		System.out.println("printWordCounts() : \n");
		m1.printWordCounts();
		//printWordCountsAlphabet()
		System.out.println("------------------------------");
		System.out.println("printWordCountsAlphabet() : \n");
		m1.printWordCountsAlphabet();
	}
}
