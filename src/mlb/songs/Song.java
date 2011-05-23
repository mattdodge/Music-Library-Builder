package mlb.songs;

public class Song implements Comparable<Song> {

	private String songTitle;
	private String songArtist;
	private String songAlbum;
	
	public String getSongTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	public String getSongArtist() {
		return songArtist;
	}
	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}
	public String getSongAlbum() {
		return songAlbum;
	}
	public void setSongAlbum(String songAlbum) {
		this.songAlbum = songAlbum;
	}
	
	@Override
	public int compareTo(Song o) {
		return Math.abs(o.getSongArtist().compareTo(this.getSongArtist()))
			+  Math.abs(o.getSongTitle().compareTo(this.getSongTitle()));
	}
	
	public boolean equals(Song s) {
		return this.compareTo(s) == 0;
	}

	
}
