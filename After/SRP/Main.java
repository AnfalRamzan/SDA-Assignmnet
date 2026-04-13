import org.springframework.stereotype.Component;
package LMS;

public class Main {

    public static void main(String[] args) {

        // Create dependencies
        BookManager bookManager = new BookManager();
        PersonManager personManager = new PersonManager();
        SearchService searchService = new SearchService();
        FineService fineService = new FineService();
        LoginService loginService = new LoginService();
        HistoryService historyService = new HistoryService();
        DatabaseService databaseService = new DatabaseService();

        // Inject into Library (Dependency Injection)
        Library library = new Library(
                bookManager,
                personManager,
                searchService,
                fineService,
                loginService,
                historyService,
                databaseService
        );

        // Optional testing
        library.setName("My Digital Library");

        System.out.println("Library created successfully: " + library.getLibraryName());
    }
}
