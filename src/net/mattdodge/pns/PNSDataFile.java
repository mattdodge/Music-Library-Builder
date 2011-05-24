package net.mattdodge.pns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import net.mattdodge.pns.songs.SongLibrary;


public class PNSDataFile {

	private File dataFile;
	
	private SongLibrary library;
	private PNSConfig config;
	
	public PNSDataFile(String dataFileLoc) {
		this.dataFile = new File(dataFileLoc);
		
		this.loadData();
	}
	
	private void loadData() {
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(dataFile);
			br = new BufferedReader(fr);
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
