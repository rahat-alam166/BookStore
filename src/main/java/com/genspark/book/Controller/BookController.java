package com.genspark.book.Controller;

import com.genspark.book.Entity.Book;
import com.genspark.book.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController
{
   @Autowired
   private BookService bookService;

   @GetMapping("/")
   public List<Book> getBooks()
   {
      return this.bookService.getAllBooks();
   }

   @GetMapping("/{id}")
   public Book getBook(@PathVariable String id)
   {
      return this.bookService.getByID(Integer.parseInt(id));
   }

   @GetMapping("/byAuthor")
   public List<Book> getBookByAuthor(@RequestParam String author)
   {
      return this.bookService.findByAuthor(author);
   }

   @GetMapping("/byPublicationYearRange")
   public List<Book> getBookByPublicationYearRange(@RequestParam String startYear, String endYear)
   {
      return this.bookService.findByPublicationYearRange(Integer.parseInt(startYear), Integer.parseInt(endYear));
   }

   @PostMapping("/")
   public Book addBook(@RequestBody Book book)
   {
      return this.bookService.addBook(book);
   }

   @PutMapping("/")
   public Book updateBook(@RequestBody Book book)
   {
      return this.bookService.updateBook(book);
   }

   @DeleteMapping("/{id}")
   public String deleteBook(@PathVariable String id)
   {
      return this.bookService.deleteBookById(Integer.parseInt(id));
   }
}
