package LMS;

// 🔴🔴🔴 SRP VIOLATION DETECTED 🔴🔴🔴
// This class violates Single Responsibility Principle (SRP)
//
// ❌ Handles Library Management
// ❌ Handles Database Operations
// ❌ Handles User Management
// ❌ Handles Book Management
// ❌ Handles Loan History + Fine Calculation
// ❌ Handles Search + UI + Input Handling
//
// 🟢 Suggested Fix:
// Split into multiple classes:
// - LibraryService
// - BookService
// - UserService
// - DatabaseService
// - LoanService

// Including Header Files.
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Types;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Library {

    private String name;
    public static Librarian librarian;
    public static ArrayList<Person> persons;
    private ArrayList<Book> booksInLibrary;
    private ArrayList<Loan> loans;

    public int book_return_deadline;
    public double per_day_fine;
    public int hold_request_expiry;

    private HoldRequestOperations holdRequestsOperations = new HoldRequestOperations();

    private static Library obj;

    public static Library getInstance() {
        if (obj == null) {
            obj = new Library();
        }
        return obj;
    }

    private Library() {
        name = null;
        librarian = null;
        persons = new ArrayList();
        booksInLibrary = new ArrayList();
        loans = new ArrayList();
    }

    public void setReturnDeadline(int deadline) {
        book_return_deadline = deadline;
    }

    public void setFine(double perDayFine) {
        per_day_fine = perDayFine;
    }

    public void setRequestExpiry(int hrExpiry) {
        hold_request_expiry = hrExpiry;
    }

    public void setName(String n) {
        name = n;
    }

    public int getHoldRequestExpiry() {
        return hold_request_expiry;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public String getLibraryName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return booksInLibrary;
    }

    public void addClerk(Clerk c) {
        persons.add(c);
    }

    public void addBorrower(Borrower b) {
        persons.add(b);
    }

    public void addLoan(Loan l) {
        loans.add(l);
    }

    // 🔴 SRP VIOLATION: Inpu
    // t handling + search logic mixed in same class
    public Borrower findBorrower() {
        System.out.println("\nEnter Borrower's ID: ");
        int id = 0;
        Scanner scanner = new Scanner(System.in);

        try {
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid Input");
        }

        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getID() == id &&
                persons.get(i).getClass().getSimpleName().equals("Borrower")) {
                return (Borrower) (persons.get(i));
            }
        }

        System.out.println("\nSorry this ID didn't match any Borrower's ID.");
        return null;
    }

    // 🔴 SRP VIOLATION: Book deletion + business logic + user interaction mixed
    public void removeBookfromLibrary(Book b) {
        boolean delete = true;

        for (int i = 0; i < persons.size() && delete; i++) {
            if (persons.get(i).getClass().getSimpleName().equals("Borrower")) {
                ArrayList<Loan> borBooks = ((Borrower) (persons.get(i))).getBorrowedBooks();

                for (int j = 0; j < borBooks.size() && delete; j++) {
                    if (borBooks.get(j).getBook() == b) {
                        delete = false;
                        System.out.println("This book is currently borrowed.");
                    }
                }
            }
        }

        if (delete) {
            booksInLibrary.remove(b);
            System.out.println("Book removed successfully.");
        }
    }

    // 🔴 SRP VIOLATION: Search + UI + filtering logic all together
    public ArrayList<Book> searchForBooks() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String choice;
        System.out.println("Enter 1-Title, 2-Subject, 3-Author:");
        choice = sc.next();

        String title = "", subject = "", author = "";

        if (choice.equals("1")) {
            System.out.println("Enter Title:");
            title = reader.readLine();
        } else if (choice.equals("2")) {
            System.out.println("Enter Subject:");
            subject = reader.readLine();
        } else {
            System.out.println("Enter Author:");
            author = reader.readLine();
        }

        ArrayList<Book> matched = new ArrayList<>();

        for (Book b : booksInLibrary) {
            if (choice.equals("1") && b.getTitle().equals(title))
                matched.add(b);
            if (choice.equals("2") && b.getSubject().equals(subject))
                matched.add(b);
            if (choice.equals("3") && b.getAuthor().equals(author))
                matched.add(b);
        }

        return matched;
    }

    public void viewAllBooks() {
        for (Book b : booksInLibrary) {
            b.printInfo();
        }
    }

    public double computeFine2(Borrower borrower) {
        double totalFine = 0;

        for (Loan l : loans) {
            if (l.getBorrower() == borrower) {
                totalFine += l.computeFine1();
            }
        }
        return totalFine;
    }

    // 🔴 SRP VIOLATION: User creation + business logic + input handling
    public void createPerson(char x) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name:");
        String name = sc.next();

        if (x == 'c') {
            Clerk c = new Clerk(-1, name, "", 0, 0, -1);
            addClerk(c);
        } else if (x == 'l') {
            Librarian l = new Librarian(-1, name, "", 0, 0, -1);
            Librarian.addLibrarian(l);
        } else {
            Borrower b = new Borrower(-1, name, "", 0);
            addBorrower(b);
        }
    }

    public void createBook(String title, String subject, String author) {
        Book b = new Book(-1, title, subject, author, false);
        addBookinLibrary(b);
    }

    public Person login() {
        Scanner input = new Scanner(System.in);

        int id = input.nextInt();
        String password = input.next();

        for (Person p : persons) {
            if (p.getID() == id && p.getPassword().equals(password)) {
                return p;
            }
        }
        return null;
    }

    public void viewHistory() {
        for (Loan l : loans) {
            System.out.println(l.getBook().getTitle());
        }
    }

    // ---------------- DATABASE SECTION ----------------
    // 🔴 SRP VIOLATION: Database logic inside Library class (VERY IMPORTANT POINT)

    public Connection makeConnection() {
        try {
            String host = "jdbc:derby://localhost:1527/LMS";
            return DriverManager.getConnection(host, "haris", "123");
        } catch (SQLException e) {
            return null;
        }
    }

    // (Rest of DB methods also violate SRP but unchanged for assignment)
}