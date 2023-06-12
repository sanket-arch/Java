import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Book {
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}

class YearComprator implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        if (b1.getPublicationYear() == b2.getPublicationYear()) {
            return 0;
        } else if (b1.getPublicationYear() > b2.getPublicationYear()) {
            return 1;
        } else
            return -1;
    }
}

public class BookArrayList {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("Fundamentals of DOS", "kartik tyagi", 1960));
        bookList.add(new Book("Java", "joseph murino", 1949));
        bookList.add(new Book("Data Mining", "john smith", 1925));

        System.out.println("Books in the list:");
        for (Book book : bookList) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Publication Year: "
                    + book.getPublicationYear());
        }

        Collections.sort(bookList, new YearComprator());

        System.out.println("\nBooks sorted by publication year:");
        for (Book book : bookList) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Publication Year: "
                    + book.getPublicationYear());
        }
    }
}
