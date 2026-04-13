package LMS;

import java.util.ArrayList;

public class BookManager {

    private ArrayList<Book> booksInLibrary = new ArrayList<>();

    public void addBookinLibrary(Book b){
        booksInLibrary.add(b);
    }

    public void viewAllBooks(){
        for(Book b : booksInLibrary){
            b.printInfo();
        }
    }

    public void createBook(String title,String subject,String author){
        Book b = new Book(-1,title,subject,author,false);
        addBookinLibrary(b);
    }
}