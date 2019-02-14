package array;

public class solution {

	public static void main(String[] args) {
		/*
		 * List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4); List<Integer>
		 * distinct = numbers.stream().map(i -> i *
		 * i).distinct().collect(Collectors.toList()); System.out.printf("%s",
		 * distinct);
		 */
		int m = 5005;
		int l = 0;
		for (; (m % 10) > 10;) {
			l = m % 10;
		}
		if ((m % 10) == l) {
			System.out.println("palindrome");
		}

	}
}