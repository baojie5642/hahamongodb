package hahamongodb.MongoHa;
import java.util.List;  

import org.bson.Document;  
import org.junit.Before;  
import org.junit.Test;  
  
import com.mongodb.client.result.UpdateResult;  
public class MongoTest {
	  @Before  
	    public void before(){  
		  HaHaMongo.connect("test", "test", "192.168.1.111", 27017);  
	    }  
	      
	    @Test  
	    public void testInsert(){  
	        Document document = new Document();  
	        document.append("name", "wang").append("gender", "female");  
	        HaHaMongo.insert(document);  
	    }  
	      
	    @Test  
	    public void testFindAll(){  
	        List<Document> results = HaHaMongo.findAll();  
	        for(Document doc : results){  
	            System.out.println(doc.toJson());  
	        }  
	    }  
	      
	    @Test  
	    public void testFindBy(){  
	        Document filter = new Document();  
	        filter.append("name", "li si");  
	        List<Document> results = HaHaMongo.findBy(filter);  
	        for(Document doc : results){  
	            System.out.println(doc.toJson());  
	        }  
	    }  
	      
	    @Test  
	    public void testUpdateOne(){  
	        Document filter = new Document();  
	        filter.append("gender", "male");  
	          
	        //注意update文档里要包含"$set"字段  
	        Document update = new Document();  
	        update.append("$set", new Document("gender", "female"));  
	        UpdateResult result = HaHaMongo.updateOne(filter, update);  
	        System.out.println("matched count = " + result.getMatchedCount());  
	    }  
	      
	    @Test  
	    public void testUpdateMany(){  
	        Document filter = new Document();  
	        filter.append("gender", "female");  
	          
	        //注意update文档里要包含"$set"字段  
	        Document update = new Document();  
	        update.append("$set", new Document("gender", "male"));  
	        UpdateResult result = HaHaMongo.updateMany(filter, update);  
	        System.out.println("matched count = " + result.getMatchedCount());  
	    }  
	      
	    @Test  
	    public void testReplace(){  
	        Document filter = new Document();  
	        filter.append("name", "zhang");  
	          
	        //注意：更新文档时，不需要使用"$set"  
	        Document replacement = new Document();  
	        replacement.append("value", 123);  
	        HaHaMongo.replace(filter, replacement);  
	    }  
	      
	    @Test  
	    public void testDeleteOne(){  
	        Document filter = new Document();  
	        filter.append("name", "li");  
	        HaHaMongo.deleteOne(filter);  
	    }  
	      
	    @Test  
	    public void testDeleteMany(){  
	        Document filter = new Document();  
	        filter.append("gender", "male");  
	        HaHaMongo.deleteMany(filter);  
	    }  
}
