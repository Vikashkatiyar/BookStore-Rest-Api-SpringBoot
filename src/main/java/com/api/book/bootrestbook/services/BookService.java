package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    // private static List<Book> list=new ArrayList<>();

    // static{
    //     list.add(new Book(12,"Java Complete Ref","XYZ"));
    //     list.add(new Book(36,"HEAD FIRST jAVA","ABC"));
    //     list.add(new Book(47,"Things in java","LMN"));
    // }
    
    @Autowired
    private BookRepository bookRepository;

    //Get All BOoks
    public List<Book> getAllBooks(){
        List<Book> list=(List<Book>) this.bookRepository.findAll();
        return list;
    }


    //Get Single books by id
    public Book getBookById(int id){
        Book book=null;
        
        try {
            //book=list.stream().filter(e->e.getId()==id).findFirst().get();
           book= this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }


    //Adding the book
    public Book addBook(Book b){
        Book resulBook=bookRepository.save(b);
        return resulBook;
    }

    //delete book
    public void deleteBook(int bookId){
      bookRepository.deleteById(bookId);
    }

   //update the book
    public void updateBook(Book book, int bookId) {
    //    list= list.stream().map(b->{
    //         if(b.getId()==bookId){
    //             b.setTitle(book.getTitle());
    //             b.setAuthor(book.getAuthor());
    //         }
    //         return b;
    //     }).collect(Collectors.toList());
       book.setId(bookId);
      bookRepository.save(book);
    }
}
