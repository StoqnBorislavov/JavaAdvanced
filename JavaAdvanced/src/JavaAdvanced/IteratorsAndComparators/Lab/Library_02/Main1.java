package JavaAdvanced.IteratorsAndComparators.Lab.Library_02;

import JavaAdvanced.IteratorsAndComparators.Lab.Book_01.Book;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        Library library = new Library();
        library.add(bookOne);
        library.add(bookTwo);
        library.add(bookThree);

        for (Book book : library) {
            System.out.println(book.getTitle());
        }

    }
}
