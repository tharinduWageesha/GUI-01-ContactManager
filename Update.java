import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Update extends JFrame {
    private JTextField searchText;
    private JTextField txtID, txtName, txtPhoneNumber, txtCompanyName, txtSalary, txtBirthday;
    private int index; // Declaring index as a field

    // Constructor
    public Update() {
        // making window
        setTitle("Update Contact");
        setSize(500, 500);
        setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Update Contact");
        titleLabel.setFont(new Font("", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(new Color(173, 216, 230)); // Sky Blue
        titleLabel.setOpaque(true);
        add(titleLabel, BorderLayout.NORTH);

        // SearchBar
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchText = new JTextField();
        searchText.setPreferredSize(new Dimension(200, 30));
        searchPanel.add(searchText);
        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(e -> updateContact());
        searchPanel.add(searchBtn);
        add(searchPanel, BorderLayout.NORTH);

        // Details Panel
        JPanel detailPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        
        // Initializing text fields
        txtID = new JTextField();
        txtName = new JTextField();
        txtPhoneNumber = new JTextField();
        txtCompanyName = new JTextField();
        txtSalary = new JTextField();
        txtBirthday = new JTextField();

        txtID.setEditable(false); // Making ID non-editable

        detailPanel.add(new JLabel("Name - "));
        detailPanel.add(txtName);

        detailPanel.add(new JLabel("Contact Number - "));
        detailPanel.add(txtPhoneNumber);

        detailPanel.add(new JLabel("Company - "));
        detailPanel.add(txtCompanyName);

        detailPanel.add(new JLabel("Salary - "));
        detailPanel.add(txtSalary);

        detailPanel.add(new JLabel("BirthDay - "));
        detailPanel.add(txtBirthday);

        add(detailPanel, BorderLayout.CENTER);

        // Update Button
        JButton updateBtn = new JButton("Update");
        updateBtn.addActionListener(e -> updateContactDetails());

        // Cancel Button
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> this.dispose()); // Close the window

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(updateBtn);
        buttonPanel.add(cancelBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void updateContact() {
        index = OOPDay03.contactList.searchByNameOrPhoneNumber(searchText.getText());
        if (index != -1) {
            Contact contact = OOPDay03.contactList.get(index);
            txtID.setText(contact.getId());
            txtName.setText(contact.getName());
            txtPhoneNumber.setText(contact.getPhoneNumber());
            txtCompanyName.setText(contact.getCompanyName());
            txtSalary.setText(String.valueOf(contact.getSalary()));
            txtBirthday.setText(contact.getBirthday());
        } else {
            JOptionPane.showMessageDialog(this, "No contacts found!");
        }
    }

    private void updateContactDetails() {
        String id = txtID.getText();
        String name = txtName.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String companyName = txtCompanyName.getText();
        double salary;
        try {
            salary = Double.parseDouble(txtSalary.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Salary");
            return;
        }
        String birthday = txtBirthday.getText();
        if (!ADD.isValidPhoneNumber(phoneNumber)) {
            JOptionPane.showMessageDialog(this, "Invalid Phone Number");
            return;
        }
        if (!ADD.isValidBirthday(birthday)) {
            JOptionPane.showMessageDialog(this, "Invalid Birthday");
            return;
        }
        if (!ADD.isValidSalary(salary)) {
            JOptionPane.showMessageDialog(this, "Invalid Salary");
            return;
        }
        Contact updatedContact = new Contact(id, name, phoneNumber, companyName, birthday, salary);
        OOPDay03.contactList.update(index, updatedContact);
        JOptionPane.showMessageDialog(this, "Contact updated Successfully");
        dispose();
    }

    public static void updateContacts() {
        new Update();
    }
}
