package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FretPosJSONReader {
	private static JSONObject chordsJo;
	private static JSONArray chordType;
	public FretPosJSONReader() {
		Object obj = null;
		try {
			obj = new JSONParser().parse(new FileReader("data/guitar.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jo = (JSONObject) obj;
		chordType = (JSONArray) jo.get("suffixes");
		chordsJo = (JSONObject) jo.get("chords");
	}
	public static List<String> getChordTypeList(){
		List<String> chordList = new ArrayList<String>();
		for(int i=0;i<chordType.size();i++) {
			chordList.add((String) chordType.get(i));
		}
		return chordList;
	}
	public static ArrayList<int[]> findChordFingering(String note, String suffix){
		ArrayList<int[]> chordList = new ArrayList<int[]>();
		JSONArray NoteJa = (JSONArray) chordsJo.get(note);
		for(Object chordType:NoteJa) {
			JSONObject chordTypeJo = (JSONObject) chordType;
		
			if(chordTypeJo.get("suffix").equals(suffix)) {
				JSONArray fingerPos = (JSONArray) chordTypeJo.get("positions");
				for(Object position:fingerPos) {
					JSONObject nPosition = (JSONObject) position;
					JSONArray frets = (JSONArray) nPosition.get("frets");
					int[] fretInt = new int[6];
					for (int i = 0; i < frets.size(); ++i) {
					    fretInt[i] = ((Long) frets.get(i)).intValue();
					}
					int baseFret = ((Long) nPosition.get("baseFret")).intValue();
					for(int i=0;i<6;i++) {
						if(fretInt[i]!=-1) {
							fretInt[i]+=baseFret-1;
						}
					}
					chordList.add(fretInt);
				}
			}
		}
		return chordList;
		
		
	}
}