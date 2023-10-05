package com.genspark.book.Service;

import com.genspark.book.Entity.Book;
import com.genspark.book.Repos.BookRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
   @PersistenceContext
   EntityManager entityManager;
   @Autowired
   private final BookRepo bookRepo;
   public BookService(BookRepo bookRepo)
   {
      this.bookRepo = bookRepo;
   }


   public List<Book> getAllBooks()
   {
      return this.bookRepo.findAll();
   }

   public List<Book> findByAuthor(String author)
   {
      Query query = entityManager.createNamedQuery("Book.findByAuthor");
      query.setParameter("author", author);
      return query.getResultList();
   }

   public List<Book> findByPublicationYearRange(int startYear, int endYear)
   {
      TypedQuery<Book> query = entityManager.createQuery(
              "SELECT b FROM Book b WHERE b.pubYear BETWEEN :startYear AND :endYear",
              Book.class
      );
      query.setParameter("startYear", startYear);
      query.setParameter("endYear", endYear);

      return query.getResultList();
   }


   public Book getByID(int id)
   {
      Optional<Book> o = this.bookRepo.findById(id);
      Book book = null;
      if (o.isPresent())
      {
         book = o.get();
      }
      else
         throw new RuntimeException("Book not found");
      return book;
   }


   public Book addBook(Book book)
   {
      return this.bookRepo.save(book);
   }


   public Book updateBook(Book book)
   {
      return this.bookRepo.save(book);
   }


   public String deleteBookById(int id)
   {
      this.bookRepo.deleteById(id);
      return "Deleted";
   }
}
