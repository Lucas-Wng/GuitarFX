package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ChordLibrary {
	static ArrayList<Chord> list = new ArrayList<Chord>();
	static ArrayList<String> possibleChords = new ArrayList<String>();
	public ChordLibrary() {
		loadData();
	}
	public static ArrayList<String> findChord(String[] userChord) {
		String[] cleanedArray = Arrays.stream(userChord).filter(Objects::nonNull).distinct().toArray(String[]::new);
		possibleChords.clear();
		for(int i=0;i<list.size();i++) {
			
			Note[] arrNoteObj = list.get(i).getNotes();
			String[] stringNote = new String[arrNoteObj.length];
			for(int j=0;j<arrNoteObj.length;j++) {
				stringNote[j] = arrNoteObj[j].getName();
			}
			insertionSort(cleanedArray);
			insertionSort(stringNote);
			if(Arrays.equals(stringNote, cleanedArray)) {
				possibleChords.add(list.get(i).getName());
			}
		}
		return possibleChords;
		
	}
	public static void insertionSort(String[] arr) {
		for(int i=1;i<arr.length;++i) {
			String key = arr[i];
			int j = i - 1;
			while(j>=0&&key.compareTo(arr[j])<0) {
				arr[j+1] = arr[j];
				j = j - 1;
			}
			arr[j+1] = key;
		}
	}
	public static void loadData() {
		String line = "";
		String[] noteSequence = {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
		try {
			BufferedReader br = new BufferedReader(new FileReader("resources/data/chord-fingers.csv"));
			while((line = br.readLine())!=null) {
				
				String note = line.substring(0,line.indexOf(';'));
				line = line.substring(line.indexOf(';')+1);
				String type = line.substring(0,line.indexOf(';'));
				String chordStructureString = line.substring(line.indexOf('"')+1, line.lastIndexOf('"')); 
				String[] chordStructure = chordStructureString.split(";");
				String fingerPosString = line.substring(line.lastIndexOf('"')+2,line.lastIndexOf(';'));
			
				int[] fingerPosArr = new int[6];
				int count = 0;
				for(int i=0;i<fingerPosString.length();i++) {
					if(fingerPosString.charAt(i)=='x') {
						fingerPosArr[count] = -1;
						count++;
					}
					else if(fingerPosString.charAt(i)!=',') {
						fingerPosArr[count] = (int)Character.getNumericValue(fingerPosString.charAt(i));
						count++;
					}
				}
				
				line = line.substring(line.lastIndexOf(';')+1);
				String[] notes = line.split(",");
				Note[] notesObj = new Note[notes.length];
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
					
					for(int j=0;j<notes.length;j++) {
						notesObj[i] = new Note(notes[i],0,0);
					}
				}
				Chord newChord = new Chord(note,type,notes.length,notesObj,chordStructure,fingerPosArr);

				list.add(newChord);
				
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
}
