package coderkan.mongodb.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import coderkan.mongodb.models.JsonData;
import coderkan.mongodb.repository.JsonDataRepository;

@RestController()
public class JsonController {

	@Autowired
	private JsonDataRepository jsonRepository;
	
	@GetMapping("/all")
	public List<JsonData> getAllJsonData(){
		return this.jsonRepository.findAll();
	}
	
	@PostMapping("/add")
	public JsonData addJsonData(@RequestBody JsonData jsonData) {
		return this.jsonRepository.save(jsonData);
	}
	
	@PostMapping("/addTest")
	public String addJsonDataTest() {
		JsonData json = new JsonData();
		json.setData("string here");
	    this.jsonRepository.save(json);
	    JsonData objJson = new JsonData();
	    objJson.setData(new JSONObject().put("key", "value").put("obj", new JSONObject()));
	    this.jsonRepository.save(objJson);
	    JsonData arrJson = new JsonData();
	    arrJson.setData(new JSONArray().put("a").put("b").put("c"));
	    this.jsonRepository.save(arrJson);
	    return "Saved Successfully";
	}
	
	
}
