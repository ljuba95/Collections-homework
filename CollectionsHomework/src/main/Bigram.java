package main;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class Bigram {
	// =========
	public static void main(String[] args) {
		String input = "abbcceeeeeeabcc";
		String predictInput = "ja";
		go(input, predictInput);
	}
	// =========

	private static void go(String input, String predictInput) {
		Map<String, Integer> freq = new HashMap<>();
		freq = getFreq(input);
		printFreq(freq);
		predict(freq, predictInput);
	}

	private static Map<String, Integer> getFreq(String input) {
		Map<String, Integer> freq = new HashMap<>();
		for (int i = 2; i <= input.length(); i++) {
			String bigram = input.substring(i - 2, i);
			if (freq.containsKey(bigram)) {
				int old = freq.get(bigram);
				freq.replace(bigram, ++old);
			} else {
				freq.put(bigram, 1);
			}
		}
		return freq;
	}

	private static void printFreq(Map<String, Integer> freq) {
		for (Map.Entry<String, Integer> entry : freq.entrySet()) {
			System.out.println(entry);
		}
	}

	private static char getNextLetter(char last, Map<String, Integer> freq) {
		Map.Entry<String, Integer> max = new AbstractMap.SimpleEntry<>("//", 0);
		for (Map.Entry<String, Integer> entry : freq.entrySet()) {
			if (entry.getKey().charAt(0) == last && entry.getValue() > max.getValue())
				max = entry;
		}
		return max.getKey().charAt(1);
	}

	private static void predict(Map<String, Integer> freq, String input) {
		for (int i = 0; i < 3; i++) {
			char lastLetter = input.charAt(input.length() - 1);
			input += getNextLetter(lastLetter, freq);
		}
		if(input.charAt(input.length()-1) == '/')
			input = "Invalid predict string.";
		System.out.println("Predict: " + input);
	}

}
