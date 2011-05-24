package net.mattdodge.pns.songs.sources;

import net.mattdodge.pns.songs.Song;


public abstract class SongSource {

	public abstract Song getSong(String songTitle, String songArtist);
	
}
