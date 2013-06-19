package ru.alterloki.download;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ashevenkov
 * Date: 19.06.13
 * Time: 19:23
 */
public class MongoPageDao implements PageDao {

    private MongoClient mongoClient;

    public MongoPageDao() {
        mongoClient = null;
        try {
            mongoClient = new MongoClient();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void putPage(String site, String url, String content) {
        DB pagesDb = mongoClient.getDB("pagesCache");
        DBCollection collection = pagesDb.getCollection(site);
        BasicDBObject query = new BasicDBObject("url", url);
        BasicDBObject pageDoc = new BasicDBObject("url", url).
                append("site", site).
                append("content", content).
                append("lastUpdate", new Date());
        collection.update(query, pageDoc, true, false);
    }

    public Page getPage(String site, String url) {
        DB pagesDb = mongoClient.getDB("pagesCache");
        DBCollection collection = pagesDb.getCollection(site);
        BasicDBObject query = new BasicDBObject("url", url);
        DBCursor queryResult = collection.find(query);
        if(queryResult.hasNext()) {
            DBObject pageResult = queryResult.next();
            String content = (String) pageResult.get("content");
            Date lastUpdate = (Date) pageResult.get("lastUpdate");
            return new Page(url, content, site, lastUpdate);
        }
        return null;
    }
}
