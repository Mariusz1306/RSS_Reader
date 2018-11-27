package io5.rss;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Marius on 2018-11-27.
 */

public class RSSFetcher implements Runnable {

    private final String stringUrl;
    private final URL feedUrl;
    private SyndFeed feed;

    public RSSFetcher(String stringUrl) throws MalformedURLException{
        this.stringUrl = stringUrl;
        this.feedUrl = new URL(stringUrl);
    }

    @Override
    public void run() {
        try {
            SyndFeedInput input = new SyndFeedInput();
            this.feed = input.build(new XmlReader(feedUrl));
        } catch (Exception e){

        }
    }

    public boolean isDownloaded() {
        return (getFeed() != null);
    }

    public String getStringUrl() {
        return stringUrl;
    }

    public URL getFeedUrl() {
        return feedUrl;
    }

    public SyndFeed getFeed() {
        return feed;
    }
}
