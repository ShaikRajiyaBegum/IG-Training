package com.hcl.java8.streamexamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConversionOfMapToList {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "rajiya");
		map.put(2, "lalahmad");
		map.put(3, "nausheen");
		map.put(4, "thyseen");

		// ConversionOf MapToList normal approach
		List<Integer> listKeySet = new ArrayList<>(map.keySet());
		System.out.println(listKeySet);
		List<String> listValueSet = new ArrayList<>(map.values());
		System.out.println(listValueSet);
		System.out.println(".................");

		// ConversionOf MapToList byStreams approach
		List<Integer> listKeySet1 = map.keySet().stream().collect(Collectors.toList());
		System.out.println(listKeySet1);
		List<String> listValueSet1 = map.values().stream().collect(Collectors.toList());
		System.out.println(listValueSet1);
		System.out.println(".................");

		// getting the even keyset
		List<Integer> listKeySet2 = listKeySet1.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println(listKeySet2);
	}

}
