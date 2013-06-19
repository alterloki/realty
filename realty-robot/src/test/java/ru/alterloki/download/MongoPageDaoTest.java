package ru.alterloki.download;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: ashevenkov
 * Date: 19.06.13
 * Time: 19:23
 */
public class MongoPageDaoTest {

    @Test
    public void testPutGet() {
        new MongoPageDao().putPage("http://www.yandex.ru", "http://www.yandex.ru", "This is yandex");
        Page page = new MongoPageDao().getPage("http://www.yandex.ru", "http://www.yandex.ru");
        assertEquals(page.getContent(), "This is yandex");
        assertTrue(new Date().getTime() - page.getLastUpdated().getTime() < 1000);
    }
}
