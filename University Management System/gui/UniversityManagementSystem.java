package gui;

import entity.Person;
import fileio.PersonFileHandler;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

//gui
public class UniversityManagementSystem extends JFrame { 

    private JTextField txtCatagory, txtName, txtId, txtDepartment, txtMail;
    private JTextArea textArea;

    public UniversityManagementSystem() { 

        setTitle("University Management System"); 
        setSize(800, 600); 
        setLayout(new BorderLayout()); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        setLocationRelativeTo(null);

     
        JPanel inputPanel = new JPanel(new GridLayout(6, 2)); 
        Color skyColor = new Color(173, 216, 230);//bg color sky
        inputPanel.setBackground(skyColor);
        inputPanel.add(new JLabel("Catagory:")); 
        txtCatagory = new JTextField(); 
        txtCatagory.setBackground(skyColor);//color change
        inputPanel.add(txtCatagory); 
       
        inputPanel.add(new JLabel("Name:"));//color change
        txtName = new JTextField(); 
        txtName.setBackground(skyColor);
        inputPanel.add(txtName); 

        inputPanel.add(new JLabel(" ID:")); 
        txtId = new JTextField(); 
        txtId.setBackground(skyColor);//color change
        inputPanel.add(txtId); 

        inputPanel.add(new JLabel("Department:")); 
        txtDepartment = new JTextField(); 
        txtDepartment.setBackground(skyColor);//color change
        inputPanel.add(txtDepartment); 

        inputPanel.add(new JLabel("Mail:")); 
        txtMail = new JTextField(); 
        txtMail.setBackground(skyColor);//color change
        inputPanel.add(txtMail); 

        JButton btnAdd = new JButton("Add"); 
        JButton btnSearch = new JButton("Search"); 

        inputPanel.add(btnAdd); 
        inputPanel.add(btnSearch); 

        add(inputPanel, BorderLayout.NORTH); 

        // Output Area
        textArea = new JTextArea(); 
        textArea.setBackground(skyColor);   // background color
        textArea.setForeground(Color.BLACK);   // text color
        add(new JScrollPane(textArea), BorderLayout.CENTER); 

        // Button Panel
        JPanel buttonPanel = new JPanel(); 
        Color deepGreen = new Color(1, 99, 1);
        JButton btnView = new JButton("View All"); 
        JButton btnUpdate = new JButton("Update"); 
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBackground(Color.RED);
        btnDelete.setForeground(Color.WHITE);
        btnAdd.setBackground(deepGreen);
        btnAdd.setForeground(Color.WHITE);
        btnView.setBackground(deepGreen);         //color
        btnView.setForeground(Color.WHITE);
        btnUpdate.setBackground(deepGreen);
        btnUpdate.setForeground(Color.WHITE);
        btnSearch.setBackground(deepGreen);
        btnSearch.setForeground(Color.WHITE);


        buttonPanel.add(btnView); 
        buttonPanel.add(btnUpdate); 
        buttonPanel.add(btnDelete); 
        add(buttonPanel, BorderLayout.SOUTH); 

        // Actions
        btnAdd.addActionListener(e -> addPerson()); 
        btnView.addActionListener(e -> viewPerson()); 
        btnSearch.addActionListener(e -> searchPerson()); 
        btnUpdate.addActionListener(e -> updatePerson()); 
        btnDelete.addActionListener(e -> deletePerson()); 

        setVisible(true); 
    }

    private void addPerson() { 
        try {
         
            Person p = new Person(
                    txtCatagory.getText(),
                    txtName.getText(),
                    txtId.getText(),
                    txtDepartment.getText(),
                    txtMail.getText()); 
            PersonFileHandler.addPerson(p); 
            JOptionPane.showMessageDialog(this, "Person Added"); 
        } catch (IOException ex) {
            ex.printStackTrace(); 
        }
    }

    private void viewPerson() { 
        try {
            textArea.setText(""); 
            Person[] persons = PersonFileHandler.getAllPersons(); 
            for (int i = 0; i < persons.length; i++) { 
                if (persons[i] != null) { 
                textArea.append(
                     " ------ "    + persons[i].getCatagory() + " ------\n" +
                    "Name       : " + persons[i].getName() + "\n" +
                    "ID         : " + persons[i].getId() + "\n" +
                    "department : " + persons[i].getDepartment() + "\n" +
                    "mail       : " + persons[i].getMail() + "\n\n"
                 );
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(); 
        }
    }

     private void searchPerson() { // Search student method
        try {
            Person p = PersonFileHandler.searchPerson(txtId.getText()); // Search student by ID
            if (p != null) {
                textArea.setText(
                    " ------ "  + p.getCatagory() + " ------\n "+
                    "Name       : " + p.getName() + "\n" +
                    "ID         : " + p.getId() + "\n" +
                    "department : " + p.getDepartment() + "\n" +
                    "mail       : " + p.getMail() + "\n\n"
                 );
            } else {
                textArea.setText("Student Not Found");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void updatePerson() { 
        try {
            Person p = new Person(
                    txtCatagory.getText(),
                    txtName.getText(),
                    txtId.getText(),
                    txtDepartment.getText(),
                    txtMail.getText());
            PersonFileHandler.updatePerson(p); 
            JOptionPane.showMessageDialog(this, "Person Updated");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void deletePerson() { 
        try {
            PersonFileHandler.deletePerson(txtId.getText()); 
            JOptionPane.showMessageDialog(this, "Person Deleted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}