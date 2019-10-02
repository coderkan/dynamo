package coderkan.mongodb.models;

import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

import lombok.Data;

@Data
@Document(collection = "jsondata")
public class JsonData {
	
	@Id
	private ObjectId _id;
	
	private int objId;
	private Object data;
	
	// data field can be a string
	public void setData(String str) {
		this.data = str;
	}
	
	// data field cab ve a {}
	public void setData(JSONObject jsonObject) {
		data = new BasicDBObject(jsonObject.toMap());
	}
	
	// data can be a []
	public void setData(JSONArray jsonArray) {
		BasicDBList list = new BasicDBList();
		list.addAll(jsonArray.toList());
		data = list;
	}
	
	
}
