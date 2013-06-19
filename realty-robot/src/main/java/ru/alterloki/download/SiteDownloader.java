package ru.alterloki.download;

/**
 * Created with IntelliJ IDEA.
 * User: ashevenkov
 * Date: 19.06.13
 * Time: 23:42
 */
public class SiteDownloader {

    private SiteKnowledge siteKnowledge;

    public void downloadSite() {
        DownloadPage startingPage = siteKnowledge.getStartingPage();
        String url = startingPage.getUrl();


    }
}
