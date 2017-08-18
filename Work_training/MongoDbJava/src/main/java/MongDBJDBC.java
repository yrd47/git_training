import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yrd on 2017/5/25.
 *
 */
public class MongDBJDBC {

    public static void main(String[] args){
        try{
            //连接到MonGoDB服务
            MongoClient mongoClient = new MongoClient("localhost",27017);
            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("yrd");
            System.out.println("Connect to database successfully");
            //创建集合
//            mongoDatabase.createCollection("test");
//            System.out.println("创建集合成功");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合test选择成功");
            //插入文档
            /**
             * 1. 创建文档 org.bson.Document 参数为key-value的格式
             * 2. 创建文档集合List<Document>
             * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
             * */
            List<Document> documents = getDocument();
            collection.insertMany(documents);
            System.out.println("文档插入成功");
            //检索所有文档
            printDocument(collection);
            //更新文档
            System.out.println("--------更新文档-------");
            collection.updateMany(Filters.eq("likes",100),new Document("$set",new Document("likes",200)));
            printDocument(collection);
            //删除文档
            System.out.println("--------删除文档-------");
            collection.deleteOne(Filters.eq("likes",100));
            printDocument(collection);
            collection.deleteMany(Filters.eq("likes",100));
            printDocument(collection);
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
    }

    public static List<Document> getDocument(){
        List<Document> documents = new ArrayList<Document>();
        Document document = new Document("title","MongoDb")
                .append("description","database")
                .append("likes","200")
                .append("by","Fly");
        documents.add(document);
        return documents;
    }

    public static void printDocument(MongoCollection<Document> collection){
        /**
         * 1. 获取迭代器FindIterable<Document>
         * 2. 获取游标MongoCursor<Document>
         * 3. 通过游标遍历检索出的文档集合
         * */
        FindIterable<Document> findIterable = collection.find(Filters.eq("likes","100"));
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }
    }
}
