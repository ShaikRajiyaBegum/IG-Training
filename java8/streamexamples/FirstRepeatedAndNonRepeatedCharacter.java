package com.hcl.java8.streamexamples;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatedAndNonRepeatedCharacter {

	public static void main(String[] args) {

		Map<Character, Long> name = "Rajiya Begum".chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		name.forEach((x, y) -> System.out.println("Key: " + x + " Val: " + y));

		// Finding the first non Repeated character
		Optional<Character> firstNonRepeat = name.entrySet().stream().filter((e) -> e.getValue() == 1)
				.map(e -> e.getKey()).findFirst();
		// System.out.println("firstNonRepeat:" +firstNonRepeat.get());

		if (firstNonRepeat.isPresent()) {
			System.out.println("First non repeating:" + firstNonRepeat.get());
		}

		// Finding the firstReated character
		Optional<Character> firstRepeat = name.entrySet().stream().filter((e) -> e.getValue() > 1).map(e -> e.getKey())
				.findFirst();
		System.out.println("First repeating:" + firstRepeat.orElse(null));

	}

}
