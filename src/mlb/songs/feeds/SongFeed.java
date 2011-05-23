package mlb.songs.feeds;

import java.util.ArrayList;

import mlb.songs.Song;


public abstract class SongFeed {

	public abstract ArrayList<Song> getNewSongs();
	
}
