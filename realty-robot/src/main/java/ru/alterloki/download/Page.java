package ru.alterloki.download;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ashevenkov
 * Date: 19.06.13
 * Time: 19:29
 */
public class Page {

    private String url;
    private String content;
    private String site;
    private Date lastUpdated;

    public Page() {
    }

    public Page(String url, String content, String site) {
        this.url = url;
        this.content = content;
        this.site = site;
    }

    public Page(String url, String content, String site, Date lastUpdated) {
        this.url = url;
        this.content = content;
        this.site = site;
        this.lastUpdated = lastUpdated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
