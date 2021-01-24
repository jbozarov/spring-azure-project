package com.example.demo.dao;

import com.example.demo.Model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.*;
@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

}
