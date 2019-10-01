package coderkan.mongodb.controller;

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import coderkan.mongodb.models.Book;
import coderkan.mongodb.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private MongoTemplate mongoDBTemplate;
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addbook")
	public String addBook(@RequestBody Book book) {
		this.bookRepository.save(book);
		return "Added book with id : " + book.getObjId();
	}
	
	
	@GetMapping("/findAllBooks")
	public List<Book> getAllBooks(){
		List<Book> books = this.bookRepository.findAll();
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			if(book.getTemplate() != null) {
				System.out.println("Book : " + book.getTemplate().get("someFiled"));				
			}
		}
		return books;
	}
	
	@GetMapping("/findAllBooks/{id}")
	public Book getBook(@PathVariable int id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("objId").is(id));
		return mongoDBTemplate.findOne(query, Book.class);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		this.bookRepository.deleteById(id);
		return "book deleted with id : " + id;
	}
	
	
}
