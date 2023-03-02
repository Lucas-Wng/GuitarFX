package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ChordFingeringFileWriter {
	static BufferedWriter out;
	static String outputFile = "chordFingering.txt";
	public static void writeChord(String name, int[] frets) {
		try {
			out = new BufferedWriter(new FileWriter(outputFile,true));
			out.write(name);
			for(int i=frets.length-1;i>=0;i--) {
				out.newLine();
				if(frets[i]==-1) {
					out.write("|--x--");
				}
				else {
					out.write("|--"+frets[i]+"--");
				}
				
			}
			out.newLine();
			out.newLine();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void clearFile() {
		try {
			out = new BufferedWriter(new FileWriter(outputFile,false));
			out.write("");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
