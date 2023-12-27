package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class StreamMap {

	@Test
	public void streamMap() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Developer");
		names.add("Tester");
		names.add("Marketing");
		names.add("iOS Developer");

		// print names which have last letter as "m" with Uppercase
		Stream.of("Abhijeet", "Shriram", "Akash", "Amam", "Tejas", "Akram", "Manish", "Manoj")
				.filter(s -> s.endsWith("m")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

		// print names which have first letter as a with uppercase and sorted

		List<String> names1 = Arrays.asList("Abhijeet", "Shriram", "Akash", "Aman", "Tejas", "Akbar", "Manish",
				"Manoj");
		names1.stream().filter(s -> s.startsWith("T")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// Merging 2 different lists
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		// newStream.sorted().forEach(s-> System.out.println(s));

		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Shriram"));
		System.out.println(flag);
		Assert.assertTrue(flag);

	}

	@Test
	public void streamCollect() {
		List<String> Is = Stream.of("Abhijeet", "Shriram", "Akash", "Amam", "Tejas", "Akram", "Manish", "Manoj")
				.filter(s -> s.endsWith("m")).map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(Is.get(0));

		// Pring unique number from array

		List<Integer> values = Arrays.asList(1, 2, 2, 3, 4, 5, 2, 5, 3);
		values.stream().distinct().forEach(s -> System.out.println(s));

		// Sort the array -3rd Index -1,2,3,4,6,7,8
		List<Integer> Li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(Li.get(2));
	}
}
