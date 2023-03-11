package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ScaleLibrary {
	private static Map<String, int[]> scaleMap;

	public ScaleLibrary() {
		scaleMap = new HashMap<String, int[]>();
		loadData();
	}

	public static void loadData() {

		String line = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader("resources/data/music-scales.csv"));
			while ((line = br.readLine()) != null) {
				String name = line.substring(1, line.indexOf('"', 1));
				String intervalString = line.substring(line.lastIndexOf('"') + 2, line.lastIndexOf(','));
				int[] intervals = Arrays.stream(intervalString.split(",")).mapToInt(Integer::parseInt).toArray();
				scaleMap.put(name, intervals);

			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Map<String, int[]> getScaleMap() {
		return scaleMap;
	}
}
