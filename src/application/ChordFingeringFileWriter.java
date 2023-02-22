package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ChordFingeringFileWriter {
	static BufferedWriter out;
	static String outputFile = "chordFingering.txt";
	public ChordFingeringFileWriter() {
		
	}
	public static void writeChord(int index) {
		try {
			out = new BufferedWriter(new FileWriter(outputFile,false));
			out.write(Arrays.toString(ChordLibrary.list.get(index).getFingerPos()));
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
