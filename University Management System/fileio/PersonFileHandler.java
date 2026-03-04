package fileio;

import entity.Person;
import java.io.*;

//Handles file operations without using List

public class PersonFileHandler {

    private static final String FILE_PATH = "fileio/persons.txt";
    private static final int MAX = 50; 

    // CREATE
    public static void addPerson(Person person) throws IOException {
        File file = new File(FILE_PATH); 
        file.getParentFile().mkdirs(); 

        FileWriter fw = new FileWriter(file, true); 
        fw.write(person.toFileString() + "\n"); 
        fw.close(); 
    }
    //read all
    public static Person[] getAllPersons() throws IOException {
        Person[] persons = new Person[MAX]; 
        int index = 0; 

        File file = new File(FILE_PATH);
        if (!file.exists()) 
            return persons;

        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String line; 

        while ((line = br.readLine()) != null && index < MAX) { 
            persons[index] = Person.fromFileString(line); 
            index++; 
        }
        br.close(); 
        return persons; 
    }

    // SEARCH
    public static Person searchPerson(String id) throws IOException {
        Person[] persons = getAllPersons(); 
        for (int i = 0; i < persons.length; i++) { 
            if (persons[i] != null && persons[i].getId().equals(id)) { 
                return persons[i]; 
            }
        }
        return null; 
    }

    // UPDATE
    public static void updatePerson(Person updatedPerson) throws IOException {
        Person[] persons = getAllPersons(); 
        FileWriter fw = new FileWriter(FILE_PATH);

        for (int i = 0; i < persons.length; i++) { 
            if (persons[i] != null) { 
                if (persons[i].getId().equals(updatedPerson.getId())) { 
                    fw.write(updatedPerson.toFileString() + "\n"); 
                } else {
                    fw.write(persons[i].toFileString() + "\n"); 
                }
            }
        }
        fw.close();
    }

    // DELETE
    public static void deletePerson(String id) throws IOException {
        Person[] persons = getAllPersons(); 
        FileWriter fw = new FileWriter(FILE_PATH);

        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null && !persons[i].getId().equals(id)) { 
                fw.write(persons[i].toFileString() + "\n"); 
            }
        }
        fw.close();
    }
}