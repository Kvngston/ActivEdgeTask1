import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		var scanner = new Scanner(System.in);

		System.out.println("Enter a list of numbers seperated by 'space' press enter when done...");
		var input = scanner.nextLine();

		input = input.trim();

		var integerRegex = "[0-9- ]+";

		if (!Pattern.matches(integerRegex, input)) {
			System.out.println("Invalid Input, Only digits are allowed");
			input = scanner.nextLine();
		}

		var arrString = input.split(" ");
		var arr = Arrays.stream(arrString).mapToInt(Integer::parseInt).toArray();
		System.out.println("Result: " + smallestNonOccurringPositiveNumber(arr));
	}

	public static int smallestNonOccurringPositiveNumber(int[] arr) {
		var hashSet = new HashSet<Integer>();
		Arrays.stream(arr).forEach(hashSet::add);

		return IntStream.rangeClosed(1, arr.length + 1).filter(i -> !hashSet.contains(i)).findFirst().orElse(1);
	}
}
