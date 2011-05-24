package net.mattdodge.pns.songs.feeds;

import java.util.ArrayList;

import net.mattdodge.pns.songs.Song;



public abstract class SongFeed {

	public abstract ArrayList<Song> getNewSongs();
	
}
