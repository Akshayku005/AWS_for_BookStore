package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.dto.UserDTO;
import com.bridgelabz.bookstoreapp.model.Book;
import com.bridgelabz.bookstoreapp.model.UserRegistration;
import com.bridgelabz.bookstoreapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;

    /**
     * @param
     * @return Ability to insert BookDetails in DB
     */
    @PostMapping("/insert")
    public ResponseEntity<String> addBookToRepository(@Valid @RequestBody BookDTO bookDTO) {
        String newBook = bookService.createBook(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("New Book Added in Book Store", newBook);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<String> getAllBooks() {
        List<Book> listOfBook = bookService.getAllBookInfo();
        ResponseDTO dto = new ResponseDTO("User retrieved successfully (:", listOfBook);
        return new ResponseEntity(dto, HttpStatus.OK);
    }
    /**
     *
     * @param
     * @return Ability to getBookById using Token
     */

    @GetMapping(value = "/getById/{token}")
    public ResponseEntity<String> getBookDataById(@PathVariable String token) {
        Book Book = bookService.getBookDataById(token);
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully by id (:", Book);
        return new ResponseEntity(dto, HttpStatus.OK);
    }
    /**
     *
     * @param
     * @return Ability to getAllbookData using Token
     */

    @GetMapping(value = "/getAllBy/{token}")
    public ResponseEntity<String> getAllBookData(@PathVariable String token) {
        List<Book> listOfBooks = bookService.getAllBookData(token);
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:", listOfBooks);
        return new ResponseEntity(dto, HttpStatus.OK);
    }
    /**
     *
     * @param
     * @return  Ability to delete book by using Token
     */

    @DeleteMapping("/delete/{token}")
    public ResponseEntity<String> deleteRecordById(@PathVariable String token) {
        ResponseDTO dto = new ResponseDTO("Book Record deleted successfully", bookService.deleteRecordById(token));
        return new ResponseEntity(dto, HttpStatus.OK);
    }
    /**
     *
     * @param
     * @return Ability to UpdateBookBy using Token
     */

    @PutMapping("/updateBookById/{token}")
    public ResponseEntity<String> updateRecordById(@PathVariable String token, @Valid @RequestBody BookDTO bookDTO) {
        Book updateRecord = bookService.updateRecordById(token, bookDTO);
        ResponseDTO dto = new ResponseDTO(" Book Record updated successfully by Id", updateRecord);
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }
    /**
     *
     * @param
     * @return Ability to UpdateBookById using token and quantity
     */

    @PutMapping("/update/{token}/{quantity}")
    public ResponseEntity<ResponseDTO> updateBooksByQuantity(@PathVariable String token, @PathVariable int quantity) {
        Book bookData = bookService.updataBooksByQuantity(token, quantity);
        ResponseDTO responseDTO = new ResponseDTO("updated book data succesfully", bookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    /**
     *
     * @param
     * @return Ability to searchBook by Name and get book details
     */

    @GetMapping("searchByBookName/{name}")
    public ResponseEntity<ResponseDTO> getBookByName(@PathVariable("name") String name) {
        List<Book> listOfBooks = bookService.getBookByName(name);
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:", listOfBooks);
        return new ResponseEntity(dto, HttpStatus.OK);
    }
    /**
     *
     * @param
     * @return Ability to sort the  book in Ascending Order
     */

    @GetMapping("/sortAsc")
    public ResponseEntity<ResponseDTO> getBooksInAscendingOrder() {
        List<Book> listOfBooks = bookService.sortedListOfBooksInAscendingOrder();
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:", listOfBooks);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    /**
     *
     * @return Ability to sort the  book in Ascending Order
     */

    @GetMapping("/sortDesc")
    public ResponseEntity<ResponseDTO> getBooksInDescendingOrder() {
        List<Book> listOfBooks = bookService.sortedListOfBooksInDescendingOrder();
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:", listOfBooks);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    /**
     *
     * @param authorName
     * @return Ability to SearchBy Author Name and get details of the Book
     */
    @GetMapping("searchByAuthorName/{authorName}")
    public ResponseEntity<ResponseDTO> getBookByAuthorName(@PathVariable("authorName") String authorName) {
        List<Book> listOfBooks = bookService.getBookByAuthorName(authorName);
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:", listOfBooks);
        return new ResponseEntity(dto, HttpStatus.OK);
    }
}