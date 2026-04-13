package LMS;

import java.util.ArrayList;

public class PersonManager {

    private ArrayList<Person> persons = new ArrayList<>();

    public void addClerk(Clerk c){
        persons.add(c);
    }

    public void addBorrower(Borrower b){
        persons.add(b);
    }

    public ArrayList<Person> getPersons(){
        return persons;
    }
}