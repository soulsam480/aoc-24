import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1p2 {

	public static void main(String[] args) {

		try {
			List<String> lines = Files.readAllLines(Paths.get("day-1.txt"));

			List<Integer> left = new ArrayList<>();
			List<Integer> right = new ArrayList<>();

			for (String line : lines) {
				String[] parts = line.split("\\s+");

				left.add(Integer.parseInt(parts[0]));
				right.add(Integer.parseInt(parts[1]));
			}

			// left.sort(Comparator.comparingInt(it -> it));
			// right.sort(Comparator.comparingInt(it -> it));

			Map<Integer, Integer> repeat = new HashMap<>();

			for (int i = 0; i < right.size(); i++) {
				int key = right.get(i);

				if (repeat.containsKey(key)) {
					repeat.put(key, repeat.get(key) + 1);
					continue;
				}

				repeat.put(key, 1);

			}

			int total = 0;

			for (int i = 0; i < left.size(); i++) {

				int l = left.get(i);

				if (!repeat.containsKey(l)) {
					continue;
				}

				System.out.printf("%s * %s\n", l, repeat.get(l));

				int score = l * repeat.get(l);

				total += score;

			}

			System.out.printf("Distance is: %s \n", total);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
