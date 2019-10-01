package coderkan.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import coderkan.mongodb.models.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

	Book findByObjId(int objId);
	
}
