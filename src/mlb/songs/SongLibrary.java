package mlb.songs;

import java.util.ArrayList;


public class SongLibrary {

	ArrayList<Song> librarySongs;
	
	public SongLibrary() {
		
	}
	
	public void addSong(Song song) {
		if (! this.songExists(song)) {
			librarySongs.add(song);
		}
	}
	
	public void removeSong(Song song) {
		librarySongs.remove(song);
	}
	
	public boolean songExists(Song song) {
		return librarySongs.contains(song);
	}
	
}
