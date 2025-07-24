import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class Day1 {

	private void readFile() {
		try {
			List<String> lines = Files.readAllLines(Paths.get("day-1.txt"));

			List<Integer> left = new ArrayList<>();
			List<Integer> right = new ArrayList<>();

			for (String line : lines) {
				String[] parts = line.split("\\s+");

				left.add(Integer.parseInt(parts[0]));
				right.add(Integer.parseInt(parts[1]));
			}

			left.sort(Comparator.comparingInt(it -> it));
			right.sort(Comparator.comparingInt(it -> it));

			// System.out.printf("ls: %s, lb: %s \n", left.getFirst(), left.getLast());
			// System.out.printf("rs: %s, rb: %s \n", right.getFirst(), right.getLast());

			int dist = 0;

			for (int i = 0; i < left.size(); i++) {

				int l = left.get(i);
				int r = right.get(i);

				System.out.printf("%s - %s = %s\n", l, r, Math.abs(l - r));

				dist += Math.abs(l - r);
			}

			System.out.printf("Distance is: %s \n", dist);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		new Day1().readFile();
		System.out.println("Hello World!");

	}

}
