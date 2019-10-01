package coderkan.mongodb.models;

import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Book")
public class Book {
	
	@Id
	private ObjectId _id;
	private int objId;
	private String bookName;
	private String authorName;
	
	private Map<String, Object> template;
	
}
