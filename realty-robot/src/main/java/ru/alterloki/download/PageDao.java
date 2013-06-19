package ru.alterloki.download;

/**
 * Created with IntelliJ IDEA.
 * User: ashevenkov
 * Date: 19.06.13
 * Time: 17:30
 */
public interface PageDao {

    void putPage(String site, String url, String content);
    Page getPage(String site, String url);

}
