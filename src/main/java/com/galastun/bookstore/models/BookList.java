package com.galastun.bookstore.models;

import java.util.*;

public class BookList {
  private ArrayList<Book> books;

  public BookList() {
    books = new ArrayList<>();
  }

  public void add(Book book) {
    books.add(book);
  }

  public HashMap<String, Object> toJson() {
    HashMap<String, Object> data = new HashMap<>();
    HashMap<String, ArrayList<Book>> items = new HashMap<>();
    items.put("books", books);
    data.put("data", items);

    return data;
  }
}