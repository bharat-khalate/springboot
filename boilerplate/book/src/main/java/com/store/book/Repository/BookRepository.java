package com.store.book.Repository;

import com.store.book.Entity.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books,Integer> {
}
