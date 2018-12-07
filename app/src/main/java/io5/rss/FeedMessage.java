package io5.rss;

import com.sun.syndication.feed.synd.SyndContent;

public class FeedMessage {
    private String title;
    private SyndContent description;
    private String link;

    public FeedMessage(String title, SyndContent description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SyndContent getDescription() {
        return description;
    }

    public void setDescription(SyndContent description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
