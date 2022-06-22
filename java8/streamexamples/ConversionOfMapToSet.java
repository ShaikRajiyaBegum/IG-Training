package com.hcl.java8.streamexamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ConversionOfMapToSet {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(101, "raju");
		map.put(102, "rani");
		map.put(103, "seetha");
		map.put(104, "geetha");
		map.put(104, "geetha");

		// ConversionOf MapToList normal approach
		Set<Integer> setKeySet = new HashSet<>(map.keySet());
		System.out.println(setKeySet);
		Set<String> setValueSet = new HashSet<>(map.values());
		System.out.println(setValueSet);
		System.out.println(".................");

		// ConversionOf MapToList byStreams approach
		Set<Integer> setKeySet1 = map.keySet().stream().collect(Collectors.toSet());
		System.out.println(setKeySet1);
		Set<String> setValueSet1 = map.values().stream().collect(Collectors.toSet());
		System.out.println(setValueSet1);
		System.out.println(".................");

		// getting the even keyset
		Set<Integer> setKeySet2 = setKeySet1.stream().filter(n -> n % 2 == 0).collect(Collectors.toSet());
		System.out.println(setKeySet2);
	}

}
