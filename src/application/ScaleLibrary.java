package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ScaleLibrary {
	final private static String[] noteSequence = {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
	private static Map<String, int[]> scaleMap; 
	public ScaleLibrary() {
		scaleMap = new HashMap<String, int[]>();
		loadData();
	}
	
	public static void loadData() {
		
		
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/music-scales.csv"));
			while((line = br.readLine())!=null) {
				String name = line.substring(1,line.indexOf('"',1));
				String intervalString = line.substring(line.lastIndexOf('"')+2, line.lastIndexOf(',')); 
				int[] intervals = Arrays.stream(intervalString.split(",")).mapToInt(Integer::parseInt).toArray();
				scaleMap.put(name, intervals);
//				for(String note:noteSequence) {
//					//System.out.println(Arrays.toString(generateScales(note, intervals)));
//					scaleMap.put(note+" "+name, new Scale(note,name,intervals.length,generateScales(note, intervals),intervals));
//				}
				
			}
			br.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static Map<String, int[]> getScaleMap() {
		return scaleMap;
	}
}
