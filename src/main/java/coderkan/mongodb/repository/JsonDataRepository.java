package coderkan.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import coderkan.mongodb.models.JsonData;

public interface JsonDataRepository extends MongoRepository<JsonData, Integer> {

	JsonData findByObjId(int objId);
	
}