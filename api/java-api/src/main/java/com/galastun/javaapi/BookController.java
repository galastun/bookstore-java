package com.galastun.javaapi;

import com.galastun.javaapi.models.*;
import com.galastun.javaapi.utilities.DbHelper;

import java.util.HashMap;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * Controller for all book related actions.
 */
@RestController
public class BookController {
  /**
   * Gets a list of all books
   * 
   * @return HashMap<String, Object>
   */
  @ResponseBody
  @GetMapping("/api/v1/books")
  public HashMap<String, Object> get() {
    BookList books = new BookList();

    try {
      DbHelper db = new DbHelper();
      db.connect("localhost:3306/library", "library", "library");
      String query = "SELECT b.*, c.category as category, " 
      + "CONCAT(a.first_name, ' ', a.last_name) as author, "
      + "p.name as publisher FROM books as b "
      + "INNER JOIN categories as c on b.category_id = c.category_id "
      + "INNER JOIN authors as a on b.author_id = a.author_id "
      + "INNER JOIN publishers as p on b.publisher_id = p.publisher_id";

      ArrayList<HashMap<String, Object>> result = db.query(query);

      result.forEach((data) -> {
        Book book = new Book();
        book.id = (int)data.get("book_id");
        book.title = (String)data.get("title");
        book.isbn = (String)data.get("isbn");
        book.pages = (int)data.get("pages");
        book.category = (String)data.get("category");
        book.author = (String)data.get("author");
        book.publisher = (String)data.get("publisher");

        books.add(book);
      });
    } catch (Exception e) {
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR, "There was a problem getting data from the database.", e);
    } 

    return books.toJson();
  }
}
