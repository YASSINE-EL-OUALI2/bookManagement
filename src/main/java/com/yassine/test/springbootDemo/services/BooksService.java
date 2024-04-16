package com.yassine.test.springbootDemo.services;

import com.yassine.test.springbootDemo.entity.Authors;
import com.yassine.test.springbootDemo.entity.Books;
import com.yassine.test.springbootDemo.entity.Categories;
import com.yassine.test.springbootDemo.entity.Inventory;
import com.yassine.test.springbootDemo.errorHandling.AuthorsException;
import com.yassine.test.springbootDemo.errorHandling.BooksException;
import com.yassine.test.springbootDemo.errorHandling.CategoriesException;
import com.yassine.test.springbootDemo.errorHandling.InventoriesException;
import com.yassine.test.springbootDemo.repository.AuthorsRepository;
import com.yassine.test.springbootDemo.repository.BooksRepository;
import com.yassine.test.springbootDemo.repository.CategoriesRepository;
import com.yassine.test.springbootDemo.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BooksService {
    @Autowired
    BooksRepository booksRepository;
    // Inject inventory repo
    @Autowired
    InventoryRepository inventoryRepo;
    // Inject Category Repo
    @Autowired
    CategoriesRepository categoryRepo;
    //inject Authors Repo
    @Autowired
    AuthorsRepository authorsRepo;

    public void testEntityRelations(Books book) {
        Long inventoryId = Optional.ofNullable(book.getInventory()).map(Inventory::getInventoryId).orElse(null);
        if (inventoryId != null) {
            Inventory inventoryFound = inventoryRepo.findById(inventoryId)
                    .orElseThrow(() -> new InventoriesException("Inventory not present for book with title: " + book.getTitle()));
            book.setInventory(inventoryFound);
        }
        Long categoryId = Optional.ofNullable(book.getCategory()).map(Categories::getCategoryId).orElse(null);
        if (categoryId != null) {
            Categories categoryFound = this.categoryRepo.findById(categoryId)
                    .orElseThrow(() -> new CategoriesException("Category not present for book with title: " + book.getTitle()));
            book.setCategory(categoryFound);

        }
        Long authorId = Optional.ofNullable(book.getAuthor()).map(Authors::getAuthorId).orElse(null);
        if (authorId != null) {
            Authors authorFound = this.authorsRepo.findById(book.getAuthor().getAuthorId())
                    .orElseThrow(() -> new AuthorsException("Author not present for book with title: " + book.getTitle()));
            book.setAuthor(authorFound);
        }

    }

    public void addBook(Books book) {
        testEntityRelations(book);
        booksRepository.save(book);
    }

    public List<Books> getBooks() {
        return booksRepository.findAll();
    }

    public Books getBookById(Long id) {
        Books bookFounded = booksRepository.findById(id)
        .orElseThrow(() -> new BooksException(" Book Not Found !"));
        if (bookFounded != null) {
            if (bookFounded.getAuthor() != null) {
                Hibernate.initialize(bookFounded.getAuthor());
            }
            if (bookFounded.getCategory() != null) {
                Hibernate.initialize(bookFounded.getCategory());
            }
            if (bookFounded.getInventory() != null) {
                Hibernate.initialize(bookFounded.getInventory());
            }
        }
        return bookFounded;
    }

    public Books updateBook(Books book) {
        Books existingBook = booksRepository.findById(book.getBookId())
        .orElseThrow(() -> new BooksException(" Book Not Found !"));
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setPublisherName(book.getPublisherName());
            existingBook.setPublicationDate(book.getPublicationDate());
            existingBook.setQuantityAvailable(book.getQuantityAvailable());
            existingBook.setPrice(book.getPrice());

            // Update relationships
            testEntityRelations(book);
            existingBook.setAuthor(book.getAuthor());
            existingBook.setCategory(book.getCategory());
            existingBook.setInventory(book.getInventory());
            return booksRepository.save(existingBook);
        }
        return null;
    }

    public void deleteBook(Books book) {
        booksRepository.delete(book);
    }

}
