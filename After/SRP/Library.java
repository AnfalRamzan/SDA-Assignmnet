package LMS;

public class Library {

    private BookManager bookManager;
    private PersonManager personManager;
    private SearchService searchService;
    private FineService fineService;
    private LoginService loginService;
    private HistoryService historyService;
    private DatabaseService databaseService;

    // ❌ BEFORE: Library itself creates objects (BAD DESIGN)
    public Library() {
        this.bookManager = new BookManager();
        this.personManager = new PersonManager();
        this.searchService = new SearchService();
        this.fineService = new FineService();
        this.loginService = new LoginService();
        this.historyService = new HistoryService();
        this.databaseService = new DatabaseService();
    }

    public void addBook(Book b) {
        bookManager.addBookinLibrary(b);
    }
}
