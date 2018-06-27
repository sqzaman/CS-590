package swa.lab3.problem2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import swa.lab3.problem2.domain.Book;

public interface BookRepository extends MongoRepository<Book, String>  {

}
