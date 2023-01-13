package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class ChordLibrary {
	static ArrayList<Chord> list = new ArrayList<Chord>();
	public ChordLibrary() {
		loadData();
		System.out.println(list.get(0).getName());
	}
	public String findChord(String[] userChord) {
		boolean found = false;
		String chordName = "";
		String[] cleanedArray = Arrays.stream(userChord).filter(Objects::nonNull).distinct().toArray(String[]::new);
		System.out.println(Arrays.toString(cleanedArray));
		for(int i=0;i<list.size();i++) {
			String[] arr = list.get(i).getNotes();
			Arrays.sort(arr);
			Arrays.sort(cleanedArray);
			if(Arrays.equals(arr, cleanedArray)) {
				found = true;
				chordName += list.get(i).getName() + " ";
			}
		}
		if(!found) {
			return "Not found";
		}
		return chordName;
	}
	public static void loadData() {
		String line = "";
		String[] noteSequence = {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/chord.csv"));
			while((line = br.readLine())!=null) {
				
				String note = line.substring(0,line.indexOf(';'));
				line = line.substring(line.indexOf(';')+1);
				String type = line.substring(0,line.indexOf(';'));
				String chordStructureString = line.substring(line.indexOf('"')+1, line.lastIndexOf('"')); 
				String[] chordStructure = chordStructureString.split(";");
				line = line.substring(line.lastIndexOf('"')+2);
				String[] notes = line.split(",");
				for(int i=0;i<notes.length;i++) {
					String chordNote = notes[i];
					if(chordNote.length()>1) {
						int noteChange = 0;
						int pos = 0;
						for(int j=0;j<chordNote.length()-1;j++) {
							if(chordNote.charAt(1+j)=='#') {
								noteChange++;
							}
							if(chordNote.charAt(1+j)=='b') {
								noteChange--;
							}
						}
						for(int j=0;j<noteSequence.length;j++) {
							if(noteSequence[j].equals(chordNote.substring(0,1))) {
								pos = j;
							}
						}
						if(pos+noteChange<0) {
							chordNote = noteSequence[12+pos+noteChange];
						}
						else {
							chordNote = noteSequence[(pos+noteChange)%12];
						}
					}
					notes[i] = chordNote;
				}
				list.add(new Chord(note,type,notes.length,notes,chordStructure));
				//System.out.println(note+type+Arrays.toString(notes));
				
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
