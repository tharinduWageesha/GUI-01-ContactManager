import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

class ADD extends JFrame {    
    private JTextField txtName, txtPhoneNumber, txtCompanyName, txtSalary, txtBirthday;
    private JLabel lblmessage, contactID;

    public ADD() {
        setTitle("ADD Contact");
        setSize(400, 400);
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("ADD Contact");
        titleLabel.setFont(new Font("", Font.BOLD, 50));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel, BorderLayout.NORTH);
        add(titlePanel, BorderLayout.NORTH);

        JPanel DetailPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        
        DetailPanel.add(new JLabel("Contact ID - ")); 
        contactID = new JLabel(OOPDay03.generateId());
        DetailPanel.add(contactID);

        DetailPanel.add(new JLabel("Name - "));
        txtName = new JTextField();
        DetailPanel.add(txtName);

        DetailPanel.add(new JLabel("Phone Number - "));
        txtPhoneNumber = new JTextField();
        DetailPanel.add(txtPhoneNumber);

        DetailPanel.add(new JLabel("Company Name - "));
        txtCompanyName = new JTextField();
        DetailPanel.add(txtCompanyName);

        DetailPanel.add(new JLabel("Salary - "));
        txtSalary = new JTextField();
        DetailPanel.add(txtSalary);

        DetailPanel.add(new JLabel("Birthday - "));
        txtBirthday = new JTextField();
        DetailPanel.add(txtBirthday);

        lblmessage = new JLabel();
        DetailPanel.add(lblmessage);

        JButton btnAdd = new JButton("ADD");
        btnAdd.addActionListener(e -> addContact());
        DetailPanel.add(btnAdd);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> dispose());
        DetailPanel.add(btnCancel);

        add(DetailPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0') {
            for (int i = 1; i < phoneNumber.length(); i++) {
                if (!Character.isDigit(phoneNumber.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    public static boolean isValidBirthday(String birthday) {
        try {
            LocalDate date = LocalDate.parse(birthday);
            LocalDate currentDate = LocalDate.now();
            return !date.isAfter(currentDate);
        } catch (Exception e) {
            return false;
        }
    }

    private void addContact() {
        String id = contactID.getText();
        String name = txtName.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String companyName = txtCompanyName.getText();
        double salary;

        try {
            salary = Double.parseDouble(txtSalary.getText());
        } catch (NumberFormatException ex) {
            lblmessage.setText("Invalid Salary");
            return;
        }

        String birthday = txtBirthday.getText();

        if (!isValidPhoneNumber(phoneNumber)) {
            lblmessage.setText("Invalid Phone Number");
            return;
        }

        if (!isValidBirthday(birthday)) {
            lblmessage.setText("Invalid Birthday");
            return;
        }

        if (!isValidSalary(salary)) {
            lblmessage.setText("Invalid Salary");
            return;
        }

        Contact contact = new Contact(id, name, phoneNumber, companyName, birthday, salary);
        OOPDay03.contactList.add(contact);
        lblmessage.setText("Contact added Successfully");
        clearFields();
        contactID.setText(OOPDay03.generateId());
    }

    private void clearFields() {
        txtName.setText("");
        txtPhoneNumber.setText("");
        txtCompanyName.setText("");
        txtSalary.setText("");
        txtBirthday.setText("");
    }

    public static void addContacts() {
        new ADD();
    }
}
