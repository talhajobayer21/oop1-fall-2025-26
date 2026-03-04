package entity;

public class Person {

    private String catagory; // Student/Faculty/adminastration
    private String name;     // talha,rakib,
    private String id;       //085545
    private String department; // cse/bba..,fs/fbs/fe...,accounts//security//managemnet//TA.
    private String mail;        //xya@gmail.com

    public Person(String catagory, String name, String id, String department, String mail) {
        this.catagory = catagory;
        this.name = name;
        this.id = id;
        this.department = department;
        this.mail = mail;
    }

    // Getters
    public String getCatagory() {
        return catagory;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getDepartment() {
        return department;
    }
    public String getMail() {
        return mail;
    }

    public String toFileString() {
        return catagory + "," + name + "," + id + "," + department + "," + mail;
    }
    
    public static Person fromFileString(String line) {
        String[] data = line.split(","); 
        if (data.length < 5) return null;
        return new Person(data[0], data[1], data[2], data[3], data[4]);
    }
}