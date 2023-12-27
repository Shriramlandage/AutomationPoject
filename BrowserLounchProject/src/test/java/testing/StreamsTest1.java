package testing;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.apache.poi.ss.formula.functions.Count;
import org.junit.Test;

public class StreamsTest1 {

	// Count the number of names starting with alphabet A in list

	// @Test
	public void regular() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Abjeet");
		names.add("Shriram");
		names.add("Akash");
		names.add("Aman");
		names.add("Tejas");
		names.add("Akbar");
		names.add("Manish");
		names.add("Manoj");

		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}

	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Abjeet");
		names.add("Shriram");
		names.add("Akash");
		names.add("Ak");
		names.add("Tejas");
		names.add("Akbar");
		names.add("Manish");
		names.add("Manoj");

		// There is no life for interediate op if there is no terminal op
		// terminal operation will execute only if inter op (filter) returns true
		// we can create stream
		// how to use filter in Stream API

		Long c = names.stream().filter(s -> s.startsWith("Shriram")).count();
		System.out.println(c);

		long d = Stream.of("Abhijeet", "Shriram", "Akash", "Aman", "Tejas", "Akbar", "Manish", "Manoj").filter(s -> {
			s.startsWith("T");
			return true;
		}).count();
		System.out.println(d);

		// print all the names of ArrayList
		// names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(2).forEach(s -> System.out.println(s));

	}
}
