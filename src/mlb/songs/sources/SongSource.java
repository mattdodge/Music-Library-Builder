package mlb.songs.sources;

import mlb.songs.Song;


public abstract class SongSource {

	public abstract Song getSong(String songTitle, String songArtist);
	
}
