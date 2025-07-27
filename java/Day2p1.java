import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2p1 {

	private static List<Integer> ALLOWED_DIFF = new ArrayList<>(Arrays.asList(1, 2, 3));

	public static void main(String[] args) {
		// p-1
		part1();

		// p-2
		part2();

	}

	public static void part2() {

		try {
			List<String> lines = Files.readAllLines(Paths.get("day-2-p1.txt"));

			int valid = 0;

			parent: for (String line : lines) {
				List<String> parts = new ArrayList<>(Arrays.asList(line.split("\\s+")));

				if (is_valid(parts)) {
					valid++;
					continue;
				}

				for (int i = 0; i < parts.size(); i++) {

					List<String> toCheck = new ArrayList<>();

					for (int k = 0; k < parts.size(); k++) {

						if (k != i) {
							toCheck.add(parts.get(k));
						}
					}

					if (is_valid(toCheck)) {
						valid++;
						continue parent;
					}

				}

			}

			System.out.printf("Valid reports are %s\n", valid);

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	public static void part1() {

		try {
			List<String> lines = Files.readAllLines(Paths.get("day-2-p1.txt"));

			int valid = 0;

			for (String line : lines) {
				List<String> parts = new ArrayList<>(Arrays.asList(line.split("\\s+")));

				if (is_valid(parts)) {
					valid++;
				}

			}

			System.out.printf("Valid reports are %s\n\n", valid);

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	public static boolean is_valid(List<String> parts) {

		if (parts.size() < 2) {
			return false;

		}

		int firstDiff = 0;

		for (int i = 1; i < parts.size(); i++) {

			int prev = Integer.parseInt(parts.get(i - 1));
			int curr = Integer.parseInt(parts.get(i));

			int diff = prev - curr;

			if (!ALLOWED_DIFF.contains(Math.abs(diff))) {
				return false;
			}

			if (i == 1) {
				firstDiff = diff;
				continue;
			}

			if (Integer.signum(firstDiff) != Integer.signum(diff)) {
				return false;
			}

		}

		return true;

	}

}
