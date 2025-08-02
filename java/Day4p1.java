import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day4p1 {

	public static void main(String[] args) {

		try {

			String file = Files.readString(Path.of("day-4-p1.txt"));

			String[] rows = file.split("\n");

			int rowCount = rows.length;
			int colCount = rows[0].length();

			System.out.printf("Rows: %s, Cols: %s \n", rowCount, colCount);

			Pattern xmasRe = Pattern.compile("XMAS");
			Pattern samxRe = Pattern.compile("SAMX");

			int totalCount = 0;

			for (int i = 0; i < rowCount; i++) {
				Matcher matcher = xmasRe.matcher(rows[i]);

				Matcher reverseMatcher = samxRe
						.matcher(rows[i]);

				while (matcher.find()) {
					totalCount++;
				}

				while (reverseMatcher.find()) {
					totalCount++;
				}

				String row = "";

				for (int j = 0; j < rowCount; j++) {
					row += rows[j].charAt(i);
				}

				Matcher colMatcher = xmasRe.matcher(row);

				while (colMatcher.find()) {
					totalCount++;
				}

				Matcher colMatcherReverse = samxRe
						.matcher(row);

				while (colMatcherReverse.find()) {
					totalCount++;

				}

			}

			totalCount += IntStream.range(0, rowCount + colCount - 1)
					.reduce(0, (acc, d) -> {
						String r = IntStream.range(0, rowCount)
								.filter(i -> d - i >= 0 && d - i < colCount)
								.mapToObj(i -> String.valueOf(rows[i].charAt(d - i)))
								.collect(Collectors.joining(""));

						Matcher matcher = xmasRe.matcher(r);
						Matcher reverseMatcher = samxRe
								.matcher(r);

						while (matcher.find()) {

							acc++;
						}

						while (reverseMatcher.find()) {

							acc++;
						}

						return acc;

					});

			totalCount += IntStream.range(0, rowCount + colCount - 1)
					.reduce(0, (acc, d) -> {
						String r = IntStream.range(0, rowCount)
								.filter(i -> d - i >= 0 && d - i < colCount)
								.mapToObj(i -> String.valueOf(
										rows[i].charAt(colCount - 1 - (d - i))))
								.collect(Collectors.joining(""));

						Matcher matcher = xmasRe.matcher(r);
						Matcher reverseMatcher = samxRe
								.matcher(r);

						while (matcher.find()) {
							acc++;
						}

						while (reverseMatcher.find()) {

							acc++;
						}

						return acc;
					});

			System.out.printf("found xmas %s times", totalCount);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
