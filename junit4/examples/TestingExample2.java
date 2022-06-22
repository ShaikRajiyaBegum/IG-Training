package com.hcl.junit4.examples;

import java.util.HashMap;
import java.util.Map;

public class TestingExample2 {

	public String students(final String key) {
		Map<String, String> names = new HashMap<>();
		names.put("key1", "Rajiya");
		names.put("key2", "Raji");
		names.put("key3", "Rafi");

		return names.get(key);
	}

}
