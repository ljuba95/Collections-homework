package main;

import java.util.HashMap;
import java.util.Map;

public class Bigram {
	//=========
	public static void main(String[] args) {
		String input = "abbcceeeeeeabcc";
		go(input);
	}
	//=========
	
	private static Map<String, Integer> getFreq(String input){
		Map<String, Integer> freq = new HashMap<>();
		for (int i = 2; i <= input.length(); i++) {
			String bigram = input.substring(i-2, i);
			if(freq.containsKey(bigram)){
				int old = freq.get(bigram);
				freq.replace(bigram, ++old);
			}else{
				freq.put(bigram, 1);
			}
		}
		return freq;
	}
	private static void go(String input){
		Map<String, Integer> freq = new HashMap<>();
		freq = getFreq(input);
		for (Map.Entry<String, Integer> entry : freq.entrySet()) {
			System.out.println(entry);
		}
	}
	

}
