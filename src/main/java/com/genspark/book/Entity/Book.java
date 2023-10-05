package com.genspark.book.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author=:author")
@NoArgsConstructor
@AllArgsConstructor
public class Book
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String title;
   private String author;
   private double price;
   private int pubYear;
}
