import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Search extends JFrame {
    private JTextField searchText;
    private JTextField txtID, txtName, txtPhoneNumber, txtCompanyName, txtSalary, txtBirthday;
    private int index;

    // Constructor
    public Search() {
        // making window
        setTitle("Search Contact");
        setSize(500, 500);
        setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Search Contact");
        titleLabel.setFont(new Font("", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(new Color(173, 216, 230));
        titleLabel.setOpaque(true);
        add(titleLabel, BorderLayout.NORTH);

        // SearchBar
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchText = new JTextField();
        searchText.setPreferredSize(new Dimension(200, 30));
        searchPanel.add(searchText);
        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(e -> searchContact());
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

        txtID.setEditable(false);
        txtName.setEditable(false);
        txtPhoneNumber.setEditable(false);
        txtCompanyName.setEditable(false);
        txtSalary.setEditable(false);
        txtBirthday.setEditable(false);

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

        

        // Cancel Button
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> this.dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(cancelBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void searchContact() {
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

   

    public static void searchContacts() {
        new Search();
    }
}
