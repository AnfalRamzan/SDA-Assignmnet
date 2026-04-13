package LMS;

public class Library {

    private String name;

    private BookManager bookManager;
    private PersonManager personManager;
    private SearchService searchService;
    private FineService fineService;
    private LoginService loginService;
    private HistoryService historyService;
    private DatabaseService databaseService;

    // Constructor Injection (BONUS - DIP)
    public Library(
            BookManager bookManager,
            PersonManager personManager,
            SearchService searchService,
            FineService fineService,
            LoginService loginService,
            HistoryService historyService,
            DatabaseService databaseService
    ) {
        this.bookManager = bookManager;
        this.personManager = personManager;
        this.searchService = searchService;
        this.fineService = fineService;
        this.loginService = loginService;
        this.historyService = historyService;
        this.databaseService = databaseService;
    }

    // Library name
    public void setName(String name) {
        this.name = name;
    }

    public String getLibraryName() {
        return name;
    }

    // Delegate methods

    public void addBook(Book b) {
        bookManager.addBookinLibrary(b);
    }

    public void viewBooks() {
        bookManager.viewAllBooks();
    }

    public void addBorrower(Borrower b) {
        personManager.addBorrower(b);
    }

    public void addClerk(Clerk c) {
        personManager.addClerk(c);
    }

    public Person login() {
        return loginService.login();
    }

    public void viewHistory() {
        historyService.viewHistory();
    }

    public double computeFine() {
        return fineService.computeFine();
    }
}