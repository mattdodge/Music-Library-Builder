package api.xml.youtube;

import com.google.gdata.client.*;
import com.google.gdata.client.youtube.*;
import com.google.gdata.data.*;
import com.google.gdata.data.geo.impl.*;
import com.google.gdata.data.media.*;
import com.google.gdata.data.media.mediarss.*;
import com.google.gdata.data.youtube.*;
import com.google.gdata.data.extensions.*;
import com.google.gdata.util.*;

import java.io.IOException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class YouTubeAPIConnector {

	private static final String VIDEOS_FEED = "http://gdata.youtube.com/feeds/api/videos";

	private final String CLIENT_ID = "Music-Library-Builder";
	private final String DEVELOPER_KEY = "AI39si4kEbyzpWbfWZC3MpHZxQlznLM4jJmnVPtotV1-bj2Iv3H8yfnoGfKH9caB69r9d0RltY3wfbcbc8o8gIpu6OPxe3sX1A";

	private YouTubeService service;

	public YouTubeAPIConnector() {
		initService();
	}

	private void initService() {
		service = new YouTubeService(CLIENT_ID, DEVELOPER_KEY);
	}
	
	public ArrayList<String> searchYouTubeVideos(String query, int maxResults) {
		ArrayList<String> it = new ArrayList<String>(maxResults);
		
		VideoFeed ytFeed = searchVideos(query);
		
		for (VideoEntry vid : ytFeed.getEntries()) {
			if (it.size() >= maxResults) break;
			
			String vidLink = vid.getHtmlLink().getHref();
			
			it.add(vidLink);
		}
		return it;
	}

	private VideoFeed searchVideos(String searchTerm) {
		YouTubeQuery query;
		try {
			query = new YouTubeQuery(new URL(VIDEOS_FEED));

			// order results by the number of views (most viewed first)
			query.setOrderBy(YouTubeQuery.OrderBy.RELEVANCE);

			// do not exclude restricted content from the search results
			// (by default, it is excluded)
			query.setSafeSearch(YouTubeQuery.SafeSearch.NONE);

			query.setFullTextQuery(searchTerm);

			VideoFeed videoFeed = service.query(query, VideoFeed.class);

			return videoFeed;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		YouTubeAPIConnector me = new YouTubeAPIConnector();
		
		System.out.println(me.searchYouTubeVideos("yellow cat", 3));
	}
}
