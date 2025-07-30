import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Day3p1 {

	public static void main(String[] args) {

		try {

			String file = Files.readString(Path.of("day-3-p1.txt"));

			partOne(file);

			partTwo(file);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void partTwo(String file) {
		Pattern p = Pattern
				.compile("(?<no>don't\\(\\))|(?<yes>do\\(\\))|mul\\((?<left>\\d+),(?<right>\\d+)\\)");

		Matcher matches = p.matcher(file);

		String lastSaw = "";

		int count = 0;

		while (matches.find()) {

			if (matches.group("yes") != null) {
				lastSaw = "yes";

			}

			if (matches.group("no") != null) {
				lastSaw = "no";
			}

			if (matches.group("left") != null && matches.group("right") != null) {
				if (lastSaw.equals("no")) {
					continue;
				}

				int left = Integer.parseInt(matches.group("left"));
				int right = Integer.parseInt(matches.group("right"));

				count += left * right;
			}
		}

		System.out.println(count);

	}

	private static void partOne(String file) {

		Pattern p = Pattern.compile("mul\\((?<left>\\d+),(?<right>\\d+)\\)");

		Matcher matches = p.matcher(file);

		int dayOneTotal = 0;

		while (matches.find()) {
			int left = Integer.parseInt(matches.group("left"));
			int right = Integer.parseInt(matches.group("right"));

			dayOneTotal += left * right;
		}

		System.out.printf("Total is %s\n", dayOneTotal);

	}

}
