package io5.rss;

import android.util.Xml;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Marius on 2018-11-27.
 */

public class RSSFetcher implements Runnable {

    private final String stringUrl;
    private final URL feedUrl;
    private final InputStream inputStream;
    private SyndFeed feed;

    public RSSFetcher(String stringUrl, InputStream inputStream) throws MalformedURLException{
        this.stringUrl = stringUrl;
        this.feedUrl = new URL(stringUrl);
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            SyndFeedInput input = new SyndFeedInput();
            //File file = getAssets().open("filename.txt");
            XmlReader xml = new XmlReader(getInputStream());
            System.out.println();
            this.feed = input.build(xml);
        } catch (Exception e){
            System.out.println(e.getMessage());
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

    public InputStream getInputStream() {
        return inputStream;
    }

    public SyndFeed getFeed() {
        return feed;
    }
}
