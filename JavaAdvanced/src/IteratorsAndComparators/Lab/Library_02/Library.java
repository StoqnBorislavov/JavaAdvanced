package IteratorsAndComparators.Lab.Library_02;

import IteratorsAndComparators.Lab.Book_01.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book>{
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void add(Book book){
        this.books.add(book);
    }

    public Book get(int index){
        return this.books.get(index);
    }

    public int booksCount(){
      return this.books.size();
    }

    private static class BookIterator implements Iterator<Book>{
        private int i = 0;
        private List<Book> books;
        public BookIterator(List<Book> books){
            this.books = books;
        }
        @Override
        public boolean hasNext(){
            return i < books.size();
        }
        @Override
        public Book next(){
            return books.get(i++);
        }

    }

    @Override
    public Iterator<Book> iterator(){
        return new BookIterator(books);
    }
}
