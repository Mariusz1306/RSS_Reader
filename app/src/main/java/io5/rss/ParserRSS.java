package io5.rss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;


public class ParserRSS implements Runnable {


    private List<FeedMessage> entries = new ArrayList<>();

    private RSSFetcher rssFetcher;

    public ParserRSS(RSSFetcher rssFetcher) {

        this.rssFetcher = rssFetcher;
    }

    @Override
    public void run() {


        SyndFeed feed = rssFetcher.getFeed();

        for (Iterator iterator = feed.getEntries().iterator(); iterator.hasNext(); ) {
            SyndEntry syndEntry = (SyndEntry) iterator.next();
            entries.add(new FeedMessage(syndEntry.getTitle(), syndEntry.getDescription(), syndEntry.getLink()));
        }
    }

    public List<FeedMessage> getEntries() {
        return entries;
    }
}




